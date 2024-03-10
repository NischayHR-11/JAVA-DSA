package Hashing.OpenAddressing;
import java.util.ArrayList;

class LP{
    String HashTable[];
    int UsedWords;

    public LP(int n){
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
        double n=UsedWords*1.0/HashTable.length;
        return n ;
    }

    public void ReHash(String word){
        System.out.println("REHASHING IS USED !!");
        UsedWords=0;
        ArrayList<String>a=new ArrayList<>();
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

    public void insert(String word){

        // System.out.println("Load Factor "+LoadFactor()+"\tUsed Words "+UsedWords);

        if(LoadFactor()>=.75){
            ReHash(word);
        }else{
            int indx=HashFunction(word);

            for(int i=indx;i<indx+HashTable.length;i++){
                int newindx=i%HashTable.length;
                if(HashTable[newindx]==null){
                    HashTable[newindx]=word;
                    System.out.println("The " + word + " successfully inserted at location: "+newindx);
                    break;
                }else{
                    System.out.println(newindx+" is already occupied . Trying next empty cell");
                }
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
}

public class LinearProbing {
    public static void main(String[] args) {
        
        LP LinearProbing=new LP(10);
        LinearProbing.insert("HI");
        LinearProbing.insert("HI");
        LinearProbing.insert("HI");
        LinearProbing.insert("HI");
        LinearProbing.insert("HI");
        LinearProbing.insert("HI");
        LinearProbing.insert("HI");
        LinearProbing.insert("HI");
        LinearProbing.insert("HI");
        LinearProbing.display();

    }
}
