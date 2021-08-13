package Tree;

public class NoOfNodesTree {
    
    public static int numNodes(node<Integer> root){
        
        if(root==null)//edge case not base
            return 0;
        int count = 1;
        for(int i=0;i<root.children.size();i++){
            count += numNodes( root.children.get(i));
        }
        return count;
    }
    public  static int  maxNode(node<Integer> root) {
        if(root==null)
            return Integer.MIN_VALUE;
        int max = root.data;
        for(int i=0;i<root.children.size();i++){
            int largestChild = maxNode(root.children.get(i));
            max = Math.max(max, largestChild);
        }
        return max;
        
    }
    private static int heightNode(node<Integer> root) {
        if(root==null)
        return 0;

        int Height=1;
        int max=1;
        for(int i=0;i<root.children.size();i++){
            int childHeight = heightNode(root.children.get(i));
            Height = childHeight+1;
            max = Math.max(max,Height); 
        }
        return max;
    }
    

    public static void main(String[] args) {
        TreeBFS tree = new TreeBFS(); 
        node<Integer> root= tree.takeInputLevelWise();
        tree.print(root);
        System.out.println();
        System.out.println("Total no of nodes are-");
        System.out.println(numNodes(root));
        System.out.println("Largest node is-");
        System.out.println(maxNode(root));
        System.out.println("Height of tree is-");
        System.out.println(heightNode(root));
        
    }
   
}
