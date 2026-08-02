
import java.util.*;
import java.io.*;

public class Repetitions{

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
        int ans=1;
        int max=1;
        for(int i=0;i<s.length()-1;i++){
           if(s.charAt(i+1)==s.charAt(i)){
             ans+=1;
             max = Math.max(ans,max);
           }
           else{
             ans=1;
           }
        }
        out.println(max);
        out.flush();
    }
}
