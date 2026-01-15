import java.util.*; 
import java.io.*; 

public class Labyrinth { 

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

    static char[][] grid; 
    static boolean[][] blocked; 
    static boolean[][] visited; 
    static int[][] prev; 
    static Point A = new Point(-1,-1); 
    static Point B = new Point(-1,-1); 
    static int[] dir = {-1,0,1,0,-1}; 
    static String rid = "URDL"; 
    static FastReader s;
    static PrintWriter pw;
    static int n;
    static int m;
    public static void main(String[] args) throws Exception { 
        pw = new PrintWriter(System.out); 
        s = new FastReader(); 
        n = s.nextInt(); 
        m = s.nextInt(); 
        grid = new char[n][m]; 
        blocked = new boolean[n][m]; 
        visited = new boolean[n][m]; 
        prev = new int[n][m]; 

        for(int i=0;i<n;i++){ 
            String row = s.next(); 
            for(int j=0;j<m;j++){ 
                grid[i][j]=row.charAt(j); 
            } 
        } 

        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) { 
                if(grid[i][j]=='#'){ 
                    blocked[i][j]=true; 
                } 
                else{ 
                    blocked[i][j]=false; 
                    if(grid[i][j]=='A'){ 
                        A = new Point(i,j); 
                    } 
                    if(grid[i][j]=='B'){ 
                        B = new Point(i,j); 
                    } 
                } 
            } 
        } 

        bfs(); 
    } 

    static void bfs(){ 
        Queue<Point> q = new LinkedList<>(); 
        q.add(A); 
        while(!q.isEmpty()){ 
            Point cur = q.poll(); 
            for(int k=0;k<4;k++){ 
                Point nx = new Point(cur.x+dir[k],cur.y+dir[k+1]); 
                if(nx.x<0 || nx.y<0 || nx.x>=n || nx.y>=m)continue; 
                if(blocked[nx.x][nx.y] || visited[nx.x][nx.y]) continue; 
                visited[nx.x][nx.y]=true; 
                prev[nx.x][nx.y]=k; 
                q.add(nx); 
            } 
        } 

        if(visited[B.x][B.y]){ 
            pw.println("YES");
            List<Integer> ls = new ArrayList<>(); 
            while(A.x!=B.x || A.y!=B.y){ 
                int p = prev[B.x][B.y]; 
                ls.add(p); 
                B.x = B.x-dir[p]; 
                B.y = B.y-dir[p+1];
            } 
            Collections.reverse(ls);
            pw.println(ls.size());
            for(int i:ls){ 
                pw.print(rid.charAt(i)); 
            } 
        } 
        else{ 
            pw.println("NO"); 
        }
        pw.close();
    } 

    static class Point{ 
        int x; 
        int y; 
        Point(int x,int y){ 
            this.x=x; 
            this.y=y; 
        } 
    } 
}
