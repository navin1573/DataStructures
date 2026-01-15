
import java.util.*; 
import java.io.*; 

public class BuildingRoads { 

    static class FastReader { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        String next() throws IOException { 
            while (st == null || !st.hasMoreTokens()) { 
                st = new StringTokenizer(br.readLine()); 
            } 
            return st.nextToken(); 
        } 

        int nextInt() throws IOException { return Integer.parseInt(next()); } 
        long nextLong() throws IOException { return Long.parseLong(next()); } 
        double nextDouble() throws IOException { return Double.parseDouble(next()); } 
        char nextChar() throws IOException { return next().charAt(0); } 
        boolean nextBoolean() throws IOException { return Boolean.parseBoolean(next()); } 

        String nextLine() throws IOException { 
            st = null; 
            return br.readLine(); 
        } 
    } 

       static FastReader s;
    static PrintWriter pw;
    static boolean[] vis;
    static List<List<Integer>> ls; 
    public static void main(String[] args) throws Exception { 
        pw = new PrintWriter(System.out); 
        s = new FastReader(); 
        int n = s.nextInt();
        int m = s.nextInt();
        ls = new ArrayList<>();
        for(int i=0;i<=n;i++){
        ls.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
          int u = s.nextInt();
          int v = s.nextInt();
          ls.get(u).add(v);
          ls.get(v).add(u);
        }
      List<Integer> ans = new ArrayList<>();
      vis = new boolean[n+1];
      for(int i=1;i<=n;i++){
      if(!vis[i]){
        helper(i);
        ans.add(i);
      }
    }
    pw.println(ans.size()-1);
    if(ans.size()>1){
      for(int i=1;i<ans.size();i++){
        pw.println(ans.get(0)+" "+ ans.get(i));
      }
    }
    pw.close();
   }
  static void helper(int i){
    if(vis[i]) return;
    vis[i]=true;
    for(int edge:ls.get(i)){
      if(!vis[edge]){
        helper(edge);
      }
    }
  }
}
