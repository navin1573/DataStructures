import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class MatrixRep{
  public static void main(String[] args) {
   int[][] grid = {{0,1,1},
                  {0,0,1},
                  {0,1,0}};
   Set<List<Integer>> hs = new HashSet<>();
   System.out.println(dfs(grid,0,0,hs));
   System.out.println(bfs(grid));
}

// DFS TRAVERSAL
static int dfs(int[][] grid,int r,int c,Set<List<Integer>> visit ){
  int ROWS = grid.length;
  int COLS = grid[0].length;
  if(Math.min(r,c)<0 ||
      r==ROWS ||
      c==COLS ||
      visit.contains(Arrays.asList(r,c)) ||
      grid[r][c]==1){
      return 0;
    }
  if(r==ROWS-1 && c==COLS-1){
    return 1;
  }
  visit.add(Arrays.asList(r,c));
  int count = 0;
  count+=dfs(grid,r+1,c,visit);
  count+=dfs(grid,r-1,c,visit);
  count+=dfs(grid,r,c+1,visit);
  count+=dfs(grid,r,c-1,visit);
  visit.remove(Arrays.asList(r,c));
  return count;
}

//BFS TRAVERSAL
static int bfs(int[][] grid){
  int ROWS = grid.length;
  int COLS = grid[0].length;
  if(grid[0][0]==1 || grid[ROWS-1][COLS-1]==1){
    return -1;
  }

  boolean[][] visit = new boolean[ROWS][COLS];
  Queue<int[]> q = new ArrayDeque<>();
  q.offer(new int[]{0,0});
  visit[0][0]=true;
  int length=0;
  int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  while(!q.isEmpty()){
    int s = q.size();
    for(int i=0;i<s;i++){
      int[] cur = q.poll();
      int r = cur[0], c = cur[1];

      if(r==ROWS-1 && c==COLS-1){
        return length;
      }
      for(int[] d:dir){
        int nr = r+d[0];
        int nc = c+d[1];
        if(nr<0 || nc<0 || nr >=ROWS || nc >= COLS) continue;
        if(visit[nr][nc] || grid[nr][nc]==1) continue;
        q.offer(new int[] {nr,nc});
        visit[nr][nc]=true;
      }
    }
    length++;
  }
return -1;  
}

}
