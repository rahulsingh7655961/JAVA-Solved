import java.util.*;

class evenodd
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String n1 = sc.next();
                    String n2 = sc.next();
                    Sol obj = new Sol();
                    System.out.println(obj.EvenOdd(n1,n2));
                }
              sc.close();  
        }

    }
class Sol
{
    int EvenOdd(String a, String b)
        {
            String[] n1 = a.split(" ");
            String[] n2 = b.split(" ");
            if((Integer.parseInt(n1[n1.length-1]))*(Integer.parseInt(n2[n2.length-1]))%2==0)
             return 1;
            else return 0;
        }
}