package Tree.BinarySearchTree;
import java.util.*;

class node {
public int val;
public node left,right;
public int height=1;
}

class bst{
    public node root;

    public bst(){
        root=null;
    }

    private node insertion(node curnode,int val){
        if(curnode==null){
            node newnode=new node();
            newnode.val=val;
            return newnode;
        }
        if(val<=curnode.val){
            curnode.left= insertion(curnode.left,val);
            return curnode;
        }else{
            curnode.right= insertion(curnode.right,val);
            return curnode;
        }
    }

    public void insertion(int val){
       root= insertion(root, val);
    }

    public node minimum(node cur){
        if(cur.left==null){
            return cur;
        }else{
       return minimum(cur.left);
        }
    }

    public node delete(node cur,int val){
        if(cur==null){
            System.out.println("ELEMENT NOT FOUND!!");
            return null;
        }
        if(val<cur.val){
            cur.left=delete(cur.left,val);
        }else if(val>cur.val){
            cur.right=delete(cur.right, val);
        }else{
            if(cur.right!=null &&cur.left!=null){
                cur.val=minimum(cur.right).val;
               cur.right= delete(cur.right, minimum(cur.right).val);
            }else if (cur.right!=null){
                cur=cur.right;
            }else if(cur.left!=null){
                cur=cur.left;
            }else{
                cur=null;
            }
            
        }
        return cur;
    }

    public void delete(int val){
        root=delete(root, val);
    }

    public void search(node root,int val){
        if(root==null){
            System.out.println("ELEMENT NOT FOUND IN THE TREE !!");
            return;
        }
        if(val<root.val){
            search(root.left, val);
        }else if(val>root.val){
            search(root.right,val);
        }else{
            System.out.println("ELEMENT FOUND IN THE TREE..");
            return;
        }
    }

    public void deleteall(){
        root=null;
        System.out.println("COMPLETE TREE DELETED SUCCESSFULLY....");
    }

    public void preOrderprint(node root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrderprint(root.left);
        preOrderprint(root.right);
    }

    public void postorderprint(node root){
        if(root==null){
            return;
        }
        preOrderprint(root.left);
        preOrderprint(root.right);
        System.out.print(root.val+" ");
    }

    public void inorderprint(node root){
        if(root==null){
            return;
        }
        preOrderprint(root.left);
        System.out.print(root.val+" ");
        preOrderprint(root.right);
    }

    public void levelorderprint(){
        if(root==null){
            System.out.println("TREE IS EMPTY !!");
            return;
        }
        Queue<node>a=new LinkedList<node>();
        a.add(root);
        while(!a.isEmpty()){
            node temp=a.remove();
            System.out.print(temp.val +" ");
            if(temp.left!=null)
            a.add(temp.left);
            if(temp.right!=null)
            a.add(temp.right);
        }
    }
}

public class unbalanced {
    public static void main(String[] args) {
        bst bs=new bst();
        bs.insertion(6);
        bs.insertion(7);
        bs.insertion(2);
        bs.insertion(5);
        bs.insertion(3);
        bs.delete(5);
       System.out.println(bs.minimum(bs.root).val);
       bs.search(bs.root, 2);
        bs.levelorderprint();
        System.out.println();
        bs.preOrderprint(bs.root);
        System.out.println();
        bs.postorderprint(bs.root);
        System.out.println();
        bs.inorderprint(bs.root);
    }
}
