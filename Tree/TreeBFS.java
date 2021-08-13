package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeBFS {
    // public static void main(String[] args) {
    //     node<Integer> root = takeInputLevelWise();
    //     print(root);
        
    // }
    public  node<Integer> takeInputLevelWise(){
        System.out.println("Enter Root data :-");
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();
        Queue<node<Integer>> queue = new LinkedList<>();
        node<Integer> root = new node<>(rootData),child=null;
        queue.add(root);
        while(!queue.isEmpty()){
            node<Integer> front = queue.poll();
            System.out.println("No of Children of "+front.data+":-");
            int childCount = sc.nextInt();
            for (int i = 0; i < childCount; i++) {
                System.out.println("Child "+(i+1)+" of "+front.data+" :-");
                int childData = sc.nextInt();
                child = new node<>(childData);
                front.children.add(child);
                queue.add(child);
            }
        }
        sc.close();
        return root;
    }
    public  void print(node<Integer> root){
        System.out.println("Root:-"+root.data);
        Queue<node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            node<Integer> temp = queue.poll();
            String str = "";
            for (int i = 0; i < temp.children.size(); i++) {
                str += temp.children.get(i).data +" ";
                queue.add(temp.children.get(i)); 
            }
            System.out.println(str);
            System.out.println();
        }
    }
}
