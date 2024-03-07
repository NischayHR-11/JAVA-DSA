package Tree.AvlTree;
import java.util.*;
class node{
    public int val;
    public node left,right;
    public int height=0;
}

class avl{
    public node root;

    public avl(){
        root=null;
    }

    public int getheight(node cur){
        if(cur==null){
            return 0;
        }
        return cur.height;
    }

    public node minimum(node root){
        if(root.left==null){
            return root;
        }
        return minimum(root.left);
    }

    public int getbalance(node root){
        if(root==null){
            return 0;
        }
        return getheight(root.left)-getheight(root.right);
    }

    public node rightrotation(node cur){
        node newroot=cur.left;
        cur.left=cur.left.right;
        newroot.right=cur;
        cur.height=1+Math.max(getheight(cur.left), getheight(cur.right));
        newroot.height=1+Math.max(getheight(newroot.left), getheight(newroot.right));
        return newroot;
    }

    public node leftrotation(node cur){
        node newroot=cur.right;
        cur.right=cur.right.left; 
        newroot.left=cur;
        cur.height=1+Math.max(getheight(cur.left), getheight(cur.right));
        newroot.height=1+Math.max(getheight(newroot.left), getheight(newroot.right));
        return newroot;
    }

    private node insert(node root,int val){
        if(root==null){
            node newnode=new node();
            newnode.val=val;
            newnode.height=1;
            return newnode;
        }
        else if(val>root.val){
            root.right=insert(root.right,val);
        } else{
            root.left=insert(root.left,val);
        }

        root.height=1+Math.max(getheight(root.left),getheight(root.right));
        int bal=getbalance(root);

        if(bal>1 && val<root.left.val){
            return rightrotation(root);
        }
        if(bal>1 && val>root.left.val){
        root.left=leftrotation(root.left);
            return  rightrotation(root);
        }
        if(bal<-1 && val>root.right.val){
            return leftrotation(root);
        }
        if(bal<-1 && val<root.right.val){
            root.right=rightrotation(root.right);
            return leftrotation(root);
        }

        return root;
    }

    public void insert(int val){
    root=insert(root, val);
    }

    private node delete(node root,int val){
        if(root==null){
            System.out.println("ELEMENT NOT FOUND IN THE TREE !!");
            return root;
        }
        if(val>root.val){
            root.right=delete(root.right, val);
        }else if(root.val>val){
            root.left=delete(root.left, val);
        }else{
            if(root.right!=null &&root.left!=null){
                root.val=minimum(root.right).val;
            root.right= delete(minimum(root.right), minimum(root.right).val);
            }else if(root.right!=null){
                root=root.right;
            }else if(root.left!=null){
                root=root.left;
            }else{
                root=null;
            }

        }
        int bal=getbalance(root);

        if(bal>1 && getbalance(root.left)>=0){
            return rightrotation(root);
        }
        if(bal>1 && getbalance(root.left)<0){
        root.left=leftrotation(root.left);
            return  rightrotation(root);
        }
        if(bal<-1 && getbalance(root.right)<=0){
            return leftrotation(root);
        }
        if(bal<-1 && getbalance(root.left)>0){
            root.right=rightrotation(root.right);
            return leftrotation(root);
        }
        return root;
    }

    public void delete(int val){
    root=delete(root, val);
    }

    public void search(node root,int val){
        if(root==null){
            System.out.println("ELEMENT IS NOT PRESENT IN THE TREE !!");
            return;
        }
        if(val>root.val){
            search(root.right,val);
        }else if(val<root.val){
            search(root.left, val);
        }else{
            System.out.println("ELEMENT FOUND IN THE TREE...");
        }
    }

    public void deletetree(){
        root=null;
        System.out.println("TREE IS SUCCESSFULLY DELETED COMPLETLY.....");
    }

    public void levelorderprint(){
        if(root==null){
            System.out.println("TREE IS EMPTY!!");
            return;
        }
        Queue<node>a=new LinkedList<node>();
        a.add(root); node temp;
        while(!a.isEmpty()){
            temp=a.remove();
            System.out.print(temp.val+" ");
            if(temp.left!=null)
            a.add(temp.left);
            if(temp.right!=null)
            a.add(temp.right);
        }
    }
}

public class balanced {
    public static void main(String[] args) {
        avl bs=new avl();
        bs.insert(6);
        bs.insert(7);
        bs.insert(2);
        bs.insert(5);
        bs.insert(3);
        bs.levelorderprint();
        System.out.println();
        bs.delete(7);
        bs.levelorderprint();
        System.out.println();
        bs.search(bs.root, 9);
    }
}
