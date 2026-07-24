
import java.util.*;
import java.io.*;

public class QueueAtSchool {

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
    static FastReader s;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        out = new PrintWriter(System.out); 
        int n = sc.nextInt();
        int t = sc.nextInt();
        String s = sc.next();
        char[] ans = s.toCharArray();
        for(int j=0;j<t;j++){
        for(int i=1;i<ans.length;i++){
            if(ans[i]=='G' && ans[i-1]=='B'){
              char temp = ans[i];
              ans[i]=ans[i-1];
              ans[i-1]=temp;
              i++;
            }
        }
      }
      for(int i=0;i<ans.length;i++){
         out.print(ans[i]);
      }
      out.flush();
    }
}
