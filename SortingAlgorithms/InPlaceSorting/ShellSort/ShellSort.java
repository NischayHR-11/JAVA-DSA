
public class ShellSort {


    public static void ShellSorting(int a[]){

        int gap=a.length/2;

        for(;gap>=1;gap=gap/2){

            for(int j=gap;j<a.length;j++){

                for(int i=j-gap;i>=0;i=i-gap){

                    if(a[gap+i]<a[i]){
                        int temp=a[gap+i];
                        a[gap+i]=a[i];
                        a[i]=temp;
                    }else{
                        break;
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
