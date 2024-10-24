import java.util.ArrayList;

public class CheckForCycle {
    static int visited[],isPath[];
    private static boolean cycleCheck(int subjects[],ArrayList<ArrayList<Integer>> adj ,int i)
    {
        visited[i]=1;
        isPath[i]=1;
        while(i<subjects.length)
        {
            if(visited[i]==0)
            {
                for(int it:adj.get(i))
                {
                    if(cycleCheck(subjects, adj, it))
                    {
                        return true;
                    }
                }
            }
            else if(visited[i]==1)
            {
                if(isPath[i]==1)
                    return true;
            }
            i++;
        }
        isPath[i]=0;
        return false;
    }
    public static void main(String[] args) {
        int graph[][]={{1,2},{1,4},{3,4},{4,2},{2,3}};
        int subjects=4;
        visited=new int[subjects];
        isPath=new int[subjects];
        ArrayList <ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<subjects;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int row[]:graph)
        {
            ArrayList <Integer> arr= adj.get(row[0]-1);
            arr.add(row[1]);
            adj.set(row[0]-1, arr);
        }
        int n[]={1,2,3,4};
        System.out.println(cycleCheck(n, adj, 0));
    }
}