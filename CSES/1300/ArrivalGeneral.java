
import java.util.*;
import java.io.*;

public class ArrivalOfGeneral{

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
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
          arr[i]=sc.nextInt();
        }
        int minVal=Integer.MAX_VALUE;
        int maxVal=Integer.MIN_VALUE;
        int minMoves=0;
        int maxMoves=0;
        for(int i=0;i<n;i++){
          minMoves=(arr[i]<=minVal)?Math.abs(n-1-i):minMoves;
          minVal=Math.min(minVal,arr[i]);
          maxMoves=(arr[i]>maxVal)?Math.abs(i):maxMoves;
          maxVal=Math.max(maxVal,arr[i]);
        }
        int ans = maxMoves+minMoves;
        if(maxMoves>(n-1-minMoves))ans--;
        out.println(ans);
        out.flush();
    }

}

