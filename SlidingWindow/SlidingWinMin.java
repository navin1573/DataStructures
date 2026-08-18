
import java.util.*;
import java.io.*;

public class SlidingWinMin {

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
     out = PrintWriter(System.out);
     int n = sc.nextInt();
     int k = sc.nextInt();
     int res=0; 
       Deque<Integer> dq = new ArrayDeque<>();
       int idx=0;
       for(int i=0;i<nums.length;i++){
        while(!dq.isEmpty() && dq.peekFirst()<=i-k){
            dq.pollFirst();
        }
        while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
            dq.pollLast();
        }
        dq.offerLast(i);
        if(i>=k-1){
           res+=nums[dq.peekFirst()]; 
        }
       }
    }
}
