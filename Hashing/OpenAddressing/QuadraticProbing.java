package Hashing.OpenAddressing;
import java.util.ArrayList;

class QP{
    String HashTable[];
    int UsedWords;

    public QP(int n){
        HashTable=new String[n];
        UsedWords=0;
    }

    public int HashFunction(String word){
        int sum=0;
        for(int i=0;i<word.length();i++){
            sum=sum+word.charAt(i);
        }
        return sum%HashTable.length;
    }

    public double LoadFactor(){
        return UsedWords*1.0/HashTable.length;
    }

    public void ReHash(String word){
        
    }
}

public class QuadraticProbing {
    public static void main(String[] args) {
        
    }
}
