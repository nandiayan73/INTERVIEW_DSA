import java.util.ArrayList;
import java.util.Stack;

class GraphNode{
    GraphNode next;
    int val;
    GraphNode (int value)
    {
        val=value;
    }
    GraphNode (int value,GraphNode node)
    {
        val=value;
        next=node;
    }
}
public class CycleCheck {
    static Stack <GraphNode> stack=new Stack<>();
    
       // a->b->c->d-->
        //|        // |
       // |-----------<
    public static  boolean check(GraphNode root)
    {
        stack.push(root);
        ArrayList <GraphNode> g=new ArrayList<>();
        while(stack.size()>0)
        {
            GraphNode temp=stack.pop();
            if(g.contains(temp))
            {
            return true; 
            }
            g.add(temp);
            if(temp.next!=null)
                stack.push(temp.next);
        }
        return false;
    }
    public static void main(String[] args) {
        GraphNode a=new GraphNode(5);
        GraphNode b=new GraphNode(5);
        GraphNode c=new GraphNode(5);
        GraphNode d=new GraphNode(5);
        a.next=b;
        b.next=c;
        c.next=d;
        // d.next=a;

        // Checking for cycle:
        System.out.println(check(a));
        


    }



}
