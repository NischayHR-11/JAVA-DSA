package LinkedList.doublylinkedlist;

import java.util.Scanner;

class node{
    public int val;
    public node next;
    public node prev;
}
class doublylinkedlist{
    public node head;
    public node tail;
    public int size;

    public node creatdoublylinkedlist(int val){
        head=new node();
        node newnode=new node();
        newnode.val=val;
        newnode.next=null;
        newnode.prev=head;
        head=newnode;
        tail=newnode;
        return head;
    }

    public void insertion(int val,int pos){
        node newnode=new node();
        newnode.val=val;
        if(head==null){
            creatdoublylinkedlist(val);
            return;
        }else if (pos==0){
            newnode.next=head;
            head.prev=newnode;
            newnode.prev=head;
            head=newnode;
        }else if(pos>=size){
            newnode.next=null;
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

    public void display(){
        if(head==null){
            System.out.println("LIST IS EMPTY !!");
            return;
        }
        node cur=head;
        while(cur.next!=null){
            System.out.print(cur.val+"->");
            cur=cur.next;
        }
        System.out.print(cur.val);
    }

    public void reversedisplay(){
    //     node cur=tail;
    //     while(cur.prev!=head){
    //         System.out.print(cur.val+"<-");
    //         cur=cur.prev;
    //     }
    //    System.out.print(cur.val+"<-");
    //     System.out.print(cur.prev.val);
            node cur=head;
        while(cur.next!=null){
            System.out.print(cur.val+"<-");
            cur=cur.next;
        }
        System.out.print(cur.val);
    }

    public void delete(int pos){
        node cur=head;int i=0;
        while(i<pos-1){
            cur=cur.next;
            i++;
        }
        cur.next=cur.next.next;
        size--;
    }

    public void deleteAll(){
        head=null;
        tail.next=null;
        tail=null;
    }

    public int Search(int key){
        node cur=head;int i=0;
        while(cur.next!=head){
            if(cur.val==key)
            return i;
            cur=cur.next;
            i++;
        }
        return-1;
    }

    public void getElement(int k){
        node cur =head;int i=0;
        while(i<k){
            cur=cur.next;
            i++;
        }
        System.out.println("INDEX "+k+" : "+cur.val);
    }

}


public class dll {
    public static void main(String[] args) {
        doublylinkedlist dll=new doublylinkedlist();
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
            System.out.println("11.EXIT");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("ENTER THE CHOICE :");
            n=sc.nextInt();
            switch (n) {
                    case 1:
                    System.out.println("ENTER THE VALUE OF FIRST ELEMENT :");
                    val=sc.nextInt();
                    dll.creatdoublylinkedlist(val);
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
                    dll.reversedisplay();
                    System.out.println();
                    break;
                    case 11:
                    System.exit(0);
                    default:
                    System.exit(0);
            }
        }while(true);
    }
}
