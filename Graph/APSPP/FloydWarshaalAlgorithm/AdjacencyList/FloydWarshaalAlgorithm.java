package Graph.APSPP.FloydWarshaalAlgorithm.AdjacencyList;
import java.util.*;

// All Pair Shortest Path Problem.

// Time complexity : O(V^3);     Space Complexity : O(V^2);

class WeightedGraphNode implements Comparable<WeightedGraphNode>{

    public String data;
    public int index;
    public boolean visited;
    public int distance;
    public WeightedGraphNode parent;
    public ArrayList <WeightedGraphNode> neighbours;
    public HashMap<WeightedGraphNode,Integer> wieghtedEdge;

    public WeightedGraphNode(String name,int index){

        data=name;
        this.index=index;
        visited=false;
        distance=Integer.MAX_VALUE;
        neighbours=new ArrayList<>();
        wieghtedEdge=new HashMap<>();

    }

    @Override

    public String toString(){

        return data;
    }

    @Override

    public int compareTo(WeightedGraphNode o){

        return this.distance-o.distance;
    }

}

class WeightedGraph{

    private ArrayList <WeightedGraphNode> nodeList;
    int matrix[][];

    public WeightedGraph(ArrayList<WeightedGraphNode> nodeList){

        this.nodeList=nodeList;
        matrix=new int[nodeList.size()][nodeList.size()];
    }

    public void AddDirectedEdges(int i,int j, int d){

        nodeList.get(i).neighbours.add(nodeList.get(j));
        nodeList.get(i).wieghtedEdge.put(nodeList.get(j),d);

    }


public void initialize() {
    for (int i = 0; i < matrix.length; i++) {
		WeightedGraphNode first = nodeList.get(i);
        for (int j = 0; j < matrix.length; j++) {
            WeightedGraphNode sec = nodeList.get(j);
            if (i == j) {
                matrix[i][j] = 0;
            } else if (first.wieghtedEdge.containsKey(sec)) {
                matrix[i][j] = first.wieghtedEdge.get(sec);
            } else {
                matrix[i][j] = Integer.MAX_VALUE / 10;
            }
        }
    }
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
    
        for(int i=0;i<matrix.length;i++){

            System.out.print("NODE "+nodeList.get(i)+" DISTANCE : ");

            for(int j=0;j<matrix.length;j++){

                System.out.print(matrix[i][j]+" ");
            }

            System.out.println();

        }
    }



}

public class FloydWarshaalAlgorithm {

    public static void main(String[] args) {
        

        ArrayList <WeightedGraphNode> nodeList =new ArrayList<>();

        nodeList.add(new WeightedGraphNode("A", 0));
        nodeList.add(new WeightedGraphNode("B", 1));
        nodeList.add(new WeightedGraphNode("C", 2));
        nodeList.add(new WeightedGraphNode("D", 3));

        WeightedGraph FA = new WeightedGraph(nodeList);

        FA.AddDirectedEdges(0, 3, 1);
        FA.AddDirectedEdges(0, 1, 8);
        FA.AddDirectedEdges(1, 2, 1);
        FA.AddDirectedEdges(2, 0, 4);
        FA.AddDirectedEdges(3, 1, 2);
        FA.AddDirectedEdges(3, 2, 9);
		FA.initialize();

        System.out.println("Floyd Warshall Algorithm : \n");

        FA.FloydWarshaal();
    }
    
}

