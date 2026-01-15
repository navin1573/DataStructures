
import java.io.*;
import java.util.*;
 
public class CountingRooms {
    static int n, m;
    static char[][] grid;
    static int[] dir = {-1, 0, 1, 0,-1};
 
    static void bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        grid[sr][sc] = '#';
 
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
 
            for (int k = 0; k < 4; k++) {
                int nr = r + dir[k];
                int nc = c + dir[k+1];
 
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '.') {
                    grid[nr][nc] = '#';
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
 
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }
 
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') {
                    bfs(i, j);
                    count++;
                }
            }
        }
 
        System.out.println(count);
    }
}
}
