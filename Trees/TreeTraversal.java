import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Tree{
  int ind=0;
  public TreeNode buildTree(int[] arr){
    if(ind>=arr.length || arr[ind]==-1){
      ind++;
      return null;
    } 
    TreeNode node = new TreeNode(arr[ind++]);
    node.left = buildTree(arr);
    node.right = buildTree(arr);
    return node;
  }
  public void levelOrder(TreeNode root) {
    if (root == null) return;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
    int size = q.size();
        for(int i=0;i<size;i++){
        TreeNode cur = q.poll();
        System.out.print(cur.val + " ");

        if (cur.left != null) q.offer(cur.left);
        if (cur.right != null) q.offer(cur.right);
      }
    }
    System.out.println();
}  
}


public class TreeTraversal{
  public static void main(String[] args) {
    Tree t = new Tree();
   Scanner s = new Scanner(System.in);
   int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }
    TreeNode root = t.buildTree(arr); 
    t.levelOrder(root);
  } 
}
