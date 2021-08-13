package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph {
    
    public static void main(String[] args) throws IOException{
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-- >0){

            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<=V;i++)
                adj.add(new ArrayList<Integer>());
            for(int i=0;i<E;i++){
                String[] S = br.readLine().trim().split(" ");
                Integer u = Integer.parseInt(S[0]);
                Integer v = Integer.parseInt(S[1]);

                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            for(int i=1;i<adj.size();++i){
                System.out.print("vertex "+i);
                for(int j=0;j<adj.get(i).size();j++){
                    System.out.print( "- > "+adj.get(i).get(j)+" ");
                }
                System.out.println();
            }
          
        }
        
    }
    
}
