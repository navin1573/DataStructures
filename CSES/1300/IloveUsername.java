
import java.util.*;
import java.io.*;

public class IloveUsername{

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
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
           arr[i] = sc.nextInt();
        }
        int best = arr[0];
        int worst = arr[0];
        int ans=0;
        for(int i=1;i<n;i++){
          if(arr[i]>best){
            ans++;
            best = arr[i];
          }
          if(arr[i]<worst){
            ans++;
            worst = arr[i];
          }
        }
        out.println(ans);
        out.flush();
    }

}

