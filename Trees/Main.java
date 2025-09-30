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
 public void preOrder(TreeNode head) {
   if(head==null) return;
   System.out.print(head.val+" ");
    preOrder(head.left);
    preOrder(head.right);
    System.out.println();
 }
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
   TreeNode root = new TreeNode(10);
   root.left = new TreeNode(20);
   root.right = new TreeNode(30);
   root.left.left = new TreeNode(40);
   root.left.right = new TreeNode(50);
   System.out.println("preOrder");
   t.preOrder(root);
   System.out.println("postOrder");
   t.postOrder(root);

  } 
}
