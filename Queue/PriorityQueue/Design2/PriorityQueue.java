package Queue.PriorityQueue.Design2;

class queue{

    int front,rear;
    int size;
    int a[];

    queue(int size){

        front=rear=-1;
        this.size=size;
        a=new int [size];

    }

    void enqueue(int val){

        if(rear==size-1){

            System.out.println("QUEUE IS FULL !!");
            return;
        }

        if(front==-1)
        front=0;

        a[++rear]=val;

    }

    int  dequeue(){

        if(front==-1 && rear==-1){

            System.out.println("QUEUE IS EMPTY !!");
            return -1;
        }

        int min=a[front];int index=front;

        for(int i=front;i<=rear;i++){

            if(a[i]<min){
                min=a[i];
                index=i;
            }

        }

        int n=a[index];

        for(int i=index;i<rear;i++){

            a[i]=a[i+1];
        }

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

public class PriorityQueue {

    public static void main(String[] args) {
        

        queue q=new queue(3);

        q.enqueue(4);
        q.enqueue(1);
        q.enqueue(0);
        q.enqueue(3);
        q.display();
        System.out.println("DEQUEUED ELEMENT IS : "+q.dequeue());
        q.display();
        System.out.println("DEQUEUED ELEMENT IS : "+q.dequeue());
        System.out.println("DEQUEUED ELEMENT IS : "+q.dequeue());
        System.out.println("DEQUEUED ELEMENT IS : "+q.dequeue());
        

    }
    
}
