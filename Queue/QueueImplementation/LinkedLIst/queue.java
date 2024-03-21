package Queue.QueueImplementation.LinkedLIst;

class node{
    public int val;
    public node next;
}

class linkedlist{
 public node head;
 public node tail;
 public int size;


    public boolean isempty(){
        if(head==null){
            return true;
        }else{
            return false;
        }
    }

    public void enqueue(int val){

        node newnode=new node();
        newnode.val=val;
        newnode.next=null;
        if(isempty()){
        head=newnode;
        tail=newnode;
        size=1;
        }else {
            tail.next=newnode;
            tail=newnode;
        }
        System.out.println("ELEMENT INSERTED SUCCESSFULLY..");

    }

    public int dequeue(){
        if(isempty()){
            System.out.println("QUEUE IS EMPTY!!");
        }
        int n=head.val;
        head=head.next;
        return n;
    }

    public int peek(){
        return head.val;
    }

    public void delete(){
        head=null;
        tail=null;
    }

    public void display(){
        if(head==null){
            System.out.println("NO QUEUE PRESENT !!");
            return;
        }
        node cur=head;
        while(cur.next!=null){
            System.out.print(cur.val);
            cur=cur.next;
        }
        System.out.println();
    }
}

public class queue {
    public static void main(String[] args) {
        linkedlist q=new linkedlist();
        System.out.println(q.isempty());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.isempty());
        q.display();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        System.out.println(q.isempty());
        q.display();
    }
}
