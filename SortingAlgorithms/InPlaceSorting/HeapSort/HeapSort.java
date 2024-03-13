package SortingAlgorithms.InPlaceSorting.HeapSort;

// Time Complexity :O(nlog(n)) ;            Space Complexity : 0(1);

// InPlace Sorting     And     UnStable Sorting

public class HeapSort {

    public static void Heapify(int a[],int n,int i){

        int Largest=i;
        int left =2*i+1;
        int right=2*i+2;

        if(left<=n && a[left]>a[Largest] ){
            Largest=left;
        }

        if(right<=n && a[right]>a[Largest]){
            Largest=right;
        }

        if(Largest!=i){
            int temp=a[i];
            a[i]=a[Largest];
            a[Largest]=temp;
            Heapify(a,n,Largest);
        }
    }

    public static void HeapSorting(int a[]){

        int n=a.length-1;

        for(int i=n/2;i>=0;i--){
            Heapify(a,n,i);
        }

        for(int i=n;i>0;i--){

            int temp=a[0];
            a[0]=a[i];
            a[i]=temp;

            Heapify(a,i-1,0);
        }

    }

    public static void display(int a[]){

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        
        int a[]={7,2,5,1,8,4,6,3};
        System.out.println("Present Array : ");
        display(a);
        HeapSorting(a);
        System.out.println("Sorted Array : ");
        display(a);
        

    }
    
}
