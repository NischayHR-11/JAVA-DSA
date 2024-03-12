package SortingAlgorithms.InPlaceSorting.QuickSort;

// Time Complexity Average time : O(nlog(n));  worst case : O(n^2);{If pivot Is Smallest Or Largest Element In Data Structure}

// Space Complexity : O(1);

// InPlace Sorting   And   UnStable Sorting;


public class QuickSort {

    public static int partition(int a[],int si,int ei){

        int pivot=a[ei];
        int i=si-1;

        for(int j=si;j<ei;j++){
            if(a[j]<pivot){
                i++;
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }

        i++;
        int temp=a[i];
        a[i]=a[ei];
        a[ei]=temp;

        return i;
    }

    public static void QuickSorting(int a[],int si,int ei){

        if(si<ei){

            int pivotIndex=partition(a, si, ei);

            QuickSorting(a, si, pivotIndex-1);
            QuickSorting(a, pivotIndex+1, ei);
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
        QuickSorting(a,0,a.length-1);
        System.out.println("Sorted Array : ");
        display(a);
        
    }
    
}
