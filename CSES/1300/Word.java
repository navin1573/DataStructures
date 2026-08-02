import java.util.*;
import java.io.*;

public class Word{

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
        String s = sc.next();
        int up=0;
        int low=0;
        for(int i=0;i<s.length();i++){
          int ch = s.charAt(i);
          if(ch>='A' && ch<='Z'){
            up++;
          }
          else{
           low++;
          }
        }
        if(up>low){
            out.println(s.toUpperCase());
            out.flush();
        }
        else{
          out.println(s.toLowerCase());
        out.flush();
        }
    }
}
