package Graph.SSSPP.BFS.AM_BFS_SSSPP;
import java.util.*;

// UnDirected Graph.

// Time complexity : O(E); {Edges}          Space Complexity : O(V); {vertices}

// Single Source Shortest Path Problem.

class GraphNode{

    public String data;
    public int index;
    public boolean visited;
    public GraphNode parent;

    GraphNode(String n,int i){

        data=n;
        index=i;
        visited=false;

    }
}

class Graph{

    private ArrayList<GraphNode>nodeList;
    private int matrix[][];

    public Graph(ArrayList<GraphNode> nodeList){

        this.nodeList=nodeList;
        this.matrix=new int[nodeList.size()][nodeList.size()];

    }

    public void AddUndirectedEdges(int i,int j){

        matrix[i][j]=1;
        matrix[j][i]=1;

    }

    private ArrayList<GraphNode> getneighbours(GraphNode node){

        ArrayList<GraphNode> neighbours =new ArrayList<>();

        for(int i=0;i<matrix.length;i++){

            if(matrix[node.index][i]==1)
            neighbours.add(nodeList.get(i));

        }

        return neighbours;
    }

    private void Path(GraphNode node){

        if(node.parent!=null){
            Path(node.parent);
        }

        System.out.print(node.data+" ");
    }

    public void BFS_SSSPP(GraphNode node){

        Queue <GraphNode> q=new LinkedList<>();

        q.add(node);
        node.visited=true;

        while(!q.isEmpty()){

            GraphNode cur=q.remove();
            System.out.print("PATH FOR "+cur.data+" : ");
            Path(cur);
            System.out.println();

            ArrayList <GraphNode> neighbours=getneighbours(cur); 

            for(GraphNode neighbour :neighbours){

                if(!neighbour.visited){
                    q.add(neighbour);
                    neighbour.visited=true;
                    neighbour.parent=cur;
                }
            }

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

        System.out.println();
    }
}

public class AdjacencyMatrixSSSPP {
    public static void main(String[] args) {

        ArrayList<GraphNode>nodeList=new ArrayList<>();

        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));

        Graph GL =new Graph(nodeList);

        GL.AddUndirectedEdges(0, 1);
        GL.AddUndirectedEdges(0, 2);
        GL.AddUndirectedEdges(1, 3);
        GL.AddUndirectedEdges(1, 6);
        GL.AddUndirectedEdges(2, 3);
        GL.AddUndirectedEdges(2, 4);
        GL.AddUndirectedEdges(3, 5);
        GL.AddUndirectedEdges(4, 5);
        GL.AddUndirectedEdges(5, 6);

        GL.display();

        System.out.println("SSSPP IF 'A' IS SOURCE :");
        GL.BFS_SSSPP(nodeList.get(0));
        
    }
    
}
