package Graph;
import java.io.*;
import java.util.*;
public class CheckCycleDirectedGraph {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i <= V; i++)
                adj.add(new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            CCDG obj = new CCDG();
            boolean ans = obj.isCycleBFS(V, adj);
            System.out.println(ans);
        }
    }
}
class CCDG{
    boolean isCycle(int v,ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[v+1];
        for(int i=1;i<=v;i++){
            if(!vis[i]){
                if(CheckCycleDFS(i,vis,adj))
                    return true;
            }
        }
        return false;
    }

    private boolean CheckCycleDFS(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        boolean dfsVis[] = new boolean[vis.length];
        vis[node] = true;
        dfsVis[node] = true;
        for(Integer it:adj.get(node)){
            if(CheckCycleDFS(it, vis, adj))
                return true;
            else if(dfsVis[it])
                return true;
        }
        dfsVis[node]=false;
        return false;
    }


    //Kahn's Algorithm
    boolean isCycleBFS(int v,ArrayList<ArrayList<Integer>> adj){

        int inDegree[] = new int[v+1];

        for(int i=1;i<=v;i++){
            for(Integer it:adj.get(i))
                inDegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=v;i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        int count=0;
        while(!q.isEmpty()){
           int node = q.poll();
            count++;

            for(Integer it:adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0)
                    q.add(it);
            }

        }
        if(count==v) return false;
        return true;
    }

    
}
