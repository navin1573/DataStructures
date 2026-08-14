import java.util.*;
import java.io.*;

public class NGE {

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
 int[] ans = new int[arr.length];
        int max = 0;
        Arrays.fill(ans,-1);
        for(int i=arr.length-2;i>=0;i--){
                ans[i]=Math.max(arr[i+1],max);
                max=Math.max(arr[i+1],max);
            
        }
        out.println(Arrays.toString(ans));
        out.flush();
    }
}
