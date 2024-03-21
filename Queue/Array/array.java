

class queue{
    public int []arr;
    public int topofqueue;
    public int beginingofqueue;
   
    public queue(int n){
        arr=new int[n];
        topofqueue=-1;
        beginingofqueue=-1;
    }

    public boolean isempty(){
        if(beginingofqueue==-1||beginingofqueue==arr.length-1)
        return true;
        else
        return false;
    }

    public boolean isfull(){
        if(topofqueue==arr.length-1)
        return true;
        else
        return false;
    }

    public void enqueue(int val){

    if(isfull()){
        System.out.println("QUEUE IS FULL !!");
        return;
    }else if(isempty()){
        beginingofqueue=0;
        arr[topofqueue+1]=val;
        topofqueue++;
    }else{
        arr[topofqueue+1]=val;
        topofqueue++;
    }   
    }

    public int dequeue(){
        if(beginingofqueue==-1||beginingofqueue>arr.length-1){
            System.out.println("QUEUE IS EMPTY!!");
            return -1;
        }else{
            int n=arr[beginingofqueue];
            beginingofqueue++;
            return n;
        }
    }

    public void display(){
        for(int i=beginingofqueue;i<topofqueue;i++){
            System.out.println(arr[i]);
        }
    }
}

public class array {
    public static void main(String[] args) {
        queue q=new queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
       System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.display();


    }
}
