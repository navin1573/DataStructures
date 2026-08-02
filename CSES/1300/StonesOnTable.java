
import java.util.*;
import java.io.*;

public class StonesOnTable {

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
    static PrintWriter out;
    static FastReader sc;
    public static void main(String[] args) throws Exception {
         sc= new FastReader();
         out = new PrintWriter(System.out);
         int n = sc.nextInt();
         String s = sc.next();
         char[] arr = s.toCharArray();
         int ans=0;
         for(int i=1;i<arr.length;i++){
           if(arr[i]==arr[i-1]) ans++;
         }
      out.println(ans);
      out.flush();
    }
}
