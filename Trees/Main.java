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
  public boolean inOrder(TreeNode root,int target){
    if(root==null) return false;
    inOrder(root.left,target);
    if(root.val==target) return true;
    inOrder(root.right,target);
    return false;
  }
}

public class Main {
  public static void main(String[] args) {
    Tree t = new Tree();
   Scanner sc = new Scanner(System.in);
   TreeNode n1 = new TreeNode(10);
   n1.left = new TreeNode(20); 
   n1.right = new TreeNode(30); 
   n1.left.left = new TreeNode(40); 
   n1.left.right= new TreeNode(50); 
   n1.right.left= new TreeNode(60); 
   n1.right.right= new TreeNode(70);
   n1.left.right.right = new TreeNode(80);
   n1.right.left.left = new TreeNode(90);
    int target = sc.nextInt();
    System.out.println(t.inOrder(n1,target));
  } 
}
