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
                int newindex=(index+(count*count))%HashTable.length;
                if(HashTable[newindex]==null){
                    HashTable[newindex]=word;
                    System.out.println("ELEMENT INSERTED SUCCESSFULLY.. AT INDEX :"+newindex);
                    return;
                }
                count++;
            }
        }
        UsedWords++;
    }

    public void display(){

        System.out.println("------------------ HASH TABLE -----------------");
        for(int i=0;i<HashTable.length;i++){
            System.out.println("INDEX "+i+" , "+"KEY : "+HashTable[i]);
        }
        System.out.println("-----------------------------------------------");
    }

    public boolean search(String word){
        int index=HashFunction(word);
        int count=0;
        if(HashTable[index]==null){
            System.out.println(word+" NOT FOUND IN THE HASH TABLE !!");
            return false;
        }
        for(int i=index;i<index+HashTable.length;i++){
            int newindex=(index+(count*count))%HashTable.length;
            if(HashTable[newindex]!=null && HashTable[newindex]==word){
                System.out.println(word +" FOUND AT INDEX : "+newindex);
                return true;
            }
        }
        System.out.println(word+" NOT FOUND IN THE HASH TABLE !!");
        return false;

    }
}

public class QuadraticProbing {
    public static void main(String[] args) {
        
        QP QuadraticProbing=new QP(10);
        QuadraticProbing.insert("HI");
        QuadraticProbing.insert("hello");
        QuadraticProbing.insert("Q");
        QuadraticProbing.insert("I");
         QuadraticProbing.insert("AM");
        QuadraticProbing.display();
        QuadraticProbing.search("Q");

    }
}
