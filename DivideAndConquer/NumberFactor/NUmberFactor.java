package DivideAndConquer.NumberFactor;

public class NUmberFactor {

    public static int  numberFac(int n){

        if(n==0 ||n==1||n==2)
        return 1; //number of possiblities.

        if(n==3)
        return 2;

       int sub1= numberFac(n-1); // For Numbers 1,3, & 4.
       int sub2= numberFac(n-3); // Divided Into 3 Subgroups To Solve(1,3,4 sub groups).
       int sub3= numberFac(n-4);

       return sub1+sub2+sub3; // add all possiblities from 3 Sub Groups.
    }

    public static void main(String[] args) {
        
        // Using 1,3,4 As Number Factors.
        
        System.out.println("NUMBER POSSIBLE WAYS FOR PRINTING 4 USING 1,3,4 FACTORS IS : "+numberFac(4));
        System.out.println("NUMBER POSSIBLE WAYS FOR PRINTING 5 USING 1,3,4 FACTORS IS : "+numberFac(5));
        System.out.println("NUMBER POSSIBLE WAYS FOR PRINTING 6 USING 1,3,4 FACTORS IS : "+numberFac(6));
        System.out.println("NUMBER POSSIBLE WAYS FOR PRINTING 7 USING 1,3,4 FACTORS IS : "+numberFac(7));
    }
    
}
