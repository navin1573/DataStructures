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
   Set<List<Integer>> hs = new HashSet<>();
   System.out.println(dfs(grid,0,0,hs));
}

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

}
