import java.util.*;
import java.io.*;

public class MessageRoute {

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException {

        FastReader s = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int n = s.nextInt();
        int m = s.nextInt();

        List<Integer>[] ls = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            ls[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            ls[u].add(v);
            ls[v].add(u);
        }

        boolean[] vis = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : ls[u]) {
                if (!vis[v]) {
                    vis[v] = true;
                    parent[v] = u;
                    q.add(v);
                }
            }
        }

        if (!vis[n]) {
            pw.println("IMPOSSIBLE");
            pw.flush();
            return;
        }

        List<Integer> ans = new ArrayList<>();
        for (int cur = n; cur != -1; cur = parent[cur]) {
            ans.add(cur);
        }
        Collections.reverse(ans);

        pw.println(ans.size());
        for (int x : ans) {
            pw.print(x + " ");
        }
        pw.println();
        pw.flush();
    }
}

