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
        ArrayList<String>a=new ArrayList<>();
        for(String s :HashTable){
            a.add(s);
        }
        a.add(word);
        HashTable=new String[2*HashTable.length];
        for(String s:a){
            insert(s);
        }
    }

    public void insert(String word){
        if(LoadFactor()>=.75){
            ReHash(word);
        }else{
            int index=HashFunction(word);
            int count=0;
            for(int i=index;i<index+HashTable.length;i++){
                int newindex=(i%HashTable.length)+(count*count);
                if(HashTable[newindex]==null){
                    HashTable[newindex]=word;
                    System.out.println("ELEMENT INSERTED SUCCESSFULLY..");
                    return;
                }
            }
        }
    }
    
}

public class QuadraticProbing {
    public static void main(String[] args) {
        
    }
}
