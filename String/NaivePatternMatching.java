package String;
import java.util.*;;
public class NaivePatternMatching {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String text = "aabaacaadaabaaba";
		String pattern = sc.next();
		
		match(text,pattern);
		sc.close();
	}
	private static void  match(String a,String b){

		for(int i=0;i<=a.length()-b.length();i++){
			int j=0;
			for (j=0;j<b.length() ;j++ ) {

				if(b.charAt(j) != a.charAt(i+j))
					break;
			}
			if(j==b.length())
				System.out.println(i);

		}
			
	}
}

