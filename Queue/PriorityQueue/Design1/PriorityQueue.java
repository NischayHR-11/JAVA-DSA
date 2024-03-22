package Queue.PriorityQueue.Design1;

class queue{

    private int front,rear;
    private int size;
    private int a[];

    public queue(int size){

        front=rear=-1;
        this.size=size;
        a=new int [size];

    }

    public void enqueue(int val){

        if(rear==size-1){
            System.out.println("ENQUEUE NOT POSSIBLE !! QUEUE IS FULL");
            return;
        }

        if(front==-1)
        front=0;

        int i=rear;

        for(;i>=front && a[i]>val;i--){

            a[i+1]=a[i];
        }

        a[i+1]=val;
        rear++;
    }

    public int dequeue(){

        if(front==-1 && rear==-1){
            System.out.println("DEQUEUE NOT POSSIBLE !! QUEUE IS EMPTY");
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

    public int peek(){

        if(front==-1 && rear==-1){
            System.out.println("DEQUEUE NOT POSSIBLE !! QUEUE IS EMPTY");
            return -1;
        }

        return a[front];

    }

    public void display(){

        for(int i=front;i<=rear;i++){

            System.out.print(a[i]+" ");
        }

        System.out.println();
    }

}

public class PriorityQueue {

    public static void main(String[] args) {

        queue q=new queue(3);

        q.enqueue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(4);
        q.display();
        System.out.println("DEQUEUED ELEMENT IS : "+q.dequeue());
        System.out.println("DEQUEUED ELEMENT IS : "+q.dequeue());
        System.out.println("DEQUEUED ELEMENT IS : "+q.dequeue());
        System.out.println("DEQUEUED ELEMENT IS : "+q.dequeue());
        
    }
    
}
