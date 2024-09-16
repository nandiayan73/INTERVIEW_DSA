#include<stdio.h>
#include<stdlib.h>
struct Node{
    int data;
    struct Node *next;
};
typedef struct Node node;
int  main()
{
    node *a[10];
    int n;
    for(int i=0;i<10;i++)
    {
        a[i]=NULL;
    }
    for(int i=0;i<3;i++)
    {
        printf("Enter the value to be stored:\t");
        node *temp=(node *)malloc(sizeof(node));
        if (temp == NULL) {  // Check if malloc was successful
            printf("Memory allocation failed!\n");
            return 1;
        }
        scanf("%d",&temp->data);
        temp->next=NULL;
        if(a[(temp->data)%10]==NULL)
            a[(temp->data)%10]=temp;
        else{
            node *prev=a[temp->data%10];
            while(prev->next!=NULL)
            {
                prev=prev->next;
            }
            prev->next=temp;
        }
    }
    printf("ENter the element to be searched:\t");
    scanf("%d",&n);

    if (a[n%10] != NULL) {
        printf("First element in bucket: %d\n", a[n%10]->data);
    } else {
        printf("Bucket is empty.\n");
        return 1;
    }
    node *p=a[n%10];
    printf("%d",a[n%10]->data);
    while(p!=NULL)
    {
        if(p->data==n)
        {
            printf("FOund");
            return 1;
        }
        p=p->next;
    }
    printf("Not found!");

}