package LinkedList.SinglyLinkedList;

import java.util.HashSet;
import java.util.Scanner;

class node{
    public int value;
    public node next;
}
class singlyLinkedList {
    public  node head;
    public  node tail;
    public  int size;

    public  node  creatSinglyLinkedList(int val) {
        head = new node();
        node newnode = new node();
        newnode.value = val;
        newnode.next = null;
        head = newnode;
        tail = newnode;
        size = 1;
        return head;
    }

    public void insertion(int val, int pos) {
        node newnode = new node();
        newnode.value=val;
        if (head == null) {
            creatSinglyLinkedList(val);
            return;
        } else if (pos == 0) {
            newnode.next = head;
            head= newnode;
        } else if (pos >= size) {
            newnode.next = null;
            tail.next = newnode;
            tail=newnode;
        } else {
            node cur = head;
            int i = 0;
            while (i < pos-1) {
                cur = cur.next;
                i++;
            }
            newnode.next=cur.next;
            cur.next=newnode;
        }
        size++;
    }

    public void display(){
        if(head==null){
            System.out.println("NO ELEMENTS IN LIST");return;
        }
        node cur=head;
        while(cur.next!=null){
            System.out.print(cur.value+"->");
            cur=cur.next;
        }
        System.out.print(cur.value);
    }

    public void delete(int pos){
        if(pos==0){
            head=head.next;
            return;
        }
        node cur=head;int i=0;
        while(i<pos-1){
           cur=cur.next;
           i++;
        }
        if(pos==size-1)
        tail=cur;
        cur.next=cur.next.next;
        size--;
    }

    public int Search (int val){
        node cur=head;int i=0;
        while(cur.next!=null){
            if(cur.value==val)
            return i;
            cur=cur.next;
            i++;
        }
        return -1;
    }

    public int getElement(int val){
        node cur=head;int i=0;
        while(i<val){
          cur=cur.next;
          i++;
        }
        return cur.value;
    }

    public void get(int pos){
        if(head==null){
            System.out.println("NO SUCH ELEMENTS PRESENT");
            return;
        }
        node cur=head;int i=0;
        while(i<pos){
            cur=cur.next;
            i++;
        }
        System.out.print(cur.value);
    }

    public void deleteAll(){
        head=null;
        tail=null;
    }

    public void deletekey(singlyLinkedList a,int n){
        delete(a.Search(n));
    }

    public void removeduplicates(){

                    HashSet<Integer> hs=new HashSet<>();
                    node cur=head;hs.add(cur.value);
                    while(cur.next!=null){
                    if(hs.contains(cur.next.value)){
                    cur.next=cur.next.next;
                    }else{
                    hs.add(cur.next.value);
                    }
                    cur=cur.next;
                    }
    }

    public void nthLast(int n){
        node cur=head;
        node last=head;int i=0;
        while(i<n) {
            last=last.next;
            i++;
        }
        while(last!=null){
            cur=cur.next;
            last=last.next;
        }
        System.out.println("LAST Nth VALUE ELEMENT :"+cur.value);
    }

    public void makenthList(int n){
        node cur =head;int i=0;
        while(i<n-1){
            cur=cur.next;
            i++;
        }
        tail.next=head;
        head=cur.next;
        cur.next=null;
    }

    public void reverse(){
        node next=null;
        node prev=null;
        while(head!=null){
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        head=prev;
    }
}


public class sll {
    public static node head;

    @SuppressWarnings("resource")
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
            int n,val,pos;
            singlyLinkedList sll= new singlyLinkedList();
            singlyLinkedList sll1= new singlyLinkedList();
            do{
            System.out.println("------------------------------------- MENU -----------------------------------");
            System.out.println("1.CREATE SINGLY LINKED LIST");
            System.out.println("2.INSERT ELEMENT AT BEGINING");
            System.out.println("3.INSERT ELEMENT AT END");
            System.out.println("4.INSERT ELEMENT AT PARTICULAR INDEX");
            System.out.println("5.DELETE ELEMENT");
            System.out.println("6.DELTE BY KEY");
            System.out.println("7.DELETE ENTIRE LIST");
            System.out.println("8.SEARCH ELMENT");
            System.out.println("9.GET ELEMENT AT PARTICULAR INDEX");
            System.out.println("10.DISPLAY LIST");
            System.out.println("11.REMOVE DUPLICATES OF LIST");
            System.out.println("12.RETURN Nth VALUE FROM LAST");
            System.out.println("13.TO MAKE ALL NODES LESS THAN X COME BEFORE THE NODES GREATER THAN OR EQUAL TO X.");
            System.out.println("14.REVERSE LIST");
            System.out.println("15.TO ADD TWO LIST BY REVERSING AND RESULTS THE LIST IN REVERSE in p class");
            System.out.println("15.tail value");
            System.out.println("16.EXIT");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("ENTER THE CHOICE :");
            n=sc.nextInt();
            switch (n) {
                    case 1:
                    System.out.println("ENTER THE VALUE OF FIRST ELEMENT :");
                    val=sc.nextInt();
                    sll.creatSinglyLinkedList(val);
                    break;
                    case 2:                    
                    System.out.println("ENTER THE VALUE OF ELEMENT TO INSERT :");
                    val=sc.nextInt();
                    sll.insertion(val,0);
                    sll.insertion(val, 0);
                    break;
                    case 3:
                    System.out.println("ENTER THE VALUE OF ELEMENT TO INSERT :");
                    val=sc.nextInt();
                    sll.insertion(val,sll.size+2);
                    break;
                    case 4:                    
                    System.out.println("ENTER THE VALUE AND POSITION OF ELEMENT TO INSERT :");
                    val=sc.nextInt();pos=sc.nextInt();
                    sll.insertion(val,pos);
                    break;
                    case 5:
                    System.out.println("ENTER THE INDEX OF ELEMENT TO DELETE :");
                    val=sc.nextInt();
                    sll.delete(val);
                    break;
                    case 6:                   
                    System.out.println("ENTER THE INDEX OF ELEMENT TO DELETE :");
                    val=sc.nextInt();
                    sll.deletekey(sll,val);
                    break;
                    case 7:
                    System.out.println("LIST DELETED SUCCESSFULLY.......");
                    sll.deleteAll();
                    break;
                    case 8:                    
                    System.out.println("ENTER THE ELEMENT TO SEARCH :");
                    val=sc.nextInt();
                    System.out.println("INDEX :"+sll.Search(val));
                    break;
                    case 9:
                    System.out.println("ENTER THE INDEX :");
                    val=sc.nextInt();
                    System.out.println("ELEMENT :"+sll.getElement(val));
                    break;
                    case 10:
                    sll.display();
                    System.out.println();
                    break;
                    case 11:
                    sll.removeduplicates();
                    break;
                    case 12:  
                    System.out.println("ENTER THE Nth LAST POSITION OF ELEMENT:");
                    val=sc.nextInt();
                    sll.nthLast(val);
                    break;
                    case 13 :                    
                    System.out.println("ENTER THE VALUE OF X:");
                    val=sc.nextInt();
                    sll.makenthList(val);
                    break;
                    case 14:
                    sll.reverse();
                    break;
                    case 15 :
                    System.out.println(sll.tail.value);
                    break;
                    case 16:
                    System.exit(0);
                    break;
            
                   default:
                   System.exit(0);
            }
        }while(true);
    }
}
