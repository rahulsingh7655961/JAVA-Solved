package Graph;
import java.io.*;
import java.util.*;

public class TopologicalSorting {
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i <V; i++)//zero based indexing
                adj.add(new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            tpstDFS obj = new tpstDFS();
            ArrayList<Integer>ans = obj.topoSort(V, adj);
            tpstBFS obj1 = new tpstBFS();
            ArrayList<Integer>ans1 = obj1.topoSort(V, adj);

            
            for (int i=0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();

            for (int i=0 ;i < ans1.size (); i++) 
                System.out.print (ans1.get (i) + " ");
            System.out.println();
        }
    }  
    
}
class tpstDFS{

    public ArrayList<Integer> topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[v];
        ArrayList<Integer> topo = new ArrayList<>(v);
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(!vis[i]){
                DFS(i,vis,stack,adj);
            }
        }
        int id=0;
        while(!stack.isEmpty()){
            
            topo.add(id,stack.pop());
            id++;

        }
        return topo;
    }

    private void DFS(int node, boolean[] vis, Deque<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for(Integer it:adj.get(node)){
            if(!vis[it]){
                DFS(it, vis, stack, adj);
            }
        }
        stack.push(node);
    }
    
}

class tpstBFS{
    //kahn's Algorithm
    public ArrayList<Integer> topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> topo = new ArrayList<>();
        int inDegree[] = new int[v];
        for(int i=0;i<v;i++){
            for(Integer it:adj.get(i)){
                inDegree[it]++; 
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        int id=0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(id , node);
            id++;

            for(Integer it:adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0){
                    q.add(it);
                }
            }
        }

        return topo;
    }

}