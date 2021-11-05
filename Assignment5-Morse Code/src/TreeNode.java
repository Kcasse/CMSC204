import com.sun.source.tree.Tree;

public class TreeNode <T>{
    protected T data;
    protected TreeNode<T> left; //left it a node in itself
    protected TreeNode<T> right; //right is also a node in itself


    /**Create a new TreeNode with left and
     *  right child set to null and data set to the dataNode
     * @param dataNode
     * */
    public TreeNode(T dataNode){
        this.data= dataNode;
        this.right = null;
        this.left= null;
    }
    /**Used for making deep copies
     * @param node
     * */
    public TreeNode( TreeNode<T> node){
        this.data= node.data;
        this.left= node.left;
        this.right= node.right;

    }

    public T getData() {
        return data;
    }


    //testing purpose:
    @Override
    public String toString() {
        String str=  "TreeNode{" +
                "data=" + data +
                "left= ";

        if(left==null){
          str+=" null";
        }
        else{
            str+=left.data;
        }
        if(right==null){
            str+=", Right= null";
        }
        else{

            str+=", Right= "+right.data;

        }
        str+="}";
        return str;

    }
}
