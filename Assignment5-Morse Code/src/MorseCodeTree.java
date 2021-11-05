import java.util.ArrayList;

/**This is a MorseCodeTree which is specifically used for the conversion of morse code to english It relies on a root
 * (reference to root of the tree) The root is set to null when the tree is empty. The class uses an external generic
 * TreeNode class which consists of a reference to the data and a reference to the left and right child. The TreeNode
 * is parameterized as a String, TreeNode This class uses a private member root (reference to a TreeNode)
 * The constructor will call the buildTree method
 * */

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
    TreeNode<String> root;

    /**
     * The constructor will call the buildTree method
     * */
    public MorseCodeTree() {
       buildTree();
    }//DONE

    /**
     * Returns a reference to the root
     *
     * @return reference to root
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    } //DONE

    /**
     * sets the root of the Tree
     *
     * @param newNode a TreeNode<T> that will be the new root
     */
    @Override
    public void setRoot(TreeNode<String> newNode) {
        this.root= new TreeNode<String>(newNode);

    }//DONE

    /**
     * This method builds the LinkedConverterTree by inserting TreeNodes<T>
     * into their proper locations
     * using the insert method
     */
    @Override
    public void buildTree() {
        //Set new root
        root= new TreeNode<String>("");//Do not put extra space on the root
        //insert letter at the right position

        //Level1                       (e)  (t)
        insert(".","e");
        insert("-","t");

        // Level2                    (i,a)    (n,m)
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");

        //Level3                 (s,u) (r,w) (d,k)  (g,o)

        //testing purpose:
       // System.out.println("crashing before s");

        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");

        //Level4  (h,v) (f,null) (l,null)  (p,j) (b,x) (c,y) (z,q)  (null,null)
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");


    } //DONE

    /**
     * Adds result to the correct position in the tree based on the code
     * This method will call the recursive method addNode
     *
     * @param code   the code for the new node to be added
     * @param result
     * @return the linkedConverterTree with the new node added
     */
    @Override
    public MorseCodeTree insert(String code, String result) {
        addNode(root,code,result);
        return this;
    } //DONE

    /**
     * This is a recursive method that adds element to the correct position
     * in the tree based on the code.
     *
     * This is a recursive method that adds element to the correct position in the tree based on the code. A '.' (dot) means traverse to the left.
     * A "-" (dash) means traverse to the right. The code ".-" would be stored as the right child of the left child of the root Algorithm for the recursive method:
     * 1. if there is only one character
     * a. if the character is '.' (dot) store to the left of the current root
     * b. if the character is "-" (dash) store to the right of the current root
     * c. return
     * 2. if there is more than one character
     * a. if the first character is "." (dot) new root becomes the left child
     * b. if the first character is "-" (dash) new root becomes the right child
     * c. new code becomes all the remaining charcters in the code (beyond the first character)
     * d. call addNode(new root, new code, letter)
     *
     * @param root   the root of the tree for this particular recursive instance of addNode
     * @param code   the code for this particular recursive instance of addNode
     * @param letter the data of the new TreeNode to be added
     */
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        //if L <== e(.)     |            t(-)==> R
        //Description of code: if the code is 1 char. (level 1 ==> e(go root.left == new treeNode<String>(letter){add the letter in the parameter} or t

        //testing purpose:
        // System.out.println(root);

        if(code.length()==1){//checking the Length not the code.char(0)==1 is wrong b/c it's either a dash (-) or a (.) never 1.
            if(code.charAt(0)=='.'){
                root.left= new TreeNode<String>(letter);

            }else if (code.charAt(0)=='-'){
                root.right= new TreeNode<String>(letter);
            }
        }
        //Now if the code contains more than 1 letter or char
        else if (code.length()>1){
            //if the first character is a '.' then call method add with the L side of the tree, pass to other char.
            if(code.charAt(0)=='.'){
                       //SUBSTRING QUICK LESSON: For example – "Chaitanya".substring(1) would return "Haitanya".
                addNode(root.left,code.substring(1),letter);
            }
            else if( code.charAt(0)=='-'){
                addNode(root.right,code.substring(1),letter);
            }
        }

    }//DONE

    /**
     * Fetch the data in the tree based on the code
     * This method will call the recursive method fetchNode
     *
     * @param code the code that describes the traversals within the tree
     * @return the result that corresponds to the code
     */
    @Override
    public String fetch(String code) {

        return fetchNode(root,code);
    } ///DONE

    /**
     * This is the recursive method that fetches the data of the TreeNode
     * that corresponds with the code
     *
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of fetchNode
     * @return the data corresponding to the code
     */
    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        if(code.length()==1){
            if(code.equals(".")){
                return root.left.getData();
            }
            else if(code.equals("-")){
                return root.right.getData();
            }
        }
        else if(code.length()!=1) {
            if(code.charAt(0)=='.'){
                //code -1 character
               return fetchNode(root.left,code.substring(1));
            }
            else if (code.charAt(0)=='-'){
                //code -1 character
               return fetchNode(root.right,code.substring(1));
            }

        }
      return null;
    }//DONE

    /**
     * This operation is not supported for a LinkedConverterTree
     *
     * @param data data of node to be deleted
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */
    @Override
    public MorseCodeTree delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }//DONE

    /**
     * This operation is not supported for a LinkedConverterTree
     *
     * @return reference to the current tree
     * @throws UnsupportedOperationException();
     */
    @Override
    public MorseCodeTree update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }//DONE



    /**
     * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
     * Used for testing to make sure tree is built correctly
     *
     * @return an ArrayList of the items in the linked Tree
     */
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> listOfTree = new ArrayList<String>();
        LNRoutputTraversal(root,listOfTree);
        return listOfTree;
    }//DONE

    /**
     * The recursive method to put the contents of the linked converter tree in an ArrayList<T>
     * LNR (Inorder)
     *
     * @param root the root of the tree for this particular recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR order
     */
    @Override
    //T.Q: can you please explain=> got answer out of the internet
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
    //(Inorder) ==> Left-> Root--> Right
        if(root==null){
            return ;
        }
        //traverse left
        LNRoutputTraversal(root.left,list);

        list.add(root.data);

        //traverse right
        LNRoutputTraversal(root.right,list);


    } //DONE
}
