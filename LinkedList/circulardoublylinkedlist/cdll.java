package LinkedList.circulardoublylinkedlist;

import java.util.Scanner;
class node{
    public  int val;
    public  node next;
    public  node prev;
}
class circulardoublylinkedlist{
    public node head;
    public node tail;
    public int size;

    public void creatcirculardoublylinkedlist(int val){
        head=new node();
        node newnode =new node();
        newnode.val=val;
        newnode.next=head; 
        newnode.prev=head;
        head=newnode;
        tail=newnode;
        size=1;
    }

    public void insertion(int val,int pos){
        if(head==null){
            creatcirculardoublylinkedlist(val);
            return;
        }
        node newnode=new node();
        newnode.val=val;
        if(pos==0){
            newnode.next=head;
            head.prev=newnode;
            newnode.prev=head;
            head=newnode;
            tail.next=head;
        }else if(pos>=size){
            newnode.next=head;
            newnode.prev=tail;
            tail.next=newnode;
            tail=newnode;
        }else{
            node cur=head;int i=0;
            while(i<pos-1){
                cur=cur.next;
                i++;
            }
            newnode.next=cur.next;
            newnode.prev=cur.next.prev;
            cur.next.prev=newnode;
            cur.next=newnode;
        }
        size++;
    }

    public void delete(int pos){
        node cur=head;int i=0;
        while(i<pos){
            cur=cur.next;
            i++;
        }
        if(pos==size-1){
            tail.prev.next=head;
            tail=tail.prev;
        }
        cur.next.prev=cur.prev;
        cur.prev.next=cur.next;
    }

    public void deleteAll(){
        node cur=head.next;
        while(cur.next!=head){
            cur.prev=null;
            cur=cur.next;
        }
        tail.next=null;
        tail=null;
        head=null;
    }

    public int Search(int val){
        node cur=head;int i=0;
        while(cur.next!=head){
            if(cur.val==val)
            return i;
            cur=cur.next;
            i++;
        }
        return -1;
    }

     public void getElement(int n){
        node cur=head;int i=0;
        if(n>=size){
            System.out.println("INVALID INDEX !!");
            return;
        }
        while(i<n){
            cur=cur.next;
            i++;
        }
        System.out.println("VALUE AT "+i+" INDEX IS : "+cur.val);
    
    }

    public void reverse(){
        node cur=tail;node next;
        while(cur.next!=head){
            next=cur.next;
            cur.next=cur.prev;
            cur.prev=next;
            cur=cur.next;
        }
        head=tail;
    }

    public void display(){
        if(head==null){
            System.out.println("LIST IS EMPTY !!");
            return;
        }
        node cur=head;
        while(cur.next!=head){
            System.out.print(cur.val+"->");
            cur=cur.next;
        }
        System.out.print(cur.val);
    }

}

public class cdll {
    public static void main(String[] args) {
         circulardoublylinkedlist dll=new circulardoublylinkedlist();
                 Scanner sc=new Scanner(System.in);
            int n,val,pos;
            do{
            System.out.println("------------------------------------- MENU -----------------------------------");
            System.out.println("1.CREATE DOUBLY LINKED LIST");
            System.out.println("2.INSERT ELEMENT AT BEGINING");
            System.out.println("3.INSERT ELEMENT AT END");
            System.out.println("4.INSERT ELEMENT AT PARTICULAR INDEX");
            System.out.println("5.DELETE ELEMENT");
            System.out.println("6.DELETE ENTIRE LIST");
            System.out.println("7.SEARCH ELMENT");
            System.out.println("8.GET ELEMENT AT PARTICULAR INDEX");
            System.out.println("9.DISPLAY LIST");
            System.out.println("10.REVERSE LIST");
            System.out.println("11.TAIL VALUE");
            System.out.println("12.EXIT");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("ENTER THE CHOICE :");
            n=sc.nextInt();
            switch (n) {
                    case 1:
                    System.out.println("ENTER THE VALUE OF FIRST ELEMENT :");
                    val=sc.nextInt();
                    dll.creatcirculardoublylinkedlist(val);
                    break;
                    case 2:                    
                    System.out.println("ENTER THE VALUE OF ELEMENT TO INSERT :");
                    val=sc.nextInt();
                    dll.insertion(val,0);
                    break;
                    case 3:
                    System.out.println("ENTER THE VALUE OF ELEMENT TO INSERT :");
                    val=sc.nextInt();
                    dll.insertion(val,dll.size+2);
                    break;
                    case 4:                    
                    System.out.println("ENTER THE VALUE AND POSITION OF ELEMENT TO INSERT :");
                    val=sc.nextInt();pos=sc.nextInt();
                    dll.insertion(val,pos);
                    break;
                    case 5:
                    System.out.println("ENTER THE INDEX OF ELEMENT TO DELETE :");
                    val=sc.nextInt();
                    dll.delete(val);
                    break;
                    case 6:
                    System.out.println("LIST DELETED SUCCESSFULLY.......");
                    dll.deleteAll();
                    break;
                    case 7:                    
                    System.out.println("ENTER THE ELEMENT TO SEARCH :");
                    val=sc.nextInt();
                    System.out.println("INDEX :"+dll.Search(val));
                    break;
                    case 8:
                    System.out.println("ENTER THE INDEX :");
                    val=sc.nextInt();
                    dll.getElement(val);
                    break;
                    case 9:
                    dll.display();
                    System.out.println();
                    break;
                    case 10:
                    dll.reverse();
                    System.out.println();
                    break;
                    case 11:
                    System.out.println("TAIL VALUE : "+dll.tail.val+"            HEAD VALUE THROUGH TAIL : "+dll.tail.next.val);
                    break;
                    case 12:
                    System.exit(0);
                    default:
                    System.exit(0);
            }
        }while(true);
    }
    }

