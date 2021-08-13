package Graph;
import java.io.*;
import java.util.*;

public class DijkstrasAlgo {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Node>>adj = new ArrayList<ArrayList<Node>>();
            for(int i = 0; i <= V; i++)
                adj.add(new ArrayList<Node>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                adj.get(u).add(new Node(v,w));
                adj.get(v).add(new Node(u,w));

            }
            Djk obj = new Djk();
            obj.singleSourceShortestPath(1,V,adj);
            
        }
    }
    
}
class Djk{

    public void singleSourceShortestPath(int src, int N, ArrayList<ArrayList<Node>> adj) {
        int dist[] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(N,new Node());
        pq.add(new Node(src,0));

        while(!pq.isEmpty()){
            Node node = pq.poll();

            for(Node it:adj.get(node.getV())){
                if(dist[node.getV()] + it.getW() < dist[it.getV()]){
                    dist[it.getV()] = dist[node.getV()] + it.getW();
                    pq.add(new Node(it.getV(),dist[it.getV()]));
                }
            } 
        }

        for (int i=1; i<=N ;i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

}
class Node implements Comparator<Node>{
    private int v;
    private int w;
    public Node(int v,int w){
        this.v=v;
        this.w=w;
    }
    Node(){}
    int getV(){return v;}
    int getW(){return w;}

    @Override
    public int compare(Node n1,Node n2){
        if (n1.w < n2.w) 
            return -1; 
        if (n1.w > n2.w) 
            return 1; 
        return 0; 

    }
}