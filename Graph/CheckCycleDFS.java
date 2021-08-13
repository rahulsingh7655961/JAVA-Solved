package Graph;
import java.io.*;
import java.util.*;
public class CheckCycleDFS {
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
            for(int i = 0; i <= V; i++)
                adj.add(new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution3 obj = new Solution3();
            boolean ans = obj.isCycle(V, adj);
            System.out.println(ans);
        }
    }
}
class Solution3{

    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[v+1];
        Arrays.fill(vis,false);
        for(int i=1;i<=v;i++){
            if(!vis[i]){
                if(checkCycleDFS(i,-1,adj,vis))
                    return true;
            }
        }
        return false;
    }
    private boolean checkCycleDFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        
        vis[node]=true;
        for(Integer it:adj.get(node)){
            if(!vis[node]){
                checkCycleDFS(it, node, adj, vis);
            }
            else if(it != node)
                return true;
        }
        return false;
    }

}
