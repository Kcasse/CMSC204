public class StackOverflowException extends RuntimeException{

        public StackOverflowException (){
            super("Top or pop method called on empty stack");

        }

}
