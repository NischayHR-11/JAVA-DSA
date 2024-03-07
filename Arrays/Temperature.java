import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {

       Scanner sc=new Scanner(System.in);
       System.out.println("HOW MANY DAYS TEMPERATURE ?");
       int n=sc.nextInt();
       float a[]=new float[n];float total=0;

       for(int i=0;i<a.length;i++){
           System.out.println("DAY "+(i+1)+" HIGH TEMPERATURE :");
           a[i]=sc.nextFloat();
           total=total+a[i];
       }

       float avg=total/n;
       System.out.println("AVERAGE :"+avg);
       int count=0;

       for(int i=0;i<a.length;i++){
           if(a[i]>=avg)
               count++;
       }
       
       System.out.println(count+" DAYS ARE ABOVE AND EQUAL TO AVERAGE TEMPERATURE");
    }
    
}
