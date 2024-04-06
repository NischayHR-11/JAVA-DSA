package Graph.MinimumSpanningTree.KruskalAlgorithm;
import java.util.*;

// Time Complexity : O( Elog(E) );      Space Complexity : O(V+E);

class DisjointSet{

    public ArrayList<WeightedNode> nodeList=new ArrayList<>();

    public static void MakeSet(ArrayList<WeightedNode> nodeList){

        for(WeightedNode node : nodeList){

            DisjointSet set =new DisjointSet();
            set.nodeList.add(node);
            node.set=set;

        }
    }

    public static DisjointSet FindSet(WeightedNode node){

        return node.set;
    }

    public static DisjointSet UnionSet(WeightedNode node1,WeightedNode node2){

        if(node1.set.equals(node2.set)){
            return node1.set;
        }else{

            if(node1.set.nodeList.size()>=node2.set.nodeList.size()){

                for(WeightedNode node :node2.set.nodeList){

                    node.set=node1.set;
                    node1.set.nodeList.add(node);
                }

                return node1.set;

            }else{
                
                for(WeightedNode node :node1.set.nodeList){

                    node.set=node2.set;
                    node2.set.nodeList.add(node);
                }

                return node2.set;

            }
        }
    }

    public void display(){

        System.out.println("SET CONTAINS : ");

        for(WeightedNode node :nodeList){

            System.out.print(node.data+" ");
        }

        System.out.println();
    }

}


class WeightedNode implements Comparable<WeightedNode>{

    public String data;
    public int index;
    public boolean visited;
    public WeightedNode parent;
    public int distance;
    public ArrayList<WeightedNode> neighbours;
    public HashMap<WeightedNode,Integer> weightedEdges;
    public DisjointSet set;

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


class UndirectedEdges implements Comparable<UndirectedEdges>{

    public WeightedNode first;
    public WeightedNode sec;
    public int distance;

    public UndirectedEdges(WeightedNode i,WeightedNode i2,int dis){

    first=i;
    sec=i2;
    distance=dis;

    }

    @Override

    public String toString(){

        return "EDGE ( "+first.data+" , "+sec.data+" ) , DISTANCE : "+distance;
    }

    @Override

    public int compareTo(UndirectedEdges o){

        return this.distance-o.distance;
    }
}


class Kruskal{

    ArrayList<WeightedNode> nodeList ;
    ArrayList<UndirectedEdges> EdgeList;

    Kruskal(ArrayList<WeightedNode> nodeList){

        this.nodeList=nodeList;
        EdgeList=new ArrayList<>();
    }

    void AddUnDirectedEdges(int i,int i2,int dis){

        nodeList.get(i).neighbours.add(nodeList.get(i2));
        nodeList.get(i).weightedEdges.put(nodeList.get(i2), dis);
        nodeList.get(i2).neighbours.add(nodeList.get(i));
        nodeList.get(i2).weightedEdges.put(nodeList.get(i), dis);
        UndirectedEdges edge =new UndirectedEdges(nodeList.get(i), nodeList.get(i2), dis);
        EdgeList.add(edge);
    }

     public void kruskal(){

        int cost=0;

        DisjointSet.MakeSet(nodeList);

        Collections.sort(EdgeList);

        for(UndirectedEdges edge : EdgeList){

            if(!edge.first.set.equals(edge.sec.set)){

                DisjointSet.UnionSet(edge.first, edge.sec);
                System.out.println("SELECTED "+edge);
                cost =cost+edge.distance;
            }
        }

        System.out.println("TOTAL COST : "+cost);

    }
    
}


public class KruskalGraph {

    public static void main(String[] args) {
        
        ArrayList<WeightedNode> nodeList=new ArrayList<>();

        nodeList.add(new WeightedNode("A",0));
        nodeList.add(new WeightedNode("B",1));
        nodeList.add(new WeightedNode("C",2));
        nodeList.add(new WeightedNode("D",3));
        nodeList.add(new WeightedNode("E",4));

        Kruskal graph =new Kruskal(nodeList);
        graph.AddUnDirectedEdges(0, 1, 5);
        graph.AddUnDirectedEdges(0, 2, 13);
        graph.AddUnDirectedEdges(0, 4, 15);
        graph.AddUnDirectedEdges(1, 2, 10);
        graph.AddUnDirectedEdges(1, 3, 8);
        graph.AddUnDirectedEdges(2, 3, 6);
        graph.AddUnDirectedEdges(2, 4, 20);

        System.out.println("KRUSKAL ALGORITHM : ");
        graph.kruskal();

    }
    
}
