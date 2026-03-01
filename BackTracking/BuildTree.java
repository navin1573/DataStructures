import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
public class BuildTree {
 static void levelOrderPrint(TreeNode root) {
    if (root == null) return;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
        int size = q.size();   // number of nodes in this level

        for (int i = 0; i < size; i++) {
            TreeNode cur = q.poll();
            System.out.print(cur.val + " ");

            if (cur.left != null) q.offer(cur.left);
            if (cur.right != null) q.offer(cur.right);
        }

        System.out.println(); // new line after each level
    }
}   static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            // left child
            if (i < arr.length && arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                q.offer(curr.left);
            }
            i++;

            // right child
            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    static boolean canReachLeaf(TreeNode root){
        if(root==null || root.val==0) return false;

        if(root.left==null && root.right==null) return true;
        
        if(canReachLeaf(root.left)) return true;

        if(canReachLeaf(root.right)) return true;

          return false;
    }
    static Stack<Integer> st = new Stack<>();
    static boolean leafPath(TreeNode root){
        if(root==null || root.val==0) return false;
        st.push(root.val);
        
        if(root.left==null && root.right==null) return true;

        if(leafPath(root.left)) return true;

        if(leafPath(root.right)) return true;

        st.pop();

        return false;
    } 
    public static void main(String[] args) {
        Integer[] input ={4,0,1,null,7,0,0}; 
        TreeNode root = buildTree(input);
        System.out.println(canReachLeaf(root));
        leafPath(root);
        System.out.println(st);

    }
}
