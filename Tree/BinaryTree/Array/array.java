package Tree.BinaryTree.Array;

class binary{

    private String arr[];
    private int recent;

    public binary(int size){
        arr=new String[size+1];
        recent=0;
    }

    public boolean isEmpty(){
        if(recent==0)
        return true;
        return false;
    }

    public boolean isfull(){
        if(recent==arr.length-1)
        return true;
        return false;
    }

    public void insert(String val){
        if(isfull()){
            System.out.println("TREEE IS FULL !!");
            return;
        }
        arr[recent+1]=val;
        recent++;
        System.out.println("ELEMENT INSERTED SUCCESSFULLY...");
    }

    public int  search(String val){
        for(int i=1;i<recent;i++){
            if(arr[i]==val){
            return i;
            }
        }
        return -1;
    }

    public void delete(String val){
        int n=search(val) ;
        if(n==-1)
        return;
        arr[n]=arr[recent];
        arr[recent]=null;
        recent--;
    }

    public void deleteTree(){
        arr=null;
    }

    public void display(){
        int i;
        for(i=1;i<recent;i++){
            System.out.print(arr[i]+"->");
        }
        System.out.println(arr[i]);
    }
}

public class array {
    public static void main(String[] args) {
        binary bt=new binary(5);
        bt.insert("N1");
        bt.insert("N2");
        bt.insert("N3");
        bt.insert("N4");
        bt.insert("N5");
        bt.insert("N6");
        bt.display();
       System.out.println(bt.search("N3"));
       bt.delete("N3");
       bt.display();
    }
    
}
