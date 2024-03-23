// Time Complexity : O(n^2);          Space Complexity : O(1);

// InPlace Sorting   AND  UnStable Sorting

public class ShellSort {

    public static void ShellSorting(int a[]){

        

        for(int gap=a.length/2;gap>=1;gap=gap/2){

            for(int j=gap;j<a.length;j++){

                for(int i=j-gap;i>=0;i--){

                    if(a[i+gap]>a[i]){
                        break;
                    }else{
                        int temp=a[i];
                        a[i]=a[i+gap];
                        a[i+gap]=temp;
                    }
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
        ShellSorting(a);
        System.out.println("Sorted Array : ");
        display(a);

    }
    
}