
import java.util.*;
import java.io.*;

public class Borze {

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
        FastReader fr = new FastReader();
        sc = new FastReader();
        out = new PrintWriter(System.out);
        String s = sc.next();
        int ans = 0;
        for(int i=0;i<s.length();i++){
          if(s.charAt(i)=='.'){
        System.out.print("0");
          }
          else if(s.charAt(i)=='-' && s.charAt(i+1)=='.'){
            System.out.print("1");
            i++;
          }
          else{
            System.out.print("2");
            i++;
          }
        }
        out.flush();
    }
}
