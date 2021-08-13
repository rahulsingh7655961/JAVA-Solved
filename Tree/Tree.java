package Tree;

import java.util.ArrayList;
import java.util.Scanner;


public class Tree{
    private static Scanner sc = new Scanner(System.in);
    // public static void main(String[] args) {
    //     node<Integer> root = takenode();
    //     printTree(root);

    // }

    
     node<Integer> takenode(){
        int data = sc.nextInt();
        node<Integer> root = new node<Integer>(data);
        int childCount = sc.nextInt();
        for(int i=0;i<childCount;i++){
             node<Integer> child = takenode();
             root.children.add(child);
        } 
        return root; 
    }

    public  void printTree(node<Integer> root){
        String s = root.data+" : ";
        for(int i=0;i<root.children.size();i++){
            s = s + root.children.get(i).data+" ";
        }  
        System.out.print(s);
        System.out.println();
        for(int i=0;i<root.children.size();i++)
            printTree(root.children.get(i));

    }
}

class node<T> {
    public T data;
    public ArrayList<node<T>> children;
    public node(T data){
        this.data = data;
        children = new ArrayList<>();
    } 
}