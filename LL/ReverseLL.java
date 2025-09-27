import java.util.*;
class Node{
  int data;
  Node next;
  Node(){
   this.data = 0;
   this.next = null;
  }
  Node(int data){
   this.data = data;
   this.next = null;
  }
  }
  class LinkedList {
   Node head;
   public void insert(int data) {
    Node nn = new Node(data);
    nn.next=head;
    head=nn; 
   }
   public void display() {
     Node ptr = head;
    while(ptr!=null){
      System.out.print("["+ ptr.data + "]->");
      ptr = ptr.next;
    }
      System.out.print("null");
   }

  
}
public class ReverseLL {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter number ");
   LinkedList ls = new LinkedList();  
   while(true){
     int val = sc.nextInt();
     if(val==-1){
       break;
     }
     ls.insert(val);;
   }
   ls.display();
  }
}
