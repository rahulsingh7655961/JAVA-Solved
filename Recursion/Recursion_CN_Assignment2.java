package Recursion;

public class Recursion_CN_Assignment2 {
    
    static int countSteps=0;
    static String replacePI(String s){
        if(s.length()<=1) return s;

        if(s.charAt(0)=='p' &&  s.length()>=2 && s.charAt(1)=='i' )
            return "3.14" + replacePI(s.substring(2));

        return s.charAt(0)+replacePI(s.substring(1));
    }
    static String removeX(String s,char x){
        countSteps++;
        if(s.length()==0) return s;

        if(s.charAt(0)==x)  return removeX(s.substring(1), x);

        return s.charAt(0)+removeX(s.substring(1), x);
    }
    static String removeX(String s){
        countSteps++;
        if(s.length()==0) return s;
        String ans ="";
        if(s.charAt(0)!='x')  
            ans += s.charAt(0);

        return ans + removeX(s.substring(1));
    }
    static int stringToInteger(String s){
        if(s.length()==1) return s.charAt(0)-'0';//'0'=48
        
        return  (s.charAt(0)-'0') * 
                (int)Math.pow(10,s.length()-1) + 
                stringToInteger(s.substring(1));
    }
    static String pairStar(String s){
        if(s.length()<2) return s;

        if(s.charAt(0)==s.charAt(1) && s.length()>=2)
            return s.charAt(0)+"*"+pairStar(s.substring(1));
    
        return s.charAt(0)+pairStar(s.substring(1));
    }
    static String pairStar(String s,int i){
        if(i==s.length()-1) return s.charAt(i)+"";

        if(s.charAt(i)==s.charAt(i+1)&&s.length()>=2)
            return s.charAt(i)+"*"+pairStar(s,i+1);
        return s.charAt(i)+pairStar(s,i+1);
    }
        public static void main(String[] args) {
       //System.out.println(replacePI("ippiipipipipipipiiiippppiiipipiipippppiiii"));
        //System.out.println(removeX("hbfvevujxxhggtyfxytfvxguiyhdiughwduixxuuiefbgevxxxyigdfhuixx", 'x'));
        //System.out.println(countSteps);

        //System.out.println(stringToInteger("76576"));
        System.out.println(pairStar("abbaadccegjkll"));
        System.out.println(pairStar("abbaadccegjkll",0));
        
        System.out.println(removeX("hbfvevujxxhggtyfxytfvxguiyhdiughwduixxuuiefbgevxxxyigdfhuixx"));

    }
}
