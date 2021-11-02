package BinaryTree;
import java.util.*;

public class IterativeTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        if(root==null){
            return ans;
        }
        
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            if(top.right!=null)
                stack.push(top.right);
            if(top.left!=null)
                stack.push(top.left);
            ans.add(top.val);
        }
        return ans;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> s1 = new LinkedList<>();
        Deque<TreeNode> s2 = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        if(root==null)
            return ans;
        
        s1.push(root);
        
        while(!s1.isEmpty()){
            TreeNode top = s1.pop();
            s2.push(top);
            
            if(top.left!=null)
                s1.push(top.left);
            
            if(top.right!=null)
                s1.push(top.right);
        }
        while(!s2.isEmpty()){
            ans.add(s2.pop().val);
        }
        return ans;
    }
}
