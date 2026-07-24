
import java.util.*;
import java.io.*;

public class YoungPhy {

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
       static PrintWriter out;
    public static void main(String[] args) throws Exception {
        FastReader s = new FastReader();
        out = new PrintWriter(System.out); 
        int n = s.nextInt();
        int xSum = 0;
        int ySum = 0;
        int zSum = 0;
        for(int i=0;i<n;i++){
          int x = s.nextInt();
          int y = s.nextInt();
          int z = s.nextInt();
          xSum+=x;
          ySum+=y;
          zSum+=z;
        }
        if(xSum==0 && ySum==0 && zSum==0){
          out.println("YES");
        }
        else{
        out.println("NO");
        }
        out.flush();
    }
}
