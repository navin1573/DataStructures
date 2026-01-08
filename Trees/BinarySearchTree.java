import java.util.*;
public class BinarySearchTree{
  // node
  static class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
      this.val=val;
      this.left=null;
      this.right=null;
    }

  }
   // build 
   static Node build(Node root,int val){
      if(root==null)
          return new Node(val);
      if(val>root.val) root.right = build(root.right,val);
      if(val<root.val) root.left = build(root.left,val);
      
    return root;
  }
   // level order 
   static void levelOrder(Node root){
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
      int n = q.size();
      for(int i=0;i<n;i++){
          Node cur = q.poll();
          System.out.print(cur.val+" ");
          if(cur.left!=null) q.add(cur.left);
          if(cur.right!=null) q.add(cur.right);
      }
      System.out.println();
    }
  }
   // find
   static boolean find(Node root,int val){
              if(root==null){
      return false;
    } 
    if(root.val==val) return true;
    if(val<root.val) return find(root.left,val);
    if(val>root.val) return find(root.right,val);
    return false;
  }
  //min
   static int min(Node root){
    if(root==null) return 0;
    
    while(root.left!=null){
      root = root.left;
    }
      return root.val;
  }
  //max
  static int max(Node root){
    if(root==null) return 0 ;
    
    while(root.right!=null){
      root = root.right;
    }
      return root.val;
  }
  //preorder sb
  static void perordersb(Node n,StringBuilder sb){
        if(n==null) return ;
        if (sb.length() > 0) sb.append(",");
            sb.append(n.val);
        perordersb(n.left,sb);
        perordersb(n.right,sb);
    }
  //serializer
  static String Serialization(Node t)
    {
        StringBuilder sb=new StringBuilder();
        perordersb(t,sb);
        return sb.toString();
    }
  //main
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    Node root = null;
    int[] arr = {5,2,1,7,6,11,18};
    for(int i:arr){
     root = build(root,i); 
    }
    System.out.println("Level Order");
    levelOrder(root);
    int fd = 5;
    int fd2 =20;
    System.out.println("is "+fd+" exist: "+find(root,fd));
    System.out.println("is "+fd2+" exist: "+find(root,fd2));
    System.out.println("MIN ELE: "+min(root));
    System.out.println("MAX ELE: "+ max(root));
    System.out.print("SERIALIZATION: "+Serialization(root));
  }

}
