
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

class AVL
{
    // return  the height:
    public static int height(TreeNode node)
    {
        if(node==null)
            return 0;
        else
        {
            return node.height;
        }
    }

    // return the balance of the node:
    public static int getBalance(TreeNode node)
    {
        if(node==null)
            return 0;
        return height(node.left)-height(node.right);
    }


    // Rotations:

    // Left-Rotation 
    public static TreeNode leftRotation(TreeNode x)
    {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }
    // Right-Rotation 
    public static TreeNode rightRotation(TreeNode x)
    {
        TreeNode y = x.left;
        TreeNode T2 = y.right;   

        // Swap:
        x.left=T2;
        y.right=x;

        // update the heights:
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;


        // return the new root:
        return y;

    }
    // Insertion 
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

        // Check the balance-factor of the node:
        int balance=getBalance(root);

        // Left imbalance:right-rotation
        if(balance>1 && value<root.left.val)
            return rightRotation(root);
        // left-right imbalance:left-right rotation
        if(balance>1 && value>root.left.val)
        {
            root.left=leftRotation(root.left);
            return rightRotation(root);
        }

        // Right imbalance:left rotation
        if(balance<-1 && value>root.right.val)
        return leftRotation(root);
        // Right-left imbalance: right-left rotation
        if(balance<-1 && value<root.right.val)
        {
            root.left=leftRotation(root.left);
            return rightRotation(root);
        }
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
    public static void preOrder(TreeNode root)
    {
        System.out.println("value:\t"+root.val+" height:\t"+root.height);
        if(root.left!=null)
            preOrder(root.left);
        if(root.right!=null)
            preOrder(root.right);
    }
    public static void main(String[] args) {
        TreeNode a =new TreeNode(5);
        a=insert(a, 4);
        a=insert(a, 3);
        preOrder(a);
    }
}