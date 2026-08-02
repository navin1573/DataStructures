import java.util.*;
import java.io.*;

public class A{

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
        String s = sc.next();
        int zero = s.indexOf('0');
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
           if(i!=zero)
             sb.append(s.charAt(i));
          }
          int one = -1;
          for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1'){
              one =i;
              break;
            }
          }
          StringBuilder ans = new StringBuilder();
          for(int j=0;j<sb.length();j++){
            if(j!=one){
              ans.append(sb.charAt(j));
            }
          }
          out.println(ans);
        }
        out.flush();
        }
    
    }
