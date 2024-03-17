package Graph.TopologicalSorting.AM_TopologicalSort;
import java.util.*;

// Directed Graph

// Time Complexity : O(V+E);       Space Complexity : O(V+E); 

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

    private ArrayList<GraphNode>nodeList;
    private int matrix[][];

    public Graph(ArrayList<GraphNode> nodeList){

        this.nodeList=nodeList;
        this.matrix=new int[nodeList.size()][nodeList.size()];

    }

    public void AddUNdirectedEdges(int i,int j){

        matrix[i][j]=1;
        matrix[j][i]=1;

    }

    public void AddDirectedEdges(int i,int j){

        matrix[i][j]=1;

    }

    private ArrayList<GraphNode> getneighbours(GraphNode node){

        ArrayList <GraphNode> neighbours =new ArrayList<>();

        for(int i=0;i<matrix.length;i++){

            if(matrix[node.index][i]==1){

                neighbours.add(nodeList.get(i));
            }
        }

        return neighbours;

    }

    private void TopologicalSort(Stack<GraphNode> s,GraphNode node){

        ArrayList<GraphNode> neighbours = getneighbours(node);

        for(GraphNode neighbour :neighbours){

            if(!neighbour.visited){
                TopologicalSort(s,neighbour);
            }
        }

        node.visited=true;
        s.push(node);

    }

    public void TopologicalSort(){

        Stack <GraphNode> stack =new Stack<>();

        for(GraphNode node : nodeList){

            if(!node.visited)
            TopologicalSort(stack,node);
        }

        while(!stack.isEmpty()){

            System.out.print(stack.pop().data+" ");

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


public class AdjacencyMatrixTopologicalSort {

    public static void main(String[] args) {

        ArrayList <GraphNode> nodeList =new ArrayList<>();

        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));
        nodeList.add(new GraphNode("H", 7));

        Graph TS =new Graph(nodeList);

        TS.AddDirectedEdges(0, 2);
        TS.AddDirectedEdges(2, 4);
        TS.AddDirectedEdges(4, 7);
        TS.AddDirectedEdges(4, 5);
        TS.AddDirectedEdges(5, 6);
        TS.AddDirectedEdges(1, 2);
        TS.AddDirectedEdges(1, 3);
        TS.AddDirectedEdges(3, 5);

        TS.display();

        System.out.println("TOPOLOGICAL SORT :");
        TS.TopologicalSort();
        
        
    }
    
}
