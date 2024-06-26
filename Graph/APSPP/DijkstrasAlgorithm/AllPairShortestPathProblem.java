package Graph.APSPP.DijkstrasAlgorithm;
import java.util.*;

// Draw Back : Not Applicable For Negative Weighted Loop Graphs .

// Time Complexity : O(V^2); {Vertices}       Space Complexity : O(V) ; {Vertices}

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
        distance=Integer.MAX_VALUE/10;
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

    public WeightedGraph(ArrayList<WeightedGraphNode> nodeList){

        this.nodeList=nodeList;
    }

    public void AddDirectedEdges(int i,int j, int d){

        nodeList.get(i).neighbours.add(nodeList.get(j));
        nodeList.get(i).wieghtedEdge.put(nodeList.get(j),d);

    }

    public void AddUnDirectedEdges(int i,int j,int d){

        nodeList.get(i).neighbours.add(nodeList.get(j));
        nodeList.get(i).wieghtedEdge.put(nodeList.get(j),d);        
        nodeList.get(j).neighbours.add(nodeList.get(i));
        nodeList.get(j).wieghtedEdge.put(nodeList.get(i),d);        
    }

    private  void path(WeightedGraphNode node){

        if(node.parent !=null){
            path(node.parent);
        }

        System.out.print(node.data +" ");

    }

    public void Dijkstras(WeightedGraphNode node){

        node.distance=0;
        PriorityQueue <WeightedGraphNode> q =new PriorityQueue<>();
        q.addAll(nodeList);

        while(!q.isEmpty()){

            WeightedGraphNode cur=q.remove();
            
            for(WeightedGraphNode neighbour :cur.neighbours){

                if(q.contains(neighbour)){

                    if(neighbour.distance > cur.distance+cur.wieghtedEdge.get(neighbour)){

                        neighbour.distance = cur.distance+cur.wieghtedEdge.get(neighbour);
                        neighbour.visited=true;
                        neighbour.parent=cur;
                        q.remove(neighbour);
                        q.add(neighbour);
                    }
                }
            }
        }

        // Printing Ouput Data.

        for(WeightedGraphNode Node : nodeList){

            System.out.print("Node "+Node.data+ " , Distance : "+Node.distance+" , Path : ");
            path(Node);
            System.out.println();
        }
    }

    public void BellManFord(WeightedGraphNode Source){

        Source.distance=0;

        for(int i=0;i<nodeList.size();i++){

            for(WeightedGraphNode nodes :nodeList){

                for(WeightedGraphNode neighbhour :nodes.neighbours){

                    if(neighbhour.distance>nodes.wieghtedEdge.get(neighbhour)+nodes.distance){

                        neighbhour.distance=nodes.wieghtedEdge.get(neighbhour)+nodes.distance;
                        neighbhour.visited=true;
                        neighbhour.parent=nodes;
                    }

                }
            }
        }

        System.out.println("Checking For Negative Cycle....");

        for(WeightedGraphNode nodes :nodeList){

            for(WeightedGraphNode neighbhour :nodes.neighbours){

                if(neighbhour.distance>nodes.wieghtedEdge.get(neighbhour)+nodes.distance){
                    System.out.println("Negative Cycle Present !!!!");
                    return;
                }

            }
        }

        System.out.println("No Negative Cycle Found.....");

        //Displaying Data

        for(WeightedGraphNode node :nodeList){

            System.out.print("NODE "+node.data+" , "+"DISTANCE : "+node.distance+" , PATH : ");
            path(node);
            System.out.println();
        }

    }
}

public class AllPairShortestPathProblem {
    public static void main(String[] args) {
        
        ArrayList <WeightedGraphNode> nodeList =new ArrayList<>();

        // Should Be Added According to Source; Ex : Source as 'A'.

        nodeList.add(new WeightedGraphNode("A", 0));
        nodeList.add(new WeightedGraphNode("B", 1));
        nodeList.add(new WeightedGraphNode("C", 2));
        nodeList.add(new WeightedGraphNode("D", 3));
        nodeList.add(new WeightedGraphNode("E", 4));
        nodeList.add(new WeightedGraphNode("F", 5));
        nodeList.add(new WeightedGraphNode("G", 6));

        WeightedGraph DA =new WeightedGraph(nodeList);

        DA.AddDirectedEdges(0, 1, 2);
        DA.AddDirectedEdges(0, 2, 5);
        DA.AddDirectedEdges(1, 2, 6);
        DA.AddDirectedEdges(1, 3, 1);
        DA.AddDirectedEdges(1, 4, 3);
        DA.AddDirectedEdges(2, 5, 8);
        DA.AddDirectedEdges(3, 4, 4);
        DA.AddDirectedEdges(4, 6, 9);
        DA.AddDirectedEdges(5, 6, 7);

        for(WeightedGraphNode node :nodeList){

        System.out.println("SSSPP FOR SOURCE AS '"+node.data+"' IS : \n");
        DA.Dijkstras(node);
        for(WeightedGraphNode nodes : nodeList){
            nodes.parent=null;
            nodes.distance=Integer.MAX_VALUE/10;
            nodes.visited=false;
        }
        System.out.println();

        }

    }
    
}
