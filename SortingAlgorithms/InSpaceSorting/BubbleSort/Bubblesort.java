package SortingAlgorithms.InSpaceSorting.BubbleSort;

public class Bubblesort {

    public static void Bubblesorting(int a[]){

        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
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
        Bubblesorting(a);
        System.out.println("Sorted Array : ");
        display(a);
    }
    
}
