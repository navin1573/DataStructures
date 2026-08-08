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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[3];
        arr[0]=a;
        arr[1]=b;
        arr[2]=c;
          int ans =0;
          while(true){
            Arrays.sort(arr);
            if(arr[0]==arr[1] || arr[1]==arr[2]){
              break;
            }
            arr[0]++;
            arr[2]--;
            ans++;
          }
          out.println(ans);
        }
        out.flush();
        }
        }
