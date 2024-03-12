package SortingAlgorithms.OutPlaceSorting.BucketSorting;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    public static void displayBuckets(ArrayList<Integer>buckets[]){
        for(int i=0;i<buckets.length;i++){

            System.out.println("Bucket "+(i+1)+" :");

            for(int j=0;j<buckets[i].size();j++){

                System.out.print(buckets[i].get(j));
            }
            
            System.out.println();
        }
    }

    @SuppressWarnings("unchecked")
    public static void BucketSorting(int a[]){
        
        int NumberOfBuckets=(int) Math.ceil((float)Math.sqrt(a.length));

        ArrayList<Integer>Buckets[]=new ArrayList[NumberOfBuckets];

        for(int i=0;i<NumberOfBuckets;i++){
            Buckets[i]=new ArrayList<>();
        }

        int max=Integer.MIN_VALUE;
        for(int x:a){
            if(x>max){
                max=x;
            }
        }

        
        for(int x :a){
        
            int Bucket=(int) Math.ceil((float)x*NumberOfBuckets/(float)max);

            Buckets[Bucket-1].add(x);
        }

        System.out.println("BUCKETS BEFORE SORTING :" );

        displayBuckets(Buckets);

        for(ArrayList<Integer> x :Buckets){

            Collections.sort(x);
        }

        System.out.println("BUCKETS AFTER SORTING :" );

        displayBuckets(Buckets);

        int indx=0;
        
        for(ArrayList<Integer> x:Buckets){
            
            for(int y :x){
                a[indx]=y;
                indx++;
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
        BucketSorting(a);
        System.out.println("Sorted Array : ");
        display(a);
    }
    
}
