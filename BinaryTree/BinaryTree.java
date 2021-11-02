package BinaryTree;
class BinaryTree{
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.left.right.left = new Node(6); 
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }
    static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+"  ");
        inorder(root.right);
    }

    static void preorder(Node root){
        if(root == null)
            return;

        System.out.print(root.data+"  ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root){
        if(root == null)
            return;
        
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+"  ");
    }

}

class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}