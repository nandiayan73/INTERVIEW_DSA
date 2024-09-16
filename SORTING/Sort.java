class Sort
{
    public static void BubbleSort(int arr[])
    {
        int flag;
        for(;;)
        {
            flag=0;
            for(int i=0;i<arr.length-1;i++)
            {
                if(arr[i]>arr[i+1])
                {
                    // swap
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    flag=1;
                }
            }
            if(flag==0)
            {
                return;
            }
        }
    }
    public static void printArray(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+"\t");
        }
    }
    public static void SelectionSort(int arr[])
    {
        int min,temp;
        for(int i=0;i<arr.length-1;i++)
        {
            min=i;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]<arr[min])
                {
                    min=j;
                }
            }
            temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }
    public static void InsertionSort(int arr[])
    {
        int key,j;
        for(int i=0;i<arr.length;i++)
        {
            key=arr[i];
            j=i-1;
            while(j>=0 && arr[j]>key)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    public static void main(String[] args) {
        int arr[]={5,6,4,7,3,8,2,1};
        // Bubble Sort : The big bubble comes up first, the big number comes up first,followed by the other big numbers.
        // BubbleSort(arr);
        
        
        // Selection Sort: The smallest element comes up first, followed by the largest elements.
        // SelectionSort(arr);

        // Insertion Sort: Take the first element as sorted, insert the next elements after that.
        // 5 6 4 key=4
        // 5 6 6 
        // 5 5 6 
        // 4 5 6
        // After the first pass: {5, 6, 4, 7, 3, 8, 2, 1}
        // After the second pass: {4, 5, 6, 7, 3, 8, 2, 1}
        // After the third pass: {4, 5, 6, 7, 3, 8, 2, 1}
        // After the fourth pass: {3, 4, 5, 6, 7, 8, 2, 1}
        // After the fifth pass: {2, 3, 4, 5, 6, 7, 8, 1}
        // After the sixth pass: {1, 2, 3, 4, 5, 6, 7, 8}
        InsertionSort(arr);


        printArray(arr);
    }
}