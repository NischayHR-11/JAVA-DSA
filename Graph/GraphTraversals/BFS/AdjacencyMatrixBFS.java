package Graph.GraphTraversals.BFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class GraphNode{

    String data;
    int index;
    boolean visited;

    public GraphNode(String n,int i){
        data=n;
        index=i;
        visited=false;
    }

}

class Graph{

    ArrayList<GraphNode> nodeList;
    int matrix[][];

    public Graph(ArrayList<GraphNode> nodeList){

        this.nodeList=nodeList;
        matrix=new int[nodeList.size()][nodeList.size()];

    }

    public void AddEdges(int i,int j){

        matrix[i][j]=1;
        matrix[j][i]=1;

    }

    private ArrayList<GraphNode> getNeighbours(GraphNode n){

        ArrayList<GraphNode> neighbours=new ArrayList<>();

        for(int i=0;i<matrix.length;i++){

            if(matrix[n.index][i]==1){
                neighbours.add(nodeList.get(i));
            }
        }

        return neighbours;

    }

    public void BFS(GraphNode a){

        Queue<GraphNode> q =new LinkedList<>();
        q.add(a);
        while(!q.isEmpty()){

            GraphNode cur=q.remove();
            cur.visited=true;
            System.out.print(cur.data+" ");
            ArrayList<GraphNode> neighbours=getNeighbours(cur);
            for(GraphNode x :neighbours){

                if(!x.visited){
                    q.add(x);
                    x.visited=true;
                }
            }
        }
    }

}


public class AdjacencyMatrixBFS {

    public static void main(String[] args) {

        
        ArrayList<GraphNode>nodeList=new ArrayList<>();

        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        Graph GM =new Graph(nodeList);

        GM.AddEdges(0, 1);
        GM.AddEdges(0, 2);
        GM.AddEdges(0, 3);
        GM.AddEdges(1, 0);
        GM.AddEdges(1, 4);
        GM.AddEdges(2, 0);
        GM.AddEdges(2, 3);
        GM.AddEdges(3, 0);
        GM.AddEdges(3, 2);
        GM.AddEdges(3, 4);
        GM.AddEdges(4, 1);
        GM.AddEdges(4, 3);

        GM.BFS(nodeList.get(0));
        
    }
    
}
