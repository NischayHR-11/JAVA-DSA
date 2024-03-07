package Tree.HeapTree;

class heap{
    private int arr[];
    public int sizeoftree;
    
    public heap(int n){
        arr=new int[n+1];
        sizeoftree=0; 
    }

    public void HeapfyButtomtoTOP(int indx,String type){
        int parent=indx/2;
          if(indx<=1){
            return;
        }
        if(type=="Max"){
            if(arr[indx]>arr[parent]){
                int temp=arr[parent];
                arr[parent]=arr[indx];
                arr[indx]=temp;
            }
        }else{
            if(arr[indx]<arr[parent]){
                int temp=arr[parent];
                arr[parent]=arr[indx];
                arr[indx]=temp;
            }
        }
        HeapfyButtomtoTOP(parent, type);
    }

    public void insert(int val,String type){
        if(sizeoftree==arr.length-1){
            System.out.println("TREE IS FULL!!");
            return;
        }
        arr[++sizeoftree]=val;
        HeapfyButtomtoTOP(sizeoftree,type);
    }


    public void HeapfyToptoButtom(int indx,String type){
        int left=indx*2;
        int right=indx*2+1;
        int swapchild=0;
        if(left>sizeoftree){
            return;
        }
        if(type=="Max"){
            if(left==sizeoftree){
                if(arr[indx]<arr[left]){
                int temp=arr[indx];
                arr[indx]=arr[left];
                arr[left]=temp;
            }
            return;
        }else{
            if(arr[left]>arr[right]){
                swapchild=left;
            }else{
                swapchild=right;
            }
            if(arr[indx]<arr[swapchild]){
                int temp=arr[indx];
                arr[indx]=arr[swapchild];
                arr[swapchild]=temp;
            }
        }
        }
        else{
            if(left==sizeoftree){
                if(arr[indx]>arr[left]){
                int temp=arr[indx];
                arr[indx]=arr[left];
                arr[left]=temp;
            }
            return;
        }else{
            if(arr[left]<arr[right]){
                swapchild=left;
            }else{
                swapchild=right;
            }
            if(arr[indx]>arr[swapchild]){
                int temp=arr[indx];
                arr[indx]=arr[swapchild];
                arr[swapchild]=temp;
            }
        }            
    }
            HeapfyToptoButtom(swapchild, type);
    }


    public int extractHead(String type){
        if(sizeoftree==0){
            System.out.println("TREE IS EMPTY!!");
            return-1;
        }
        int n=arr[1];
        arr[1]=arr[sizeoftree];
        sizeoftree--;
        HeapfyToptoButtom(1,type);
        return n;
    }

    public void search(int val){
        for(int i=0;i<=sizeoftree;i++){
            if(arr[i]==val){
                System.out.println("ELEMENT FOUND IN THE TREE...");
                return;
            }
        }
        System.out.println("ELEMENT NOT FOUND IN THE TREE!!");
    }

    public void deleteTree(){
        arr=null;
        System.out.println("TREE DELETED SUCCESSFULLY...");
    }

    public void levelorderprint(){
        for(int i=1;i<=sizeoftree;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

public class minimumMaximum{
     public static void main(String[] args) {
        
        heap h=new heap(8);
        h.insert(5, "Min");
        h.insert(2, "Min");
        h.insert(7, "Min");
        h.insert(4, "Min");
        h.insert(1, "Min");
        h.insert(6, "Min");
        h.insert(3, "Min");
        h.insert(8, "Min");
        h.levelorderprint();
        System.out.println();
        h.extractHead("Min");
        h.levelorderprint();
        System.out.println();
        h.search(5);
    }
}
