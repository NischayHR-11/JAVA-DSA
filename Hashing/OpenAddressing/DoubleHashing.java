package Hashing.OpenAddressing;
import java.util.ArrayList;

class DH{
    String HashTable[];
    int UsedWords;

    DH(int n){
        HashTable=new String[n];
        UsedWords=0;
    }

    public int HashFunction1(String word){
        int sum=0;
        for(int i=0;i<word.length();i++){
            sum=sum+word.charAt(i);
        }
        return sum %HashTable.length;
    }

    public double loadFactor(){
        return UsedWords*1.0/HashTable.length;
    }

    public void Rehash(String word){
        System.out.println("REHASHING CALLED !!");
        UsedWords=0;
        ArrayList<String> a=new ArrayList<>();
        for(int i=0;i<HashTable.length;i++){
            if(HashTable[i]!=null){
                a.add(HashTable[i]);
            }
        }
        a.add(word);
        HashTable=new String[HashTable.length*2];
        for(String s :a){
            insert(s);
        }
    }

    public int HashFunction2(String word){
        int sum=0;
        for(int i=0;i<word.length();i++){
            sum=sum+word.charAt(i);
        }
        return 7-(sum%7);
    }

    public void insert(String word){
        if(loadFactor()>=0.75){
            Rehash(word);
        }else{
            int x=HashFunction1(word);
            int y=HashFunction2(word);

            for(int i=0;i<HashTable.length;i++){
                int newindex=(x+i*y)%HashTable.length;

                if(HashTable[newindex]==null){
                    HashTable[newindex]=word;
                    System.out.println(word+" IS SUCCESSFULLY INSERTED AT INDEX :"+newindex);
                    break;
                }
            }
        }
        UsedWords++;

    }

    public void display(){
        System.out.println("-------------------- HASH TABLE ------------------");
        for(int i=0;i<HashTable.length;i++){
            System.out.println("INDEX : "+i+" , "+" KEY : "+HashTable[i]);
        }
    }
}

public class DoubleHashing {
    public static void main(String[] args) {
        DH DoubleHashing=new DH(10);
        DoubleHashing.insert("HI");
        DoubleHashing.insert("Hello");
        DoubleHashing.insert("EVERY ONE");
        DoubleHashing.insert("HI");
        DoubleHashing.insert("I");
        DoubleHashing.insert("AM");
        DoubleHashing.insert("NISCHAY H R");
        DoubleHashing.insert("WELCOME");
        // DoubleHashing.Search("NISCHAY H R");
        DoubleHashing.display();
    //     DoubleHashing.delete("HI");
    //     DoubleHashing.display();
    //     DoubleHashing.Search("HI");
    }
    
}
