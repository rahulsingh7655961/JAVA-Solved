package Graph;
import java.io.*;
import java.util.*;

public class ShortestDistanceDAG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<pair>>adj = new ArrayList<ArrayList<pair>>();
            for(int i = 0; i < V; i++)
                adj.add(new ArrayList<pair>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                adj.get(u).add(new pair(v,w));
            }
            SDDAG obj = new SDDAG();
            obj.shortestDistance(0,V,adj);
            
        }
    }
    
}
class SDDAG{

     void shortestDistance(int src, int v, ArrayList<ArrayList<pair>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new boolean[v];
        int[] dist = new int[v];

        for (int i = 0; i < v; i++)
            vis[i] = false;
        
        for(int i=0;i<v;i++){
            if(!vis[i])
                topoSort(i,vis,stack,adj);
        }
        for (int i = 0; i < v; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[src]=0;

        while(!stack.isEmpty()){
           
            int node = (int)stack.pop();
           
            if(dist[node] != Integer.MAX_VALUE){
                
                for(pair it:adj.get(node)){
                    if(dist[node]+it.getWeight() < dist[it.getVertex()])
                        dist[it.getVertex()] = dist[node] + it.getWeight();    
                    }
            }
        }
        for (int i = 0; i < v; i++)
        {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( dist[i] + " ");
        }
        System.out.println();
    }

    private void topoSort(int node, boolean[] vis, Stack<Integer> stack, ArrayList<ArrayList<pair>> adj) {
        vis[node] = true;
        for(pair it:adj.get(node)){
            if(!vis[it.getVertex()])
            {
                topoSort(it.getVertex(), vis, stack, adj);
            }
        }
        stack.add(node);
    }
    
}
class pair{
    private int vertex;
    private int weight;
    pair(int v,int w){
        this.vertex = v;
        this.weight = w;
    }
    int getVertex(){
         return vertex;
    }
    int getWeight(){
        return weight;
    }
}