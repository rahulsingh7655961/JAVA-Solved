package Graph;
import java.io.*;
import java.util.*;
public class CheckCycle {
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
            Solution2 obj = new Solution2();
            boolean ans = obj.isCycleBFS(V, adj);
            System.out.println(ans);
        }
    }  
}
class Solution2{
    boolean isCycleBFS(int v,ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[v+1];

        for(int i=1;i<=v;i++){
            if(!vis[i]){
                if(checkCycleBFs(i,adj,vis))
                    return true;
            }
        }
        return false;
    }

    private boolean checkCycleBFs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<cNode> q = new LinkedList<>();
        q.add(new cNode(i,-1));
        vis[i]=true;
        while(!q.isEmpty()){
            
            int node = q.peek().node;
            int prev = q.peek().prev;
            q.poll();

            for(Integer it:adj.get(i)){
                if(!vis[it]){
                    vis[it]=true;
                    q.add(new cNode(it,node));
                }
                else if(it != prev)
                    return true;
            }
        }
        return false;
    }
}
class cNode{
    int  node;
    int  prev;
    cNode(int node,int prev){
        this.node=node;
        this.prev=prev;
    }
}
