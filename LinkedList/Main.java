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
   Node tail;
   public void insert(int data) {
     Node nn = new Node(data);
     if(head==null){
       head=nn;
       tail=nn;
     }
     tail.next = nn;
     tail = nn;
   }
  // display
   public void display() {
     Node ptr = head;
    while(ptr!=null){
      System.out.print("["+ ptr.data + "]->");
      ptr = ptr.next;
    }
    System.out.println("null");
    System.out.println("\n");
   }
   // reverse
   public void reverse() {
    Node prev = null;
    Node temp = head;
    while(temp!=null ){
      Node nex = temp.next;
      temp.next = prev;
      prev = temp;
      temp = nex;
    }
    System.out.println("After reversing \n");
    Node newHead = prev;
    while(newHead!=null){
      System.out.print("["+ newHead.data + "]->");
      newHead = newHead.next;
    }
    System.out.println("null");
    System.out.println("\n");
    }
   }
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
   LinkedList ls = new LinkedList();  
   while(true){
     int val = sc.nextInt();
     if(val==-1){
       break;
      }
     ls.insert(val);;
   }
   System.out.println("before reversing \n");
   ls.display();
   ls.reverse();

  }
}
