package SortingAlgorithms.InsertionSort;

public class InsertionSort {

    public static void InsertionSorting(int a[]){
        
        for(int i=1;i<a.length;i++){
            int temp=a[i];
            int j=i;
            while(j>0 && a[j-1]>temp){
                a[j]=a[j-1];
                j--;
            }
            a[j]=temp;
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
        InsertionSorting(a);
        System.out.println("Sorted Array : ");
        display(a);
    }
    
}
