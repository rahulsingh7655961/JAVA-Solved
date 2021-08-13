package Graph;
import java.io.*;
import java.util.*;
public class BFS {   
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
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.bfs(V, adj);
            for (int i =1 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }  
}
class Solution{
    ArrayList<Integer> bfs(int v,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[v+1];
        for(int i=0;i<=v;i++){
            if(!vis[i]){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i]=true;
                while(!q.isEmpty()){
                    int node = q.poll();
                    bfs.add(node);
                    for(int it : adj.get(node)){
                        if(!vis[it]){
                            q.add(it);
                            vis[it]=true;
                        }
                    }
                }
            }
        }
        return bfs;
    }

}
