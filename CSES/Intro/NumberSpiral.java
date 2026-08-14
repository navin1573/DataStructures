import java.util.*;
import java.io.*;

public class NumberSpiral{

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
            long y = sc.nextLong();
            long x = sc.nextLong();
            long ans=0;
            if(x>y){
                if(x%2==1){
                    ans+=(x*x)-(y-1);
                }
                else{
                    ans+=(x-1)*(x-1)+y;
                }
            }
            else{
                if(y%2==1){
                    ans+=(y-1)*(y-1)+x;
                }
                else{
                    ans+=(y*y)-(x-1);
                }

            }
            out.println(ans);
            out.flush();
        }

    }
}

