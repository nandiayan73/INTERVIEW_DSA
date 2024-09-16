class CycleCheck
{
    public static boolean isCycle(int [][] graph)
    {

    }
    public static void main(String[] args) {
        
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 4},
            {4, 0} // This edge creates a cycle
        };
        System.out.println(isCycle(edges));
    }
}