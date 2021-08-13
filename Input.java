/*
import java.io.*;
import java.util.*;
public class Input{
	static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);


	int[] inputArraySS() throws IOException{

			int n = Integer.parseInt(read.readLine());
			int arr[]= new int[n];
            String input[] = read.readLine().trim().split(" ");
			for(int i=0;i<n;i++){
				arr[i]=Integer.parseInt(input[i]);
			}
			return arr;    
    }
	int[] inputArrayLS() throws IOException{

			int n = Integer.parseInt(read.readLine());
			int arr[]= new int[n];
			for(int i=0;i<n;i++){
				arr[i]=Integer.parseInt(read.readLine().trim());
			}
			return arr;
    }
	String inputString() throws IOException{

            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            
            String s = read.readLine().trim();  
			return s;  
    }
    String[] inputTwoString() throws IOException{

            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String s1 = read.readLine().trim();
            String s2 = read.readLine().trim();

			String str[] = {s1,s2};
			return str;
            
    }
    int fib(int n) {

	    int f[] = new int[n+1] ;
	    if(n<2)
        	return n;

	    f[0]=0;
	    f[1]=1;
	        for(int i=2;i<n+1;i++){
	            f[i]=f[i-1]+f[i-2];
	        } 
	    return f[n];
	 }

	static int max_size=1000005;
	int prime(int n){
		
	 	boolean[] isPrime = new boolean[max_size+1];
	 	Arrays.fill(isPrime,true);
	 	ArrayList<Integer> primes = new ArrayList<>();

	 	isPrime[0]=false;
	 	isPrime[1]=false;

	 	for(int i=2;i*i<=max_size;i++){
	 		for(int j =2*i;j<=max_size;j+=i){
	 			isPrime[j]=false;
	 		}
	 	}
	 	for(int i=2;i<=max_size;i++){
	 		if(isPrime[i])
	 			primes.add(i);
	 	}
	 	return primes.get(n-1);

	 }
}

*/