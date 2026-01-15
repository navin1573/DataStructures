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
   static Node find(Node root,int val){
              if(root==null){
      return null;
    } 
    else if(root.val==val) return root;
    else if(val<root.val) return find(root.left,val);
    else return find(root.right,val);
  }
   // contains
   static boolean contains(Node root,int val){
              if(root==null){
      return false;
    } 
    if(root.val==val) return true;
    if(val<root.val) return contains(root.left,val);
    if(val>root.val) return contains(root.right,val);
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
    static int idx=0;
    public static Node debuild(String[] arr,long min,long max)
    {
        if(idx==arr.length) return null;
        int val=Integer.parseInt(arr[idx]);
        if(val<=min || val>=max) return null;
        idx++;
        Node n=new Node(val);
        n.left=debuild(arr,min,n.val);
        n.right=debuild(arr,n.val,max);
        return n;
        
    }
    //deserial
    static Node deSerial(String data)
    {
        if(data.isEmpty()) return null;
        String[] arr=data.split(",");
        return debuild(arr,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    //delete node
    static TreeNode deleteNode(TreeNode node, int val) {
        if (node == null) return null;
        if (val < node.val) node.left = deleteNode(node.left, val);
        else if (val > node.val) node.right = deleteNode(node.right, val);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            int minVal = getMinVal(node.right); // Use getMinVal (returns int)
            node.val = minVal;
            node.right = deleteNode(node.right, minVal);
        }
        return node;
    }
    //lowestCommonAncester
    public static Node lowestCommonAncester(Node node,Node p,Node q)
	{
	    if(node==null || p==null || q==null)
	    {
	        return null;
	    }
	    if(p.val<node.val && q.val<node.val)
	    {
	        return lowestCommonAncester(node.left,p,q);
	    }
      else if(p.val>node.val && q.val>node.val)
	    {
	        return lowestCommonAncester(node.right,p,q);
	    }
	    else{
	        return node;
	    }
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
    System.out.println("is "+fd+" exist: "+contains(root,fd));
    System.out.println("is "+fd2+" exist: "+contains(root,fd2));
    System.out.println("MIN ELE: "+min(root));
    System.out.println("MAX ELE: "+ max(root));
    String seri = Serialization(root);
    System.out.println("SERIALIZATION: "+ seri);
    Node n1 = deSerial(seri);
    System.out.println("DE`SERIALIZATION");
    levelOrder(n1);
    Node p = find(root,1);
    Node q = find(root,18);
    Node lca= lowestCommonAncester(root,p,q);
    System.out.println("LOWEST COMMON ANCESER: "+ lca.val);
  }

}
