import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class TreePath {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(root,cur,ans);

        System.out.println(ans);
    }

    static void helper(TreeNode root,List<Integer> cur,List<List<Integer>> ans) {
        if(root==null) return;
        cur.add(root.val);

        if(root.left==null && root.right==null){
          ans.add(new ArrayList<>(cur));
        }
        else{
          helper(root.left,cur,ans);
          helper(root.right,cur,ans);
        }
        cur.remove(cur.size()-1);

    }
}
