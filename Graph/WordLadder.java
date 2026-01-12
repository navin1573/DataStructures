import java.util.*;
public class WordLadder {
 static int wordLength(String begin,String end,Set<String> wl){
    if(!wl.contains(end)) return 0;
    Queue<String> q = new LinkedList<>();
    q.add(begin);
    int level=1;
    while(!q.isEmpty()){
      int sz = q.size();
      for(int i=0;i<sz;i++){
        String s = q.poll();
        char[] arr = s.toCharArray();
        for(int k=0;k<arr.length;k++){
          char og = arr[k];
          for(char ch='a';ch<='z';ch++){
            arr[k] = ch;
            String ns = new String(arr);
            if(!wl.contains(ns)) continue;  

            if(ns.equals(end)) return level+1; 

            q.add(ns);
            wl.remove(ns);
          }
            arr[k] = og;
        }
      }
      level++;
    }
      return 0;
  } 
 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  String begin = s.next();  
  String end = s.next();  
  int n = s.nextInt();
    Set<String> wl = new HashSet<>();
  for (int i = 0; i < n; i++) {
    wl.add(s.next());
  }
  System.out.println(wordLength(begin,end,wl));
 } 
}

