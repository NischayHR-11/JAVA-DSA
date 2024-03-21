package Stack.StackImplementation.array;
class stack{
    private int arr[];
    private int topofstack;

    public stack(int n){
        this.arr=new int[n];
        topofstack=-1;
    }

    public void createstack(int n){
        this.arr=new int[n];
        topofstack=-1;
    }

    public boolean isempty(){
        if(topofstack==-1)
        return true;
        else
        return false;
    }
    
    public boolean isfull(){
        if(topofstack==arr.length-1)
        return true;
        else
        return false;
    }
    
    public void push(int val){
        if(isfull()){
            System.out.println("STACK IS FULL !!");
            return;
        }else{
            arr[topofstack+1]=val;
            topofstack++;
        }
    }

    public int pop(){
        if(isempty()){
            System.out.println("STACK IS EMPTY !!");
            return -1;
        }else{
           int n= arr[topofstack];
            topofstack--;
            return n;
        }
    }

    public int  peek(){
        if(isempty()){
            System.out.println("STACK IS EMPTY !!");
            return -1;
        }else{
            return arr[topofstack];
        }
    }

    public void deleteentire(){
        arr=null;
    }

    public void display(){
        for(int i=topofstack;i>=0;i--){
            System.out.println(arr[i]);
        }
    }
}

public class array {
    public static void main(String[] args) {
        stack s=new stack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println("BEFORE POPING ELEMENT");
        s.display();
        s.pop();
        System.out.println("AFTER POPING ELEMENT");
        s.display();
    }
}
