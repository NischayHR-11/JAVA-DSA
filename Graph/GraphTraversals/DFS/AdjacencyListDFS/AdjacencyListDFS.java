package Graph.GraphTraversals.DFS.AdjacencyListDFS;
import java.util.*;

// Undirected Graph

// Time Complexity : O(V+E);   Space Complexity : O(V+E);

class GraphNode{

    public String data;
    public int index ;
    public boolean visited;
    public ArrayList<GraphNode> neighbours;

    public GraphNode(String n ,int i){

        data=n;
        index=i;
        neighbours=new ArrayList<>();

    }
}

class Graph{

    private ArrayList<GraphNode> nodeList;

    public Graph(ArrayList<GraphNode> nodeList){

        this.nodeList=nodeList;

    }

    public void AddEdges(int i,int j){

        nodeList.get(i).neighbours.add(nodeList.get(j));
        nodeList.get(j).neighbours.add(nodeList.get(i));

    }

    private void BFS(GraphNode a){

        Queue<GraphNode> q=new LinkedList<>();

        q.add(a);
        a.visited=true;

        while(!q.isEmpty()){

            GraphNode cur=q.remove();
            System.out.print(cur.data+" ");
            for(GraphNode x :cur.neighbours){
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

    private void DFS(GraphNode a){

        Stack<GraphNode> s=new Stack<>();

        s.push(a);
        a.visited=true;

        while(!s.isEmpty()){

            GraphNode cur =s.pop();
            System.out.print(cur.data + " ");

            Collections.reverse(cur.neighbours);

            for(GraphNode x :cur.neighbours){

                if(!x.visited){
                    s.push(x);
                    x.visited=true;
                }

            }
        }
    }

    public void DFS(){

        for(GraphNode Node :nodeList){
            if(!Node.visited)
            DFS(Node);
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

public class AdjacencyListDFS {
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

        System.out.println("\nDFS TRAVERSAL :");
        GL.DFS();
        
    }
    
}
