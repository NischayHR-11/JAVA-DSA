package SortingAlgorithms.OutPlaceSorting.MergeSort;

// Time Complexity : O(nlogn);     Space Complexity : O(n); {conquer Method = O(log(n)) + Array = O(n)}(dominated)

// OutPlace Sorting  and  StableSorting

public class MergeSort {

    public static void conquer(int a[],int si,int mid,int ei){

        // O(n)

        int merge[]=new int[ei-si+1];

        int indx1=si;
        int indx2=mid+1;
        int x=0;

        while(indx1<=mid && indx2<=ei){
            if(a[indx1]<a[indx2]){
                merge[x++]=a[indx1++];
            }else{
                merge[x++]=a[indx2++];
            }
        }

        while(indx1<=mid){
            merge[x++]=a[indx1++];
        }

        while(indx2<=ei){
            merge[x++]=a[indx2++];
        }

        for(int i=0,j=si;i<merge.length;i++,j++){
            a[j]=merge[i];
        }

    }

    public static void MergeSorting(int a[],int si,int ei){

        // O(logn)

        if(si>=ei){
            return;
        }

        int mid=si+(ei-si)/2;

        MergeSorting(a, si, mid);
        MergeSorting(a, mid+1, ei);
        conquer(a,si,mid,ei);

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
        MergeSorting(a,0,a.length-1);
        System.out.println("Sorted Array : ");
        display(a);

    }
    
}
