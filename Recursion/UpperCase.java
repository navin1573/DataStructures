import java.util.*;
import java.io.*;

public class UpperCase {

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
        String str = sc.next();
        int ans=rec(str,0); 
        if(ans==-1) out.println("No char found");
        else out.println(str.charAt(ans));
        out.flush();
    }
    static int rec(String str,int st){
       if(st==str.length()) return -1;

       if(str.charAt(st)>='A' && str.charAt(st)<='Z')
           return st;
       return rec(str,st+1);
    }
}
