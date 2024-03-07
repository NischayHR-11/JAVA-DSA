package Tree.TrieTree;
import java.util.*;

class node{

    public Map<Character,node> a;
    public boolean endOfString;

    public node(){
        a=new HashMap<>();
        endOfString=false;
    }
}

class Tree{
    
    private node root;

    public Tree(){
        root=new node();
    }

    public void insert(String s){
        node cur=root;
        for(int i=0;i<s.length();i++){
            char t=s.charAt(i);
            node temp=cur.a.get(t);
            if(temp==null){
                temp=new node();
                cur.a.put(t,temp);
            }
            cur=temp;
        }
        cur.endOfString=true;
        System.out.println("ELEMENT IS INSERTED SUCCESSFULLY...");
    }

    public void Search(String s){
        node cur=root;
      for(int i=0;i<s.length();i++){
        node temp=cur.a.get(s.charAt(i));
        if(temp==null){
            System.out.println("ELEMENT NOT PRESENT IN THE TREE !!");
            return;
        }
        cur=temp;
       }
       if(cur.endOfString==true){
        System.out.println("ELEMENT PRESENT IN THE TREE ...");
        return;
       }else{
        System.out.println("ELEMENT NOT PRESENT IN THE TREE !! BUT IT IS PREFIX OF ANOTHER WORD");
        return;
       }
    }


}

public class trie {
    public static void main(String[] args) {

        Tree t=new Tree();
        t.insert("NISCHAY");
        t.insert("VAIBHAV");
        t.insert(("MAHADEV"));
        t.Search("NIs");
    }
}
