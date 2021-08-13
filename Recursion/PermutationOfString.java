package Recursion;

import java.util.HashSet;
import java.util.Set;

public class PermutationOfString {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        permutations("abcd",0,3);
    }
    static void permutations(String s,int l,int r){
        if(l==r){
            if(set.contains(s)) return;
            set.add(s);
            System.out.print(s+" ");
            return;
        }
        for(int i=l;i<=r;i++){
            s = interchageChar(s,l,i);
            permutations(s,l+1,r);
            s = interchageChar(s, l, i);
        }
           
    }
    private static String interchageChar(String s, int a, int b) {
        char[] arr = s.toCharArray();
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return new String(arr);
    }

}
