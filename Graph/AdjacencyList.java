import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class  AdjacencyList{
  public static void main(String[] args) {
    int[][] edges = {{1,2},{2,3},{3,4},{2,5},{3,5},{5,4}};
    Map<Integer,List<Integer>> adj = new HashMap<>();
    for(int[] i:edges){
      int u = i[0];
      int v = i[1];
      adj.putIfAbsent(u,new ArrayList<>());
      adj.putIfAbsent(v,new ArrayList<>());
      adj.get(u).add(v);
      adj.get(v).add(u);
    }
    System.out.println(adj);
    Set<Integer> seen = new HashSet<>();
    System.out.println(dfs(1,5,adj,seen));
    Set<Integer> seen1 = new HashSet<>();
    System.out.println(bfs(1,5,adj,seen1));

  }

  static int dfs(int s,int e,Map<Integer,List<Integer>> adj,Set<Integer> seen){
    if(seen.contains(s)) return 0;

    if(s==e) return 1;
    int count = 0;
    seen.add(s);
    for(int nei:adj.get(s)){
      count+=dfs(nei,e,adj,seen); 
    }
    seen.remove(s);
    return count;
  }
  static int bfs(int s,int e,Map<Integer,List<Integer>> adj,Set<Integer> seen){
    Queue<Integer> q = new ArrayDeque<>();
    int len =0;
    seen.add(s);
    q.offer(s);
    while (!q.isEmpty()) {
      int size = q.size();
      for(int i=0;i<size;i++){
          int cur = q.poll();
          if(cur==e) return len;
          for(int nei:adj.get(cur)){
            if(!seen.contains(nei)){
              seen.add(nei);
              q.offer(nei);
            }
          }
      }
      len++;
    }
    return -1;
  }

  }

