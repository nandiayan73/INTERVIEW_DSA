
class TreeNode
{
    int val,height;
    TreeNode left=null,right=null;
    TreeNode(int value)
    {
        val=value;
        height=1;
    }

}

class BST
{
    public static int height(TreeNode node)
    {
        if(node==null)
            return 0;
        else
        {
            return node.height;
        }
    }
    public static TreeNode insert(TreeNode root,int value)
    {
        //insertion
        if(root==null)
            return new TreeNode(value);
        if(root.val>value)
            root.left=insert(root.left,value);
        else if(root.val<value)
            root.right=insert(root.right, value);
        else //Discarding the duplicate values:
            return root;

        // Updating the height
        root.height=1+Math.max(height(root.left),height(root.right));

        // returning the node
        return root;

    }
    public static void inOrder(TreeNode root)
    {
        if(root.left!=null)
            inOrder(root.left);
        System.out.println("value:\t"+root.val+" height:\t"+root.height);
        if(root.right!=null)
            inOrder(root.right);
    }
    public static void main(String[] args) {
        TreeNode a =new TreeNode(5);
        insert(a, 4);
        insert(a, 6);
        insert(a, 3);
        inOrder(a);


        
    }
}