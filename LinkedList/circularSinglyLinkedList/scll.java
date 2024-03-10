package LinkedList.circularSinglyLinkedList;
import java.util.Scanner;

class nodes{
    public int value;
    public nodes next;
}

class circularSinglyLinkedList{
    public nodes head;
    public nodes tail;
    public int size;
    nodes creatcircularSinglyLinkedList(int val){
        head=new nodes();
        nodes newnode=new nodes();
        newnode.next=newnode;
        newnode.value=val;
        head=newnode;
        tail=newnode;
        return head;
    }

    public  void insertion(int val,int pos){
        nodes newnode=new nodes();
        newnode.value=val;
        if(head==null){
          newnode=creatcircularSinglyLinkedList(val);
          return;
        }else if(pos==0){
                newnode.next=head;
                head=newnode;
                tail.next=newnode;
        } else if (pos>=size) {
                newnode.next=tail.next;
                tail.next=newnode;
                tail=newnode;
        }else {
            nodes cur=head;int i=0;
            while(i<pos-1){
                cur=cur.next;
                i++;
            }
            newnode.next=cur.next;
            cur.next=newnode;

        }
        size++;
    }

    @SuppressWarnings("unused")
    
    public void display(){
        nodes cur=head;int j=0;
        while(cur.next!=head){
            System.out.print(cur.value+"->");
            cur=cur.next;j++;
        }
        System.out.print(cur.value);
    }

    public void delete(int pos){
        nodes cur=head;int i=0;
        while(i<pos-1){
            cur=cur.next;
            i++;
        }
        cur.next=cur.next.next;
        size--;
    }

    public  void deleteAll(){
        head=null;
        tail.next=null;
        tail=null;
    }

    public int Search(int key){
        nodes cur=head;int i=0;
        while(cur.next!=head){
            if(cur.value==key)
            return i;
            cur=cur.next;
            i++;
        }
        return-1;
    }

    public void getElement(int k){
        nodes cur =head;int i=0;
        while(i<k){
            cur=cur.next;
            i++;
        }
        System.out.println("INDEX "+k+" : "+cur.value);
    }

}



public class scll {
    
    @SuppressWarnings("resource")
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n,val,pos;
            circularSinglyLinkedList csll=new circularSinglyLinkedList();
            do{
            System.out.println("------------------------------------- MENU -----------------------------------");
            System.out.println("1.CREATE CIRCULAR SINGLY LINKED LIST");
            System.out.println("2.INSERT ELEMENT AT BEGINING");
            System.out.println("3.INSERT ELEMENT AT END");
            System.out.println("4.INSERT ELEMENT AT PARTICULAR INDEX");
            System.out.println("5.DELETE ELEMENT");
            System.out.println("6.DELETE ENTIRE LIST");
            System.out.println("7.SEARCH ELMENT");
            System.out.println("8.GET ELEMENT AT PARTICULAR INDEX");
            System.out.println("9.DISPLAY LIST");
            System.out.println("10.EXIT");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("ENTER THE CHOICE :");
            n=sc.nextInt();
            switch (n) {
                    case 1:
                    System.out.println("ENTER THE VALUE OF FIRST ELEMENT :");
                    val=sc.nextInt();
                    csll.creatcircularSinglyLinkedList(val);
                    break;
                    case 2:                    
                    System.out.println("ENTER THE VALUE OF ELEMENT TO INSERT :");
                    val=sc.nextInt();
                    csll.insertion(val,0);
                    break;
                    case 3:
                    System.out.println("ENTER THE VALUE OF ELEMENT TO INSERT :");
                    val=sc.nextInt();
                    csll.insertion(val,csll.size+2);
                    break;
                    case 4:                    
                    System.out.println("ENTER THE VALUE AND POSITION OF ELEMENT TO INSERT :");
                    val=sc.nextInt();pos=sc.nextInt();
                    csll.insertion(val,pos);
                    break;
                    case 5:
                    System.out.println("ENTER THE INDEX OF ELEMENT TO DELETE :");
                    val=sc.nextInt();
                    csll.delete(val);
                    break;
                    case 6:
                    System.out.println("LIST DELETED SUCCESSFULLY.......");
                    csll.deleteAll();
                    break;
                    case 7:                    
                    System.out.println("ENTER THE ELEMENT TO SEARCH :");
                    val=sc.nextInt();
                    System.out.println("INDEX :"+csll.Search(val));
                    break;
                    case 8:
                    System.out.println("ENTER THE INDEX :");
                    val=sc.nextInt();
                    csll.getElement(val);
                    break;
                    case 9:
                    csll.display();
                    System.out.println();
                    break;
                    case 10:
                    System.exit(0);
                    break;
            
                   default:
                   System.exit(0);
            }
        }while(true);

    }
}


