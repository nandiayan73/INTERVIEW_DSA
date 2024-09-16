class HeapSort
{
    public static void buildHeap(int arr[],int n)
    {
        for(int i=1;i<n;i++)
        {
            if(2*i<n && arr[i]<arr[2*i])
            {
                int temp=arr[i];
                arr[i]=arr[2*i];
                arr[2*i]=temp;
            }
            if(2*i+1<n && arr[i]<arr[2*i+1])
            {
                int temp=arr[i];
                arr[i]=arr[2*i+1];
                arr[2*i+1]=temp;
            }
            else{
                break;
            }
        }
        Sort(arr,n);
    }
    public static void Sort(int arr[],int n)
    {   
        int temp=arr[1];
        arr[1]=arr[n-1];
        arr[n-1]=temp;
    }
    public static void main(String[] args) {
        int arr[]={7,9,2,5,6};
        int n=arr.length;
        // buildHeap(arr,n);
        while(n>1)
        {
            buildHeap(arr,n);
            n--;
        }
        for(int i=1;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }

    }
}