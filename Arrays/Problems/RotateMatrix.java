package Problems;

public class RotateMatrix {
    
    public static void Rotatematrix(int arr[][]){
        //transpose
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr[0].length;j++){
                int t=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=t;
            }
        }
        //reverse
        for(int i=0;i<arr.length;i++) {
            int left = 0;
            int right = arr[0].length - 1;
            while (left < right) {
                int t = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = t;
                left++;
                right--;
            }
        }
    }
    public static void main(String[] args) {
        int arr[][]={{84,85,86},{87,85,90},{85,83,23}};
       System.out.println("BEFORE ROTATION :");
       for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr[0].length;j++){
               System.out.print(arr[i][j]+" ");
           }
           System.out.println();
       }
       System.out.println("AFTER ROTATION :");
       Rotatematrix(arr);
       for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr[0].length;j++){
               System.out.print(arr[i][j]+" ");
           }
           System.out.println();
       }
    }
}
