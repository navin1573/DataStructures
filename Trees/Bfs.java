import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Bfs{
  static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
       this.val= val;
    }
  }

  // MAIN
  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> res = bfsReverse(root);
    System.out.println("BFS REVERSE: " + res);

    List<List<Integer>> res2 = bfs(root);
    System.out.println("BFS : " + res2);
    
    List<List<Integer>> res3 = bfsZig(root);
    System.out.println("BFS ZIG ZAG: " + res3);

    List<Double> res4 = levelAvg(root);
    System.out.println("BFS LEVEL AVG: " + res4);

    int res5 = depth(root);
    System.out.println("BFS DEPTH: " + res5);
    TreeNode res6 = successor(root,5);
    System.out.println("BFS SUCCESSOR: " +(res6!=null?res6.val:"null"));
  }

  // BFS REVERSE
  static List<List<Integer>> bfsReverse(TreeNode root){
   List<List<Integer>> ans = new LinkedList<>();
    if(root==null) return ans;

    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    while(!q.isEmpty()){
      int size = q.size();
      List<Integer> lvl = new ArrayList<>();
      for(int i=0;i<size;i++){
        TreeNode cur = q.poll();
        lvl.add(cur.val);
        if(cur.left!=null) q.offer(cur.left);
        if(cur.right!=null) q.offer(cur.right);
      }
      ans.add(0,lvl);
    }
    return ans;
  }
  // BFS 
  static List<List<Integer>> bfs(TreeNode root){
   List<List<Integer>> ans = new ArrayList<>();
    if(root==null) return ans;

    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    while(!q.isEmpty()){
      int size = q.size();
      List<Integer> lvl = new ArrayList<>();
      for(int i=0;i<size;i++){
        TreeNode cur = q.poll();
        lvl.add(cur.val);
        if(cur.left!=null) q.offer(cur.left);
        if(cur.right!=null) q.offer(cur.right);
      }
      ans.add(lvl);
    }
    return ans;
  }
  // BFS  ZIG ZAG
  static List<List<Integer>> bfsZig(TreeNode root){
   List<List<Integer>> ans = new LinkedList<>();
    if(root==null) return ans;

    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    boolean bbg = true;
    while(!q.isEmpty()){
      int size = q.size();
      List<Integer> lvl = new LinkedList<>();
      for(int i=0;i<size;i++){
        TreeNode cur = q.poll();
        if(bbg)  lvl.add(cur.val);
        else lvl.add(0,cur.val);
        if(cur.left!=null) q.offer(cur.left);
        if(cur.right!=null) q.offer(cur.right);
      }
      ans.add(lvl);
      bbg = !bbg;
    }
    return ans;
  }

  //BFS LEVEL AVG
  static List<Double> levelAvg(TreeNode root){
    List<Double> ans = new ArrayList<>();
    if(root==null) return ans;

    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    while(!q.isEmpty()){
      int size = q.size();
        double  levelSum = 0;
      List<Integer> lvl = new LinkedList<>();
      for(int i=0;i<size;i++){
        TreeNode cur = q.poll();
        levelSum+=cur.val;
        if(cur.left!=null) q.offer(cur.left);
        if(cur.right!=null) q.offer(cur.right);
      }
      ans.add(levelSum/size);
    }
    return ans;
  }
  
  //BFS  DEPTH
  static int  depth(TreeNode root){
    if(root==null) return -1;

    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    int level = 0;
    while(!q.isEmpty()){
      level++;
      int size = q.size();
      for(int i=0;i<size;i++){
        TreeNode cur = q.poll();
        if(cur.left==null && cur.right==null) return level;
        if(cur.left!=null) q.offer(cur.left);
        if(cur.right!=null) q.offer(cur.right);
      }
    }
    return level;
  }
  // SUCCESSOR
  static TreeNode successor(TreeNode root,int key){

    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    while(!q.isEmpty()){
      int size = q.size();
      for(int i=0;i<size;i++){
        TreeNode cur = q.poll();
        if(cur.left!=null) q.offer(cur.left);
        if(cur.right!=null) q.offer(cur.right);
        if(cur.val==key) return q.peek();
      }
    }
    return null; 
  }
}
