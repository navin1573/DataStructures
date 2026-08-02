
import java.util.*;
import java.io.*;

public class NearlyLuckyNumber {

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
        out= new PrintWriter(System.out);
        long n = sc.nextLong();
        int notSoLucky=0;
        while(n>0){
          long lastDigit = n%10;
          if(lastDigit==4 || lastDigit==7)notSoLucky++;
          n/=10;
        }
        if(notSoLucky==4 || notSoLucky==7) {
          out.println("YES");
          out.flush();
          return;
        }
          out.println("NO");
          out.flush();
    }
}
