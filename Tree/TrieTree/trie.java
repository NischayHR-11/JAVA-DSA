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

    public boolean Search(String s){
        node cur=root;
      for(int i=0;i<s.length();i++){
        node temp=cur.a.get(s.charAt(i));
        if(temp==null){
            System.out.println("ELEMENT NOT PRESENT IN THE TREE !!");
            return false;
        }
        cur=temp;
       }
       if(cur.endOfString==true){
        System.out.println("ELEMENT PRESENT IN THE TREE ...");
        return true;
       }else{
        System.out.println("ELEMENT NOT PRESENT IN THE TREE !! BUT IT IS PREFIX OF ANOTHER WORD");
        return false;
       }
    }

    private boolean delete(node root,String word,int indx){
        char ch=word.charAt(indx);
        node cur=root.a.get(ch);
        boolean deletenode;

        if(cur.a.size()>1){
            delete(cur, word, indx+1);
            return false;
        }
        if(indx==word.length()-1){
            if(cur.a.size()>=1){
                cur.endOfString=false;
                return false;
            }else{
                root.a.remove(ch);
                return true;
            }
        }

        if(cur.endOfString==true){
            delete(cur, word, indx+1);
            return false;
        }

        deletenode=delete(cur, word, indx+1);

        if(deletenode==true){
            root.a.remove(ch);
            return true;
        }else{
            return false;
        }
    }

    public void delete(String word){
        if(Search(word)){
            delete(root, word, 0);
        }else{
            System.out.println("THEIR IS NO SUCH ELEMENT IN A TREE !!");
        }
    }

}

public class trie {
    public static void main(String[] args) {

        Tree t=new Tree();
        t.insert("NISCHAY");
        t.insert("VAIBHAV");
        t.insert(("MAHADEV"));
        t.Search("VAIBHAV");
        t.delete("VAIBHAV");
        t.Search("VAIBHAV");
    }
}
