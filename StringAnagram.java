import java.util.Scanner;
class StringAnagram{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        sc.close();
        boolean isAnagram = false;
        boolean visited[] = new boolean[s1.length()];

        if(s1.length() == s2.length())
        {
            for(int i=0;i<s1.length();i++)
            {  
                 char c = s1.charAt(i);
                isAnagram = false;
                for(int j=0;j<s2.length();j++)
                {
                    if(s2.charAt(j)==c && !visited[j]){
                        isAnagram = true;
                        visited[j]=true;
                        break;
                    }
                }
                if(!isAnagram){
                    break;
                }
            }
        }
        if(isAnagram)
        {
            System.out.println("Anagram");
        }
        else
            System.out.println("Not Anagram");
    
        
    }
}