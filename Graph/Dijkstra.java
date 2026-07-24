import java.util.*;

public class Dijkstra {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    //INPUT 
    //5 6
    // 0 1 2
    // 0 2 4
    // 1 2 1
    // 1 3 7
    // 2 4 3
    // 3 4 1
    // 0
    int n = s.nextInt();
    int m = s.nextInt();
    ArrayList<int[]>[] graph = new ArrayList[n];
    
    for(int i=0;i<n;i++)
      graph[i] = new ArrayList<>();
      for(int j=0;j<m;j++){

        int u = s.nextInt();
        int v = s.nextInt();
        int w = s.nextInt();
        graph[u].add(new int[] {v,w});
        graph[v].add(new int[] {u,w});
      }
      int source = s.nextInt(); 

for (int i = 0; i < graph.length; i++) {
    System.out.println(i + " -> " + Arrays.deepToString(graph[i].toArray()));
}
    int[] dist = dstra(graph,source); 
    System.out.println("Shortest Path: "+ Arrays.toString(dist));
  }
static int[] dstra(List<int[]>[] graph,int src){
  int[] dist = new int[graph.length];
  Arrays.fill(dist,Integer.MAX_VALUE);
  dist[src] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
    pq.offer(new int[] {src,0});
    while(!pq.isEmpty()){
      int[] cur = pq.poll();
      int u = cur[0];
      int d = cur[1];
      if(d>dist[u]) continue;
      for(int[] e:graph[u]){
        int v = e[0];
        int w = e[1];
        if(dist[v]>d+w){
          dist[v] = d+w;
          pq.offer(new int[] {v,dist[v]});
        }
      }
    }
    return dist;
}
}

