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

    public boolean search(String word){
        int indx=HashFunction(word);
        if(HashTable[indx]==null){
            System.out.println("ELEMENT NOT FOUND IN HASH TABLE.. ");
            return false;
        }
        for(int i=indx;i<indx+HashTable.length;i++){
            int newindx=i%HashTable.length;
            if(HashTable[newindx]!=null && HashTable[newindx]==word){
                System.out.println("ELEMENT FOUND AT "+newindx+" INDEX");
                return true;
            }
        }
        System.out.println("ELEMENT NOT FOUND IN HASH TABLE ");
        return false;
    }

    public void delete(String word){
        if(search(word)){
            int indx=HashFunction(word);
            for(int i=0;i<indx+HashTable.length;i++){
                int newindx=i%HashTable.length;
                if(HashTable[newindx]!=null && HashTable[newindx]==word){
                    HashTable[newindx]=null;
                    System.out.println("ELEMENT DELETED SUCCESSFULLY...");
                    return;
                }
            }
        }else{
            System.out.println("ELEMENT NOT FOUND IN THE HASH TABLE !!");
        }
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
        LinearProbing.insert("HELLO");
        LinearProbing.insert("I");
        LinearProbing.insert("AM");
        LinearProbing.insert("NISCHAY");
        LinearProbing.insert("H R");
        LinearProbing.insert("FROM");
        LinearProbing.insert("RAMANAGARA");
        LinearProbing.insert("WELCOME");
        LinearProbing.display();
        LinearProbing.search("ytf");
        LinearProbing.delete("WELCOME");
        LinearProbing.display();

    }
}
