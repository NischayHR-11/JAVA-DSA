package Queue.QueueImplementation.Array;

class circularqueue{
    public int []arr;
    public int beginingofqueue;
    public int topofqueue;

    public circularqueue(int n){
        arr=new int[n];
        beginingofqueue=-1;
        topofqueue=-1;
    }

    public boolean isempty(){
        if(beginingofqueue==-1){
        return true;
        }else{
            return false;
        }
    }

    public boolean isfull(){
        if(beginingofqueue==0 && topofqueue ==arr.length-1 ){
            return true;
        }else if (topofqueue+1==beginingofqueue){
            return true;
        }else{
            return false;
        }
    }

    public void enqueue(int val){
        if(isfull()){
            System.out.println("LIST IS FULL!!");
            return;
        }else if (isempty()){
            beginingofqueue=0;
            topofqueue++;
            arr[topofqueue]=val;
        }else if(topofqueue==arr.length-1){
            topofqueue=0;
            arr[topofqueue]=val;
        }else{
            topofqueue++;
            arr[topofqueue]=val;
        }
        System.out.println("ELEMENT INSERTED SUCCESSFULLY..");
    }

    public int dequeue(){
        int n=arr[beginingofqueue];
        if(isempty()){
            System.out.println("NO ELEMENT PRESENT !!");
            return -1;
        }else if(beginingofqueue==arr.length-1){
            arr[beginingofqueue]=0;
            beginingofqueue=0;
            return n;
        }else{
            arr[beginingofqueue]=0;
            beginingofqueue++;
            return n;
        }
    }

    public int peek(){
        return arr[topofqueue];
    }

    public void delete(){
        arr=null;
    }

}

public class circulararray {
    public static void main(String[] args) {
        
        circularqueue q=new circularqueue(4);
        System.out.println(q.isempty());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        q.enqueue(5);
        q.enqueue(5);
        q.enqueue(5);       
        System.out.println(q.peek());
        System.out.println(q.isfull());
        System.out.println(q.isempty());

    }
}
