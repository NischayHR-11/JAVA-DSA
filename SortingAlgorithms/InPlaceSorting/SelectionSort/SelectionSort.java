package SortingAlgorithms.InPlaceSorting.SelectionSort;

public class SelectionSort {

    public static void SelectionSorting(int a[]){
        for(int i=0;i<a.length-1;i++){
            int smallest=i;

            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[smallest]){
                    smallest=j;
                }
            }
            int temp=a[i];
            a[i]=a[smallest];
            a[smallest]=temp;
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
        SelectionSorting(a);
        System.out.println("Sorted Array : ");
        display(a);
    }
    
}
