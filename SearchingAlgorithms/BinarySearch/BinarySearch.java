
// Time Complexity : O(log(n));

// It Is Only Applicable For Sorted Data Structure.

public class BinarySearch {

    public static int BinarySearching(int a[],int key){

        int beg=0;
        int end=a.length-1;

        while(beg<end){

            int mid=(beg+end)/2;

            if(a[mid]==key){
                System.out.println("ELEMENT FOUND IN THE ARRAY AT INDEX : "+mid);
                return mid;
            }else if(key>a[mid]){
                beg=mid+1;
            }else{
                end=mid-1;
            }
        }

        System.out.println("ELEMENT NOT FOUND IN THE ARRAY !!");
        return -1;
    }

    public static void main(String[] args) {
        
        int a[]={3,4,5,6,7,8,9,10};
        BinarySearching(a, 4);
        BinarySearching(a, 11);

    }
    
}
