package Queue.DoubleEndedQueue;

class queue{

    int front,rear;
    int size;
    int a[];

    queue(int size){

        front=rear=-1;
        this.size=size;
        a=new int[size];
    }

    void InsertAtFront(int val){

        if(front>0 && front<rear){
             
            a[--front]=val;
            return;
        }

        if(front==-1){
            front=0;
            a[++rear]=val;
            return;
        }

        System.out.println("INSERT AT FRONT NOT POSSIBLE !!");
    }

    void InsertAtRear(int val){

        if(rear==size-1){
            System.out.println("INSERT AT REAR NOT POSSIBLE !! QUEUE IS FULL");
            return;
        }

        if(front==-1){
            front=0;
        }

        a[++rear]=val;
    }

    int DeleteAtFront(){

        if(front==-1 && rear==-1){

            System.out.println("DELETE AT FRONT NOT POSSIBLE !! QUEUE IS EMPTY");
            return -1;
        }

        int n=a[front];

        if(front==rear){
            front=rear=-1;
        }else{
            front++;
        }

        return n;
    }

    int DeleteAtRear(){

        if(front ==-1 && rear==-1){
            System.out.println("DELETE AT REAR NOT POSSIBLE !! QUEUE IS EMPTY");
            return -1;
        }

        int n=a[rear];

        if(front==rear){

            front=rear=-1;
        }else{

            rear--;
        }

        return n;
    }

    void display(){

        for(int i=front;i<=rear;i++){

            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}

public class DoubleEndedQueue {

    public static void main(String[] args) {

        queue q= new queue(3);

        q.InsertAtFront(1);
        q.InsertAtFront(2);
        q.InsertAtRear(2);
        q.InsertAtRear(3);
        q.InsertAtRear(4);
        q.display();
        System.out.println(q.DeleteAtFront());
        System.out.println(q.DeleteAtRear()); 
        q.display();      
    }
    
}
