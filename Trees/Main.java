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
  // preOrder
 public void preOrder(TreeNode head) {
   if(head==null) return;
   System.out.print(head.val+" ");
    preOrder(head.left);
    preOrder(head.right);
    System.out.println();
 }
  // postOrder
 public void postOrder(TreeNode head) {
   if(head==null) return;
   System.out.print(head.val +" ");
    postOrder(head.right);
    postOrder(head.left);
      System.out.println();
 }
}

public class Main {
  public static void main(String[] args) {
    Tree t = new Tree();
   Scanner sc = new Scanner(System.in);
   TreeNode root = new TreeNode(23);
   root.left = new TreeNode(45);
   root.right = new TreeNode(78);
   root.left.left = new TreeNode(9);
   root.left.right = new TreeNode(100);
   System.out.println("preOrder");
   t.preOrder(root);
   System.out.println("postOrder");
   t.postOrder(root);

  } 
}
