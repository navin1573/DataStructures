import java.util.*;

class Solution {
    int n;
    boolean[] used;
    int missing = -1;

    public int findMissing(int n, String s) {
        this.n = n;
        used = new boolean[n + 1];
        dfs(s, 0);
        return missing;
    }

    private boolean dfs(String s, int index) {
        if (index == s.length()) {
            int miss = 0;
            for (int i = 1; i <= n; i++) {
                if (!used[i]) {
                    miss = i;
                    break;
                }
            }
            missing = miss;
            return true;
        }

        for (int len = 1; len <= 2; len++) {
            if (index + len > s.length()) break;

            int num = Integer.parseInt(s.substring(index, index + len));

            if (num >= 1 && num <= n && !used[num]) {
                used[num] = true;

                if (dfs(s, index + len))
                    return true;

                used[num] = false;
            }
        }
        return false;
    }
}

public class Main {
 public static void main(String[] args) {
    Solution sol = new Solution();
    int n =2;
    String s = "2";
    System.out.println(sol.findMissing(n,s));
 } 
}
