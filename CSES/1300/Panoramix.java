
import java.util.*;
import java.io.*;

public class Panoramix {

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
    static FastReader sc;
    public static void main(String[] args) throws Exception {
      sc = new FastReader();
      out = new PrintWriter(System.out);
      int n = sc.nextInt();
      int m = sc.nextInt();
      boolean[] prime=new boolean[51];
      Arrays.fill(prime,true);
      prime[0]=false;
      prime[1]=false;
      for(int i=2;i*i<=50;i++){
      if(prime[i]){
      for(int j=i*i;j<=50;j+=i){
      prime[j]=false;
      }
      }
      }
      boolean flag = false;
      for(int i=n+1;i<prime.length;i++){
        if(prime[i]){
          out.println((i==m)?"YES":"NO");
          flag=true;
          break;
        }
      }
        if(flag==false)out.println("NO");
      out.flush();
      
    }
  }
