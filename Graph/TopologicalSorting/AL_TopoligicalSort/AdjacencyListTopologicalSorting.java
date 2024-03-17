package Graph.TopologicalSorting.AL_TopoligicalSort;
import java.util.*;

// Directed Graph

// Time Complexity : O(V+E);       Space Complexity : O(V+E); 

class GraphNode{

    public String data;
    public int index;
    public boolean visited;
    public ArrayList<GraphNode>neighbours;

    public GraphNode(String data,int i){

        this.data=data;
        index=i;
        visited=false;
        neighbours=new ArrayList<>();

    }
}

class Graph{

    private ArrayList<GraphNode> nodeList;

    public Graph(ArrayList<GraphNode> nodeList){

        this.nodeList=nodeList;

    }

    public void AddUndirectedEdges(int i,int j){

        nodeList.get(i).neighbours.add(nodeList.get(j));
        nodeList.get(j).neighbours.add(nodeList.get(i));
    }

    public void AddDirectedEdges(int i,int j){

        nodeList.get(i).neighbours.add(nodeList.get(j));
    }

    private void TopologicalSort(GraphNode node,Stack<GraphNode> s){

        for(GraphNode neighbour :node.neighbours){

            if(!neighbour.visited){
                TopologicalSort(neighbour,s);
            }
        }

        node.visited=true;
        s.push(node);
    }

    public void TopologicalSort(){

        Stack<GraphNode> stack=new Stack<>();

        for(GraphNode node :nodeList){

            if(!node.visited)
            TopologicalSort(node,stack);

        }

        while(!stack.isEmpty()){

            System.out.print(stack.pop().data +" ");
        }
    }

    public void display(){

        for(GraphNode x :nodeList){

            System.out.print(x.data+" : ");

            for(GraphNode y :x.neighbours){

                System.out.print(y.data+" ");
            }
            System.out.println();
        }
    }
}

public class AdjacencyListTopologicalSorting {

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
