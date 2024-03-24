package Graph.APSPP.FloydWarshaalAlgorithm.AdjacencyMatrix;
import java.util.*;

// All Pair Shortest Path Problem.

// All Pair Shortest Path Problem.

// Time Complexity : O(V^3);       Space Complexity : O(V^2);

class GraphNode{

    public String data;
    public int index;

    public GraphNode(String n,int i){

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

    public void initialize(){

        for(int i=0;i<matrix.length;i++){

            for(int j=0;j<matrix.length;j++){

                if(i==j){
                    matrix[i][j]=0;
                }else{
                    matrix[i][j]=Integer.MAX_VALUE/10;
                }
            }
        }
        
    }

    public void AddDirectedEdges(int i,int j,int d){

        matrix[i][j]=d;

    }

    public void FloydWarshaal(){

        for(int k=0;k<matrix.length;k++){

            for(int i=0;i<matrix.length;i++){

                for(int j=0;j<matrix.length;j++){

                    if(matrix[i][j]>matrix[i][k]+matrix[k][j]){

                        matrix[i][j]=matrix[i][k]+matrix[k][j];
                    }
                }
            }
        }

        display();
    }


    public void display(){

        System.out.print("                     ");

        for(GraphNode x :nodeList){

            System.out.print(x.data+" ");

        }

        System.out.println();

        for(int i=0;i<matrix.length;i++){

            System.out.print("NODE  "+nodeList.get(i).data+"  DISTANCE  : ");

            for(int j=0;j<matrix[i].length;j++){

                System.out.print(matrix[i][j]+" ");

            }

            System.out.println();
        }
    }
}

public class FloydWarshaalAlgorithm {
    public static void main(String[] args) {
        
        ArrayList <GraphNode> nodeList =new ArrayList<>();

        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));

        Graph FA = new Graph(nodeList);

        FA.initialize();
        FA.AddDirectedEdges(0, 3, 1);
        FA.AddDirectedEdges(0, 1, 8);
        FA.AddDirectedEdges(1, 2, 1);
        FA.AddDirectedEdges(2, 0, 4);
        FA.AddDirectedEdges(3, 1, 2);
        FA.AddDirectedEdges(3, 2, 9);

        System.out.println("Floyd Warshall Algorithm : \n");

        FA.FloydWarshaal();

    }
    
}
