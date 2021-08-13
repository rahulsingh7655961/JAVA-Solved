package String;
import java.io.*;
import java.util.*;

public class EqualFrequencyPartition {
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();
            
            solve ob = new solve();
            int ans = ob.solver(m,S1);
            int ans2 = ob.solver(n,S2);
            System.out.println(ans+" "+ans2);
        }
    }
}
class solve{

    public int solver(int m, String s) {
        char str[] = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        for(char c:str)
            set.add(c);

        for (int i = 1; i < str.length; i++) {
            HashMap<Character,Integer> map1 = new HashMap<>();
            HashMap<Character,Integer> map2 = new HashMap<>();

            for(int j=0;j<i;j++)
                map1.put(str[j], map1.getOrDefault(str[j], 0)+1);
            for(int k=i;k<str.length;k++)
                map2.put(str[k], map2.getOrDefault(str[k], 0)+1);

            Iterator<Character> it = set.iterator();
            int total = 0;
            while(it.hasNext()){
                int first=0,second=0;
                char ch = (char)it.next();
                
                first = map1.getOrDefault(ch,0);
                second = map2.getOrDefault(ch, 0);

                if(first!=0 && first==second)
                    total+=1;
            }
            if(total>=m)
                result+=1;
        }
        return result;
    }
}

