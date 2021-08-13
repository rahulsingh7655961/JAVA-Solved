package Stack;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

 class Result{

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
    
    int count=0,total=0,i=0,j=0;
    while(i<a.size() && total + a.get(i)<= maxSum){
        total += a.get(i);
        i++;
        count++;
    }
    while(j<b.size() && i>=0){
        total += b.get(j);
        j++;
        while(i>0 && total>maxSum){
            i--;
            total -=a.get(i);
        }
        if(total <= maxSum && count < i+j) count =i+j;
     }
     return count;
    }
}


public class GameOfTwoStack  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(br.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                String[] input = br.readLine().replaceAll("\\s+$", "").split(" ");

                Integer.parseInt(input[0]);

                Integer.parseInt(input[1]);

                int maxSum = Integer.parseInt(input[2]);

                List<Integer> a = Stream.of(br.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> b = Stream.of(br.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                int result = Result.twoStacks(maxSum, a, b);

                bw.write(String.valueOf(result));
                bw.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        br.close();
        bw.close();
    }
}


