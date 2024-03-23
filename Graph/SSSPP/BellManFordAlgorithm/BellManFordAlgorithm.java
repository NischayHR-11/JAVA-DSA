package Graph.SSSPP.BellManFordAlgorithm;
import java.util.*;

// Time Complexity : O(VE);           Space Complexity : O(V);

// Negative Cycle Can Be Checked.

class WeightedGraphNode{

    public String data;
    public int index;
    public WeightedGraphNode parent;
    public Boolean visited;
    public int distance;
    public ArrayList<WeightedGraphNode>neighbours;
    public HashMap<WeightedGraphNode,Integer>WeightedEdges;

    public WeightedGraphNode(String data,int i){

        this.data=data;
        index=i;
        distance=Integer.MAX_VALUE;
        visited=false;
        neighbours=new ArrayList<>();
        WeightedEdges=new HashMap<>();

    }
}

class WeightedGraph{

    private ArrayList<WeightedGraphNode> nodeList;

    public WeightedGraph(ArrayList<WeightedGraphNode> nodeList){

        this.nodeList=nodeList;

    }

    public void AddDirectedEdges(int i,int j,int d){

        nodeList.get(i).neighbours.add(nodeList.get(j));
        nodeList.get(i).WeightedEdges.put(nodeList.get(j), d);
    }

    private void path(WeightedGraphNode node){

        if(node.parent!=null){
            path(node.parent);
        }

        System.out.print(node.data+" ");
    }

    public void BellManFord(WeightedGraphNode Source){

        Source.distance=0;

        for(int i=0;i<nodeList.size();i++){

            for(WeightedGraphNode nodes :nodeList){

                for(WeightedGraphNode neighbhour :nodes.neighbours){

                    if(neighbhour.distance>nodes.WeightedEdges.get(neighbhour)+nodes.distance){

                        neighbhour.distance=nodes.WeightedEdges.get(neighbhour)+nodes.distance;
                        neighbhour.visited=true;
                        neighbhour.parent=nodes;
                    }

                }
            }
        }

        System.out.println("Checking For Negative Cycle....");

        for(WeightedGraphNode nodes :nodeList){

            for(WeightedGraphNode neighbhour :nodes.neighbours){

                if(neighbhour.distance>nodes.WeightedEdges.get(neighbhour)+nodes.distance){
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

    public void display(){

        for(WeightedGraphNode x :nodeList){

            System.out.print(x.data+" : ");

            for(WeightedGraphNode y :x.neighbours){

                System.out.print(y.data+" ");
            }
            System.out.println();
        }
    }
}

public class BellManFordAlgorithm {
    
    public static void main(String[] args) {

        ArrayList <WeightedGraphNode> nodeList =new ArrayList<>();

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

        System.out.println("SSSPP FOR SOURCE AS 'A' IS : \n");
        DA.BellManFord(nodeList.get(0));
        
    }
}
