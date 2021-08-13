package Graph;
import java.io.*;
import java.util.*;
public class Bipartite {
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
            Solution4 obj = new Solution4();
            boolean res = obj.isBipartite(V,adj);
            System.out.println(res);
    
        }
    }
}
class Solution4{
    boolean isBipartite(int v,ArrayList<ArrayList<Integer>> adj){
        int color[] = new int[v+1];
        Arrays.fill(color,-1);
        for(int i=1;i<=v;i++){
            if(color[i] == -1){
                // if(!checkBipartiteBFS(v,color,adj))
                //     return false;
                if(!checkBipartiteDFS(v, color, adj))
                    return false;
            }

        }
        return true;
    }

    // private boolean checkBipartiteBFS(int v, int[] color, ArrayList<ArrayList<Integer>> adj) {
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(v);
    //     color[v]=1;
    //     while(!q.isEmpty()){
    //         int node = q.poll();

    //         for(Integer it:adj.get(node)){
    //             if(color[it] == -1){
    //                 color[it] = 1 - color[node];
    //                 q.add(it);
    //             }
    //             else if(color[it]==color[node])
    //                 return false;
    //         }
    //     }       
    //     return true;
    // }


    private boolean checkBipartiteDFS(int v, int[] color, ArrayList<ArrayList<Integer>> adj){
        if(color[v] == -1)
            color[v]=1;
        for(Integer it:adj.get(v)){
            if(color[it]==-1){
                color[it] = 1 - color[v];
                if(!checkBipartiteDFS(it, color, adj))
                    return false;
            }
            else if(color[it]==color[v])
                return false;
        }
        return true;
    }
}
