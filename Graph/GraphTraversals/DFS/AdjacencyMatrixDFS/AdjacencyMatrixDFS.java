package Graph.GraphTraversals.DFS.AdjacencyMatrixDFS;
import java.util.*;

// Undirected Graph

// Time Complexity : O(V+E);   Space Complexity : O(V+E);

class GraphNode{

    public String data;
    public int index;
    public boolean visited;

    public GraphNode(String n,int i){
        data=n;
        index=i;
        visited=false;
    }

}

class Graph{

    private ArrayList<GraphNode> nodeList;
    private int matrix[][];

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

    private void BFS(GraphNode a){

        Queue<GraphNode> q =new LinkedList<>();
        q.add(a);
        a.visited=true;

        while(!q.isEmpty()){

            GraphNode cur=q.remove();
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

    public void BFS(){

        for(GraphNode x :nodeList){

            if(!x.visited)
            BFS(x);

        }
    }

    private void  DFS(GraphNode a){

        Stack <GraphNode> s=new Stack<>();

        s.push(a);
        a.visited=true;

        while(!s.isEmpty()){

            GraphNode cur =s.pop();
            System.out.print(cur.data+" ");
            ArrayList<GraphNode> neighbours=getNeighbours(cur);
            Collections.reverse(neighbours);
            
            for(GraphNode x :neighbours){

                if(!x.visited){
                    s.push(x);
                    x.visited=true;
                }

            }

        }

    }
    
    public void DFS(){

        for( GraphNode Node :nodeList){

            if(!Node.visited)
            DFS(Node);
        }
    }

    public void display(){

        System.out.print("    ");

        for(GraphNode x :nodeList){

            System.out.print(x.data+" ");

        }

        System.out.println();

        for(int i=0;i<matrix.length;i++){

            System.out.print(nodeList.get(i).data+" : ");

            for(int j=0;j<matrix[i].length;j++){

                System.out.print(matrix[i][j]+" ");

            }

            System.out.println();
        }
    }
}


public class AdjacencyMatrixDFS {

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
        GM.AddEdges(1, 4);
        GM.AddEdges(2, 3);
        GM.AddEdges(3, 4);

        GM.display();

        System.out.println("DFS TRAVERSAL :");
        GM.DFS();
        
    }
    
}
