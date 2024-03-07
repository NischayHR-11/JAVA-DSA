package Tree.BinaryTree.Array;
import java.util.*;

class BinaryList{

     private String val;
     private List<BinaryList> tree;

    public  BinaryList(String val){
        this.val=val;
        this.tree=new ArrayList<>();
     }

    public  void Add(BinaryList l){
        this.tree.add(l);
     }

    public  String print (int level){
        String res=" ".repeat(level)+val+"\n";
        for(BinaryList node:this.tree){
            res=res+node.print(level+1);
        }
        return res;
     }

}

public class arraylist {
    public static void main(String[] args) {

        BinaryList l=new BinaryList("DRINKS");
        BinaryList l1=new BinaryList("COOL DRINKS");
        BinaryList l2=new BinaryList("HOT DRINKS");
        l.Add(l1);l.Add(l2);
        BinaryList l3=new BinaryList("TEA");
        BinaryList l4=new BinaryList("COFFE");
        l2.Add(l3);l2.Add(l4);

        BinaryList l5=new BinaryList("COCK");
        BinaryList l6=new BinaryList("SPRIT");
        l1.Add(l5);l1.Add(l6);

         System.out.println(l.print(0));
    }
}
