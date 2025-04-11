import java.util.*;

class BoxStacking{
    static int dp[];
    public static int stack(int arr[][])
    {
        int height,maxHeight=0;
        for(int i=0;i<arr.length;i++)
        {
            height=arr[i][2];
            for(int j=0;j<i;j++)
            {
                if(arr[i][0]<arr[j][0])
                {
                    continue;
                }
                if(arr[i][1]<arr[j][1])
                {
                    continue;
                }
                if(arr[i][2]<arr[j][2])
                {
                    continue;
                }
                height=Math.max(height,arr[i][2]+arr[j][2]);
                maxHeight=Math.max(height,maxHeight);
            }
        }
        return maxHeight;
    }
    public static void main(String[] args) {
        int arr[][]={{2,1,2},{3,2,3},{2,2,8},{2,3,4},{2,2,1},{4,4,5}};
        dp=new int[arr.length];
        Arrays.sort(arr,new Comparator<int []>() {
            // override compare
            public int compare(int[]a,int b[])
            {
                return Integer.compare(a[2], b[2]);
            }
        });
        int maxHeight=stack(arr);
        System.out.print(maxHeight);
    }   
}