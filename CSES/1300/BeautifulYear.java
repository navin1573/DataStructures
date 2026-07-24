
import java.util.*;
import java.io.*;

public class BeautifulYear {

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
        int y = sc.nextInt();
        do{
          y++;
        }while (!isBeautiful(y));
      out.println(y);
        out.flush();

    }
    static boolean isBeautiful(int y){
        int a=y%10;
        int b=(y/10)%10;
        int c=(y/100)%10;
        int d=(y/1000);
        if(a!=b && a!=c && a!=d && b!=c && b!=d && c!=d){
          return true;
        }
        return false;
    }
}
