package Graph.AdjacencyList;

import java.util.ArrayList;

class GraphNode{

    String data;
    int index;
    ArrayList<GraphNode>neighbour;

    GraphNode(String data,int i){

        this.data=data;
        index=i;
        neighbour=new ArrayList<>();

    }
}

class Graph{

    ArrayList<GraphNode> nodeList;

    public Graph(ArrayList<GraphNode> nodeList){

        this.nodeList=nodeList;

    }

    public void AddEdges(int i,int j){

        nodeList.get(i).neighbour.add(nodeList.get(j));
        nodeList.get(j).neighbour.add(nodeList.get(i));
    }

    public void display(){

        for(GraphNode x :nodeList){

            System.out.print(x.data+" : ");

            for(GraphNode y :x.neighbour){

                System.out.print(y.data+" ");
            }
            System.out.println();
        }
    }
}

public class AdjacencyList {

    public static void main(String[] args) {

        ArrayList<GraphNode>nodeList=new ArrayList<>();

        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        Graph GL =new Graph(nodeList);

        GL.AddEdges(0, 1);
        GL.AddEdges(0, 2);
        GL.AddEdges(0, 3);
        GL.AddEdges(1, 4);
        GL.AddEdges(2, 3);
        GL.AddEdges(3, 4);

        GL.display();
        
    }
    
}
