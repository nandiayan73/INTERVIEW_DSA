import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class GraphNode{
    GraphNode left=null,right=null;
    int val;
    GraphNode (int value)
    {
        val=value;
    }
    GraphNode (int value,GraphNode l, GraphNode r)
    {
        val=value;
        left=l;
        right=r;
    }
}
class BFSDFS
{
    static Queue<GraphNode> q=new LinkedList<>();
    static Stack <GraphNode> stack=new Stack<>();

    public static void BFS()
    {
        while(q.size()>0)
        {
            GraphNode temp=q.poll();
            System.out.println(temp.val);
            if(temp.left!=null)
                q.offer(temp.left);
            if(temp.right!=null)
                q.offer(temp.right);
        }
    }
    public static void DFS()
    {
        while(stack.size()>0)
        {
            GraphNode temp=stack.pop();
            System.out.println(temp.val);
            if(temp.right!=null)
                stack.push(temp.right);
            if(temp.left!=null)
                stack.push(temp.left);
        }
    }

    
    public static void main(String[] args) {
        GraphNode a=new GraphNode(5);
        GraphNode b=new GraphNode(4);
        GraphNode c=new GraphNode(6);
        GraphNode d=new GraphNode(3);
        GraphNode e=new GraphNode(2);
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        
     

        // bfs
        System.out.println("Breadth First Search:");
        q.offer(a);
        BFS();
        
        //dfs
        System.out.println("Depth First Search:");
        stack.push(a);
        DFS();

    }
}