package Graph.GraphRepresentation.AdjacencyMatrix;
import java.util.ArrayList;

// UnDirected Graph.

class GraphNode{

    public String data;
    public int index;

    GraphNode(String n,int i){

        data=n;
        index=i;
    }
}

class Graph{

    private ArrayList<GraphNode>nodeList;
    private int matrix[][];

    public Graph(ArrayList<GraphNode> nodeList){

        this.nodeList=nodeList;
        this.matrix=new int[nodeList.size()][nodeList.size()];

    }

    public void AddEdges(int i,int j){

        matrix[i][j]=1;
        matrix[j][i]=1;

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

public class AdjacencyMatrix {
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
        
    }
    
}
