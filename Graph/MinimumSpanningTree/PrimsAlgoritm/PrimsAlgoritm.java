package Graph.MinimumSpanningTree.PrimsAlgoritm;
import java.util.*;

class WeightedNode implements Comparable<WeightedNode>{

    String data;
    int index;
    boolean visited;
    WeightedNode parent;
    int distance;
    ArrayList<WeightedNode> neighbours;
    HashMap<WeightedNode,Integer> weightedEdges;

    WeightedNode(String data,int index){

    this.data=data;
    this.index=index;
    visited=false;
    distance=Integer.MAX_VALUE/10;
    neighbours=new ArrayList<>();
    weightedEdges=new HashMap<>();

    }

    @Override

    public int compareTo(WeightedNode o){

        return this.distance-o.distance;
    }

    @Override

    public String toString(){

        return data;
    }
}

class prims{

    ArrayList<WeightedNode> nodeList;

    prims(ArrayList<WeightedNode> nodeList){

        this.nodeList=nodeList;
    }

    // public void AddUnDirectedEdges(int i,int i2,int dis){

    //     nodeList.get(i).neighbours.add(nodeList.get(i2));
    //     nodeList.get(i).WeightedEdges.put(nodeList.get(i2), dis);
    //     nodeList.get(i2).neighbours.add(nodeList.get(i));
    //     nodeList.get(i2).WeightedEdges.put(nodeList.get(i), dis);
    // }

    
    void AddUnDirectedEdges(int i,int i2,int dis){

        nodeList.get(i).neighbours.add(nodeList.get(i2));
        nodeList.get(i).weightedEdges.put(nodeList.get(i2), dis);
        nodeList.get(i2).neighbours.add(nodeList.get(i));
        nodeList.get(i2).weightedEdges.put(nodeList.get(i), dis);
    }

    public void Prims(WeightedNode Source){

        for(WeightedNode node : nodeList){
            node.distance=Integer.MAX_VALUE/10;
        }

        Source.distance=0;
        PriorityQueue<WeightedNode> q=new PriorityQueue<>();
        q.addAll(nodeList);

        while(!q.isEmpty()){

            WeightedNode cur =q.remove();

            for(WeightedNode node :cur.neighbours){

                if(q.contains(node)){

                    if(node.distance>cur.weightedEdges.get(node)){

                        node.distance=cur.weightedEdges.get(node);
                        node.parent=cur;
                        q.remove(node);
                        q.add(node);                       
                    }
                }
            }
        }

        int cost =0;

        for(WeightedNode node : nodeList){

            System.out.println("NODE : "+node.data+" , DISTANCE : "+node.distance+" , PARENT : "+node.parent);
            cost=cost+node.distance;
        }

        System.out.println("TOTAL COST : "+ cost);
    }
}

public class PrimsAlgoritm {
    
    public static void main(String[] args) {
        
        ArrayList<WeightedNode> nodeList=new ArrayList<>();

        nodeList.add(new WeightedNode("A",0));
        nodeList.add(new WeightedNode("B",1));
        nodeList.add(new WeightedNode("C",2));
        nodeList.add(new WeightedNode("D",3));
        nodeList.add(new WeightedNode("E",4));

        prims graph =new prims(nodeList);
        graph.AddUnDirectedEdges(0, 1, 5);
        graph.AddUnDirectedEdges(0, 2, 13);
        graph.AddUnDirectedEdges(0, 4, 15);
        graph.AddUnDirectedEdges(1, 2, 10);
        graph.AddUnDirectedEdges(1, 3, 8);
        graph.AddUnDirectedEdges(2, 3, 6);
        graph.AddUnDirectedEdges(2, 4, 20);

        System.out.println("PRIMS ALGORITHM : ");
        graph.Prims(nodeList.get(4));
    }
}