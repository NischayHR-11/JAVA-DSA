package SortingAlgorithms.OutPlaceSorting.CountSort;

public class CountSort {


    public static void CountSorting(int a[]){

        int b[]=new int[a.length];int count[];

        int max=a[0];

        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
        }

        count=new int[max+1];

        for(int i=0;i<a.length;i++){
            ++count[a[i]];
        }

        for(int i=1;i<=max;i++){
            count[i]=count[i]+count[i-1];
        }

        for(int i=a.length-1;i>=0;i--){
            
            b[--count[a[i]]]=a[i];
        }

        for(int i=0;i<b.length;i++){
            a[i]=b[i];
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
        CountSorting(a);
        System.out.println("Sorted Array : ");
        display(a);

        
    }
    
}
