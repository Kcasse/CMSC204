import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MorseCodeConverter {

    public static MorseCodeTree morseTree = new MorseCodeTree();



    /**
     * returns a string with all the data in the tree in LNR order with an space in between them.
     * Uses the toArrayList method in MorseCodeTree It should return the data in this order:
     * "h s v i f u e l r a p w j b d x n c k y t z g q m o"
     * Note the extra space between j and b - that is because there is an empty string that is the root,
     * and in the LNR traversal, the root would come between the right most child of the left tree (j) and the left most child of the right tree (b).
     * This is used for testing purposes to make sure the MorseCodeTree has been built properly
     * Returns:
     * */
    public static String printTree(){
        //Dummy string variable to store the letters  followed by a space
        String  TreeLetters ="";

       ArrayList<String> treeList = morseTree.toArrayList();
       //Loop through the treeList add every letter to the array next to a space
        for(String MorseCharacter: treeList){
            TreeLetters+=MorseCharacter+" ";
        }
        System.out.println(TreeLetters.trim());
                return TreeLetters;
    } //DONE
    /**
     * Converts Morse code into English. Each letter is delimited by a space (‘ ‘).
     * Each word is delimited by a ‘/’.
     * Example:
     * code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
     * string returned = "Hello World"
     * @param code
     * @return the English translation
     * */

    public static String convertToEnglish(String code){
        //Create a stringBuilder (b/c of append method)
        StringBuilder englishTranslated= new StringBuilder();
        //Let use the split the code to get the n# of words
        String [] characters;// Array of what corresponds to each letters
        String [] completeword = code.split(" / ");//Array of what corresponds to each words

        //we need to loop through the words and get each "letter"
        for (String oneWord: completeword) {
            //differentiate each character by a space
          characters=oneWord.split(" ");  //output: "....", "."and so on
            //we need to basically get the translation/oneWord/data or each character
            for(String oneCharacter: characters){//"...." ==>
                //fetch method takes code and return the data(letter)
                englishTranslated.append(morseTree.fetch(oneCharacter));//==> H
            }
            //Finish translating a word add space for next word
            englishTranslated.append(" ");

        }
        //return complete english translation
        return englishTranslated.toString().trim();
    }

    /**
     * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘).
     * Each word is delimited by a ‘/’.
     * Example:
     * a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
     * string returned = "Hello World"
     * @param codeFile
     * @return the English translation of the file
     * */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException{
        String sentence="";

    //reading all the lines in our txt;
        Scanner scanner=new Scanner(codeFile);
        while(scanner.hasNext()){
           sentence+= convertToEnglish(scanner.nextLine());// read file
        }
        return sentence;
    }
}
