package Stack.linkedlist;

class node{
    public int val;
    public node next;
}

class ll{
    public node head;
    public int size;

    public boolean isempty(){
        if(head==null)
        return true;
        else
        return false;
    }

    public void createstack(int val){
        head=new node();
        node newnode=new node();
        newnode.val=val;
        newnode.next=null;
        head=newnode;
        size=1;
    }

    public void push(int val){
        node newnode=new node();
        newnode.val=val;
        newnode.next=head;
        head=newnode;
    }

    public int pop(){
        if(head==null){
            System.out.println("NO STACK PRESENT !!");
            return -1;
        }
        int n=head.val;
        head=head.next;
        return n;
    }

    public int peek(){

        if(head==null){
            System.out.println("NO STACK PRESENT !!");
            return -1;
        }else{
            return head.val;
        }
    }

    public void deleteall(){
        head=null;
    }

    public void display(){
        if(head==null){
            System.out.println("NO STACK PRESENT !!");
            return;
        }
        node cur =head;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
}
public class linkedlist {
    public static void main(String[] args) {
        
            ll l=new ll();
            l.push(1);
            l.push(2);
            l.push(3);
            l.push(4);
            l.push(5);
            l.push(6);
            l.display();
            System.out.println(l.pop());
            l.display();
            l.deleteall();
            l.display();

    }
    
}
