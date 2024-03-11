package Hashing.DirectChaining;
import java.util.Scanner;
import java.util.LinkedList;

class DL{
    
    private LinkedList<String>HashTable[];

    @SuppressWarnings("unchecked")
    public DL(int n){
        HashTable=new LinkedList[n];
    }

    public int HashFunction(String word){
        int sum=0;
        for(int i=0;i<word.length();i++){
            sum=sum+word.charAt(i);
        }

        return sum%HashTable.length;
    }

    public void insert(String word){
        int n=HashFunction(word);
        if(HashTable[n]==null){
            HashTable[n]=new LinkedList<>();
            HashTable[n].add(word);
        }else{
            HashTable[n].add(word);
        }
    }

    public boolean Search(String word){
        int n=HashFunction(word);
        if(HashTable[n]!=null && HashTable[n].contains(word)){
            System.out.println(word + " IS PRESENT IN THE HASH TABLE..\n");
            return true;
        }else{
            System.out.println(word + " IS NOT PRESENT IN THE HASH TABLE !!\n");
            return false;
        }
    }

    public void delete(String word){
        int n=HashFunction(word);
        if(Search(word)){
        HashTable[n].remove(word);
        }else{
            System.out.println(word + " IS NOT PRESENT IN THE HASH TABLE!!");
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

public class DirectChaining {
    @SuppressWarnings("resource")
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE SIZE OF THE HASH TABLE REQUIRED : ");
        int n=sc.nextInt();
        DL directLinking=new DL(n);
        directLinking.insert("HI");
        directLinking.insert("Hello");
        directLinking.insert("EVERY ONE");
        directLinking.insert("I");
        directLinking.insert("AM");
        directLinking.insert("NISCHAY H R");
        directLinking.insert("WELCOME");
        directLinking.Search("NISCHAY H R");
        directLinking.display();
        directLinking.delete("HI");
        directLinking.display();
        directLinking.Search("HI");

    }
}
