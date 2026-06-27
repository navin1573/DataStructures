import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class MatrixRep{
public static void main(String[] args) {
   int[][] grid = {{0,0,0,0},
                  {1,1,0,0},
                  {0,0,0,1},
                  {0,1,0,0}};
    Set<List<Integer>> visit = new HashSet<>();
   System.out.println("DFS "+ dfs(grid,0,0,visit));
   System.out.println("BFS "+ bfs(grid));
}

static int dfs(int[][] grid,int r,int c,Set<List<Integer>> visit){
  int ROWS = grid.length;
  int COLS = grid[0].length;
  if(Math.min(r,c)<0 ||
     r==ROWS ||
     c==COLS ||
     visit.contains(Arrays.asList(r,c)) ||
     grid[r][c]==1) return 0;

  if(r==ROWS-1 && c==COLS-1) return 1;
  
  visit.add(Arrays.asList(r,c));
  int up = 0;
  up+=dfs(grid,r+1,c,visit);
  up+=dfs(grid,r-1,c,visit);
  up+=dfs(grid,r,c+1,visit);
  up+=dfs(grid,r,c-1,visit);
  visit.remove(Arrays.asList(r,c));
  return up;
}

static int bfs(int[][] grid){
  int ROWS = grid.length;
  int COLS = grid[0].length;
  boolean[][] visit = new boolean[ROWS][COLS];
  Queue<int[]> q = new ArrayDeque<>();
  q.offer(new int[] {0,0});
  visit[0][0]= true;
  int length=0;
  int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
  while(!q.isEmpty()){
    int size = q.size();
    for(int i=0;i<size;i++){
        int[] cur = q.poll();
        int r = cur[0];
        int c = cur[1];
        if(r==ROWS-1 && c==COLS-1) return length;

        for(int[] d:dir){
          int nr = r+d[0];
          int nc = c+d[1];
          if(Math.min(nr,nc)<0 ||
            nr>=ROWS ||
            nc>=COLS) continue;
          if(visit[nr][nc] || grid[nr][nc]==1) continue;
          q.offer(new int[] {nr,nc});
          visit[nr][nc] = true;
        }
    }
    length++;
  }
  return -1;
}
}
}
