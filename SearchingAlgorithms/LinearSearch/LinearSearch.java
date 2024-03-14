package SearchingAlgorithms.LinearSearch;

// Time Complexity : O(n);

// Applicable For Both Sorted and UnSorted Data Structures. 

public class LinearSearch {

    public static int LinearSearching(int a[],int key){

        for(int i=0;i<a.length;i++){

            if(a[i]==key){
                System.out.println("Element Found In The Array At Index : "+ i);
                return i;
            }
        }

        System.out.println("Element Not Found In The Array !!");
        return -1;
    }

    public static void main(String[] args) {
        
        int a[]={3,4,7,5,2,1,0,6,9,8,10};
        LinearSearching(a, 0);
        LinearSearching(a, 11);

    }
    
}
