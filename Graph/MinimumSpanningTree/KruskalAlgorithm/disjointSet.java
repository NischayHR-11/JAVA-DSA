package Graph.MinimumSpanningTree.KruskalAlgorithm;

import java.util.*;

// Time : O (4 alpha). --> constant .

public class disjointSet {


    class disjoint{

        int rank[];
        int size[];
        int parent[];

        disjoint(int n){

            rank=new int[n];
            size=new int[n];
            parent=new int[n];

            Arrays.fill(rank,0);
            Arrays.fill(size,1);
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        int find(int x){

            if(parent[x]==x){
                return x;
            }

            int n=find(parent[x]);
            parent[x]=n;

            return n;
        }

        void UnionByRank(int x ,int y){

            int u=find(x);
            int v=find(y);

            if(u==v)
            return;

            if(rank[u]>rank[v]){

                parent[v]=u;

            }else if (rank[v]>rank[u]){

                parent[u]=v;
            }else{

                parent[v]=u;
                rank[u]++;
            }
        }

        void UnionBySize(int x ,int y){

            int u=find(x);
            int v=find(y);

            if(u==v)
            return;

            if(size[u]>size[v]){

                parent[v]=u;
                size[u]=size[u]+size[v];

            }else{

                parent[u]=v;
                size[u]=size[u]+size[v];

            }
        }
    }

    public static void main(String[] args) {
        

    }
    
}
