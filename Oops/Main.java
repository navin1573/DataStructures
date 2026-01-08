import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
class Cat{
  int a;
  Cat(int a){
    this.a=a;
  }
}

class Dog{
  String a;
  Dog(String a){
    this.a=a;
  }
}
class Main{
  public static void main(String[] args) {
    List<Cat> ls = new ArrayList<>();
    ls.add(new Cat(12));
    ls.add((Cat)new Dog("german"));
   System.out.println(ls);
  }
}
