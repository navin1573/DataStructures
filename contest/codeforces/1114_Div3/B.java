
import java.util.*;
import java.io.*;

public class B {

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
    int t = sc.nextInt();
    while(t-->0){
     int n = sc.nextInt();
     String s = sc.next();
     int ans = 1;
     int x = 0;
     for(int i=1;i<s.length();i++){
       if(s.charAt(i)!=s.charAt(i-1)) ans++;

       if(i==s.length()-1) break;

       if(s.charAt(i)!=s.charAt(i-1) && s.charAt(i)!=s.charAt(i+1)){
            if(s.charAt(i-1)==s.charAt(i+1)) x = 2;
            else x = Math.max(x,1);
       }
     } 
      out.println(ans-x); 
      out.flush();
    }
    }

}
