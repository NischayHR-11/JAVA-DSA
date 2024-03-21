
class Circularqueue{

    private int front,rear;
    private int size;
    private int a[];

    public Circularqueue(int size){

        this.size=size;
        a=new int[size];
        front=rear=-1;
    }


    public void enqueue(int val){

        if((rear+1)%size==front){
            System.out.println("ENQUEUE NOT POSSIBLE !! QUEUE IS FULL");
            return;
        }

        if(front==-1)
        front=0;

        rear=(rear+1)%size;

        a[rear]=val;

    }

    public int dequeue(){

        if(rear==-1 && front==-1){
            System.out.println("DEQUEUE NOT POSIIBLE !! QUEUE IS EMPTY ");
            return -1;
        }

        int n=a[front];

        if(rear==front){
        front=rear=-1;
        }else{
            front=(front+1)%size;
        }

        return n;
    }

    public int peek(){

        if(rear==-1 && front==-1){
            System.out.println("DEQUEUE NOT POSIIBLE !! QUEUE IS EMPTY ");
            return -1;
        }

        return a[front];
    }

    public void display(){

        int i=front;

        while(i!=rear){

            System.out.print(a[i]+" ");
            i=(i+1)%size;

        }

        System.out.print(a[i]);
    }
}




class CircularQueue{

    public static void main(String[] args) {

        Circularqueue q =new Circularqueue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        
    }
}