import java.util.*;

public class Main {

  static class Graph {
    int nv;
    List<List<Integer>> adj;

    Graph(int nv) {
      this.nv = nv;
      adj = new ArrayList<>();
      for (int i = 0; i < nv; i++) {
        adj.add(new ArrayList<>());
      }
    }

    void addNode(int val, int nei) {
      adj.get(val).add(nei);
      adj.get(nei).add(val);
    }

    void printGraph() {
      for (int i = 0; i < nv; i++) {
        System.out.print(i + " --> ");
        for (int val : adj.get(i)) {
          System.out.print(val + " ");
        }
        System.out.println();
      }
    }
    void bfs(int start){
       Queue<Integer> q = new LinkedList<>();
       boolean[] vis = new boolean[nv];
       q.add(start);
       vis[start]=true;
       while (!q.isEmpty()) {
        int cur = q.poll();
        System.out.print(cur+" ");
        for(int val:adj.get(cur)){
          if(!vis[val]){
            vis[val]=true;
            q.add(val);
          }
        }
       }
    }
    void dfs(int start){
     Stack<Integer> st = new Stack<>();
      boolean[] vis = new boolean[nv];
     st.push(start);
      while(!st.isEmpty()){
          int cur = st.pop();
        if(vis[cur]) continue;
          vis[cur] = true;
          System.out.print(cur+" ");
          for(int i=adj.get(cur).size()-1;i>=0;i--){
            if(!vis[adj.get(cur).get(i)]){
                st.push(adj.get(cur).get(i));
            } 
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int nv = s.nextInt();
    int ne = s.nextInt();

    Graph g = new Graph(nv);

    for (int i = 0; i < ne; i++) {
      int val = s.nextInt();
      int nei = s.nextInt();
      g.addNode(val, nei);
    }

    g.printGraph();
    g.bfs(0);
    g.dfs(0);

  }

}


