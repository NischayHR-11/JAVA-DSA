package Graph.SSSPP.BFS.AL_BFS_SSSPP;

import java.util.*;

// Undirected Graph.

// Time complexity : O(E); {Edges}          Space Complexity : O(V); {vertices}

// Single Source Shortest Path Problem.

// It Is Not Applicable For Weighted Graphs .

class GraphNode{

    public String data;
    public int index;
    public boolean visited;
    public GraphNode parent;
    public ArrayList<GraphNode>neighbours;

    GraphNode(String data,int i){

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

    private void path(GraphNode node){

        if(node.parent!=null){

            path(node.parent);
        }

        System.out.print(node.data +" ");
    }

    public void BFS_SSSPP(GraphNode node){

        Queue<GraphNode> q=new LinkedList<>();

        q.add(node);
        node.visited=true;

        while(!q.isEmpty()){

            GraphNode cur=q.remove();
            System.out.print( "PATH FOR "+cur.data+ " : ");
            path(cur);
            System.out.println();
            for(GraphNode neighbour:cur.neighbours){

                if(!neighbour.visited){
                    q.add(neighbour);
                    neighbour.visited=true;
                    neighbour.parent=cur;
                }
            }
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


public class AdjacencyListSSSPP {

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
