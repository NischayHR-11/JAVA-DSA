package Tree.BinaryTree.linkedlist;
import java.util.*;

class node{
    public String val;
    public node left,right;
}

class BinaryTree{

    public node root;
    public int height;

    public void insert(String val){
        node newnode=new node();
        newnode.val=val;
    if(root==null){
        root=newnode;
        System.out.println("ELEMENT INSERTED SUCCESSFULLY !!");
        return;
    }
    Queue<node> a=new LinkedList<node>();
    a.add(root);node temp;
    while(!a.isEmpty()){
        temp=a.remove();
        if(temp.left==null){
        temp.left=newnode;
        System.out.println("ELEMENT INSERTED SUCCESSFULLY !!");
        return;
        }
        else if(temp.right==null){
        temp.right=newnode;
        System.out.println("ELEMENT INSERTED SUCCESSFULLY !!");
        return;
        }
        else{
            a.add(temp.left);
            a.add(temp.right);
        }
    }
    }

    public void levelOrderPrint(){
         Queue<node> a=new LinkedList<node>();
         a.add(root);
         while(!a.isEmpty()){
            node temp=a.remove();
            System.out.print(temp.val+" ");
            if(temp.left!=null){
                a.add(temp.left);
            }
            if(temp.right!=null){
                a.add(temp.right);
            }
         }
    }

    public void search(String s){
        Queue<node> a=new LinkedList<node>();
        a.add(root);
        while(!a.isEmpty()){
            node temp=a.remove();
            if(temp.val.equals(s)){
                System.out.println("ELEMENT FOUND IN THE TREE...");
                return;
            }
            if(temp.left!=null){
                a.add(temp.left);
            }
            if(temp.right!=null){
                a.add(temp.right);
            }
        }
        System.out.println("ELEMENT NOT FOUND IN THE TREE...");
    }

    public node lastelement(){
        Queue<node> a=new LinkedList<node>();
        a.add(root);node temp=null;
        while(!a.isEmpty()){
             temp=a.remove();
            if(temp.left!=null){
                a.add(temp.left);
            }
            if(temp.right!=null)
            a.add(temp.right);
        }
    return temp;
    }

    public void deletelastnode(){
        Queue<node> a=new LinkedList<node>();
        a.add(root);node prev,cur=null;
        while(!a.isEmpty()){
            prev=cur;
            cur=a.remove();
            if(cur.left!=null && cur.right==null){
                cur.left=null;
                return;
            }
            else if(cur.left==null){
            prev.right=null;
            System.out.println("LAST ELEMENT IS DELETED SUCCESSFULLY....");
            return;
            } 
            // else if(cur.right==null){
            //     prev.left=null;
            //     System.out.println("LAST ELEMENT IS DELETED SUCCESSFULLY...");
            //     return;
            // }
            else{
            a.add(cur.left);
            a.add(cur.right);
            }
        }
    }

    public void delete(String s){
        Queue<node> a=new LinkedList<node>();
        a.add(root);node temp;
        while(!a.isEmpty()){ 
            temp=a.remove();
            if(temp.val==s){
                temp.val= lastelement().val;
                deletelastnode();
                return;
            }else{
            if(temp.left!=null)
            a.add(temp.left);
            if(temp.right!=null)
            a.add(temp.right);
        }
    }
    System.out.println("ELEMENT NOT FOUND !!");
    }
    

    public void preorderprint(node root){
        if(root==null)
        return;
        System.out.print(root.val+" ");
        preorderprint(root.left);
        preorderprint(root.right);
    }

    public void postorderprint(node root){
        if(root==null)
        return;
        preorderprint(root.left);
        preorderprint(root.right);
        System.out.print(root.val+" ");
    }

    public void Inorderprint(node root){
        if(root==null)
        return;
        preorderprint(root.left);
        System.out.print(root.val+" ");
        preorderprint(root.right);
    }
  
}

public class linkedlist {
    public static void main(String[] args) {
        BinaryTree l=new BinaryTree();
        l.insert("HI");
        l.insert("NISCHAY");
        l.insert("HOW");
        l.insert("ARE");
        l.insert("YOU");
        l.insert("?");
        l.insert("1");
        l.insert("2");
        l.insert("3");
        l.insert("4");
        l.insert("5");
        l.insert("6");
        l.levelOrderPrint();
        System.out.println();
        l.preorderprint(l.root);
        System.out.println();
        l.postorderprint(l.root);
        System.out.println();
        l.Inorderprint(l.root);
        System.out.println();
        l.search("5");
        System.out.println(l.lastelement().val);
        l.deletelastnode();
        l.levelOrderPrint();
        System.out.println();
        System.out.println(l.lastelement().val);
        l.delete("1");
        l.levelOrderPrint();

    }
}
