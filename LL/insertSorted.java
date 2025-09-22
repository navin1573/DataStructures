import java.util.*;

class Node {
  int data;
  Node next;

  Node(int data){
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  Node head;

public void insert(int data) {
  Node nn = new Node(data);
  Node cur = head;
  if(head==null || nn.data < cur.data){
    nn.next = head;
    head = nn;
  }
  else{
    Node temp = head;
    while(temp.next !=null && temp.next.data<nn.data){
      temp = temp.next;
    }
    nn.next = temp.next;
    temp.next = nn;
  }
}

public void print(){
  Node temp = head;
  while(temp!=null){
    System.out.print(temp.data + " ");
    temp = temp.next;
  }
}

}
public class insertSorted {
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
    LinkedList ls = new LinkedList();
    while(true){
      int val = sc.nextInt();
      if(val == -1) break;
      ls.insert(val);
    }
    ls.print();
 }  
}
