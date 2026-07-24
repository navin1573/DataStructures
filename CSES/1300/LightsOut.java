import java.util.*;
import java.io.*;

public class LightsOut{

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
    static FastReader sc;
    static PrintWriter out;
    public static void main(String[] args) throws Exception {
        sc = new FastReader();
        out = new PrintWriter(System.out);
        int[][] arr= new int[3][3];
        for (int[] row : arr) {
          Arrays.fill(row, 1);
        }
        int[] dr = {0,-1,1,0,0};
        int[] dc = {0,0,0,-1,1};
        for(int i=0;i<3;i++){
          for(int j=0;j<3;j++){
              int sw=sc.nextInt();
              if(sw%2==1){
                for(int k=0;k<dr.length;k++){
                  if(i+dr[k]>=0 && i+dr[k]<3 && j+dc[k]>=0 && j+dc[k]<3){
                    arr[i+dr[k]][j+dc[k]]^=1;
                  }
                }
              }
          }
        }
        for(int i=0;i<3;i++){
          System.out.println(""+arr[i][0]+arr[i][1]+arr[i][2]);
        }
        out.flush();
    }
}
