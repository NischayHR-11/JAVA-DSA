package GreedyAlgorithm.CoinChangeProblem;
import java.util.Arrays;

// class coin {

//     public static void CoinChangeProblem(int a[],int amt){

//         Arrays.sort(a);

//         int index=a.length-1;

//         while(true){

//             int coinValue=a[index];
//             index--;

//             if(amt>0){
//                 System.out.println("COIN VALUE : "+a[index]+" NUMBER OF COINS : "+amt/coinValue);
//                 amt=amt-coinValue;
//             }

//             if(amt==0)break;
//         }
//     }
// }

class CoinChangeProblem {

    static void coinChangeProblem(int[] coins, int N) {
      Arrays.sort(coins);
      int index = coins.length-1;
      while(true) {
        int coinValue = coins[index];
        index--;
        int maxAmount = (N/coinValue)*coinValue;
        if (maxAmount>0) {
          System.out.println("Coin value: "+coinValue+" taken count: "+(N/coinValue));
          N = N - maxAmount;
        }
        if (N == 0) break;
      }
    }
  
  }


public class CoinChange {
    public static void main(String[] args) {
        
        int coins[]={1,2,5,10,20,50,10,1000};

        CoinChangeProblem.coinChangeProblem(coins, 2035);
    }
    
}
