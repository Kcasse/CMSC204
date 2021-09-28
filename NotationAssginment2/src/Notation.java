import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;



public class Notation {

    private static NotationQueue<String> myQueue;
    private static NotationStack<String> myStack;
    //Constructor
    public Notation(){};


    //Method
    public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException{
        String InfixToPostfix= convertInfixToPostfix(infixExpr);
        double infixToPostfixEval = evaluatePostfixExpression(InfixToPostfix);
        return infixToPostfixEval;
    }
    /**  Convert an infix expression into a postfix expression
     * @author Khar Casse
     * @param infix
     * @return postfix
     */

   public  static String convertInfixToPostfix(String infix ) throws InvalidNotationFormatException {
       //Create a stack and queue object
       myQueue = new NotationQueue<>(infix.length());
       myStack = new NotationStack<>(infix.length());


       for (int q = 0; q < infix.length(); q++) {
           char currentChar = infix.charAt(q);

           //if space
           if (currentChar == ' ') {
               continue;
           }
           //if number
           else if (isDigit(currentChar)) {
               //DEBUG
               System.out.println(" adding digit " + currentChar);
               myQueue.enqueue(currentChar + "");// transform a char to a string

           }
           //if left parenthesis
           else if (currentChar == '(') {
               //push onto stack
               myStack.push(currentChar + "");
           }
           //if operator
           else if (isOperator(currentChar)) {
               //if stack is not empty
               if (myStack.isEmpty()) {
                   myStack.push(currentChar + "");
               } else if (isHigherEqualPrecedence(myStack.top().charAt(0)) < isHigherEqualPrecedence(currentChar)) {
                   myStack.push(currentChar + "");
               } else {
                   //CLEAR EQUAL OR HIGHER PREC. FROM STACK TO QUEUE
                   while (isHigherEqualPrecedence(myStack.top().charAt(0)) >= isHigherEqualPrecedence(currentChar)) {
                       //DEBUG
                       System.out.println(" adding operator " + currentChar);
                       myQueue.enqueue(myStack.pop());
                   }

                   myStack.push(currentChar + "");
               }


           }
                         //If right parenthesis
           else if (currentChar == ')') {
               while (!myStack.isEmpty() && isOperator(myStack.top().charAt(0))) {
                   //DEBUG
                   System.out.println("Adding to queue " + myStack.top().charAt(0));
                   myQueue.enqueue(myStack.pop());

               }
               if (!myStack.isEmpty() && myStack.top().equals("(")) {
                   myStack.pop();
               } else {
                   //DEBUG
                   System.out.println(" Printing current char " + currentChar);
                   System.out.println(" Print stack: " + myStack);
                   System.out.println("print queue: " + myQueue);
                   throw new InvalidNotationFormatException();

               }

           }
       }
            // empty stack and add the rest to the queue
           while (!myStack.isEmpty()) {
               //DEBUG
               System.out.println(" clearing out rest of stack ");
               myQueue.enqueue(myStack.pop());
           }



       return myQueue.toString();
   }

    /**
     * Convert the Postfix expression to the Infix expression
     * @author Khar Casse
     * @param postfix
     * @return infix
     */

    static String convertPostfixToInfix(String postfix ) throws InvalidNotationFormatException
    {
        //Create a stack and queue object
        myQueue = new NotationQueue<>(postfix.length());
        myStack= new NotationStack<>(postfix.length());

        //Loop through string
        for(int i=0; i< postfix.length(); i++)
        {
             char currentChart= postfix.charAt(i);
            String a;
            String b, c;

             if(currentChart==' '){

                 continue;
             }
             if(isDigit(currentChart)){
                 myStack.push(currentChart+"");
             }
             if(isOperator(currentChart))
             {
                    //stop
                 try
                 {
                     a= myStack.pop();
                     b=myStack.pop();
                     c= "("+b+currentChart+a+")";
                     myStack.push(c);
                 }catch (Exception e)
                 {
                     throw new InvalidNotationFormatException();
                 }



             }


        }
        if(myStack.size() != 1){
            throw new InvalidNotationFormatException();
        }


        return myStack.pop();

    } //DONE and working




    /**
     * Convert the Postfix expression to the Infix expression
     * @author Khar Casse
     * @param postfixExpr
     * @return postfixNum
     */
    public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{

        //Create a stack and queue object
        myQueue = new NotationQueue<>(postfixExpr.length());
        myStack= new NotationStack<>(postfixExpr.length());


        //loop through the string exp.

        for(int i=0; i< postfixExpr.length(); i++)
        {
            String a,b,c;
            char currentchart= postfixExpr.charAt(i);
             //If space continue

            if(currentchart==' '){
                continue;
            }
            else if (isDigit(currentchart)  || currentchart=='('){
                //push on the stack
                myStack.push(currentchart+"");
            }
            else if(isOperator(currentchart)){
                    //stop
                try
                {
                    a= myStack.pop();
                    b=myStack.pop();
                    c= calculate(b,a,currentchart);
                    myStack.push(c);
                }catch (Exception e)
                {
                    throw new InvalidNotationFormatException();
                }



            }




        }

        if(myStack.size()!=1){
            throw new InvalidNotationFormatException();
        }
        return Double.parseDouble(myStack.pop());

    }
    /**  Check if the string is a digit
     * @author Khar Casse
     * @param character
     * @return boolean
     */
    public static boolean isDigit(char character ){
     try{
         return character >= 48 && character <= 57;
     }catch (Exception e)
     {
         return false;
     }

    }

    /**  Check if the string is an operator
     * @author Khar Casse
     * @param character
     * @return boolean
     */
    static boolean isOperator (char character ){
        switch (character){
            case'+':
            case'-':
            case'*':
            case'/':
                return true;
        }
        return false;
    }

    /** Create a higher precedence method
     * @param character
     * @return int
     * */
  // return 1 * or/, 0 + or - , -1
    public   static int isHigherEqualPrecedence(char character){
        if(character=='*' || character== '/'){
            return 1;
        }
        else if (character=='+' || character== '-'){
            return 0;

        }
         return -1;
    }


    /**
     * Calculate two number and returning a string
     * @param firstOperand
     * @param secondOperand
     * @param operator
     * @return String with finih product
     * */

    public static String calculate(String firstOperand, String secondOperand, char operator) throws InvalidNotationFormatException{

        double a = Double.parseDouble(firstOperand );
        double b = Double.parseDouble(secondOperand );

        if(operator== '+'){
            return String.valueOf(a+b);
        }
        else  if(operator== '-'){
            return String.valueOf(a-b);
        }
        else if (operator== '*'){
            return String.valueOf(a*b);
        }
        else if (operator== '/'){
            if(b==0){
                throw new InvalidNotationFormatException();
            }
             return String.valueOf(a/b);
        }
        return null;

    }




}
