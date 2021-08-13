package Graph;
import java.io.*;
import java.util.*;
public class ShortestDistanceUG {
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
                adj.get(v).add(u);
            }
            SDUG obj = new SDUG();
            int[] ans = obj.bfsModifiedShortestDistance(V, adj,0);
            for (int i =0 ;i < ans.length; i++)     
                System.out.print (ans[i] + " ");
            System.out.println();
        }

    }
}
class SDUG{

    public int[] bfsModifiedShortestDistance(int v, ArrayList<ArrayList<Integer>> adj,int src) {
        
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        dist[src] = 0;
        q.add(src);

        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer it:adj.get(node)){
                if(dist[node]+1 < dist[it])
                {
                    dist[it] = dist[node]+1;
                    q.add(it);
                }
            }
        }
        return dist;
    }

}
