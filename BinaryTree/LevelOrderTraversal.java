package BinaryTree;

import java.util.*;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root){

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null)
            return ans;
        
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> sublist = new ArrayList<>();
            int size = queue.size();
            while(size-- > 0){
                TreeNode top = queue.peek();
                if(top.left!=null){
                    queue.add(top.left);
                }
                if(top.right!=null){
                    queue.add(top.right);
                }
                sublist.add(queue.poll().val);
            }
            ans.add(sublist);
            //If we need level order from leaf node then we can simply add the list at first position so that last will be first and vice versa.
        }
        return ans;
    }
}

class TreeNode{
    int val;
    TreeNode left , right;

    TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
}