package Graph;
import java.io.*;
import java.util.*;

public class DFS {
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
            Solution1 obj = new Solution1();
            ArrayList<Integer>ans = obj.dfs(V, adj);
            for (int i=1 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }  
}
class Solution1{
    ArrayList<Integer> dfs(int v,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean vis[] = new boolean[v+1];
        for(int i=0;i<=v;i++){
            if(!vis[i])
                dfs(i,vis,adj,dfs);
        }
        return dfs;
    }
    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {
    
        dfs.add(node);
        vis[node]=true;
        for(Integer it:adj.get(node)){
            if(!vis[it]){
                dfs(it, vis, adj, dfs);
            }
        }
    }

}
