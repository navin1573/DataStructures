public class Main {

    static int[] arr = {1, 2, 3};
    static boolean[] used = new boolean[arr.length];
    static int[] perm = new int[arr.length];

    static void backtrack(int pos) {
        // base case: permutation complete
        if (pos == arr.length) {
            printPermutation();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[pos] = arr[i];

                backtrack(pos + 1);

                // backtrack
                used[i] = false;
            }
        }
    }

    static void printPermutation() {
        for (int i = 0; i < perm.length; i++) {
            System.out.print(perm[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        backtrack(0);
    }
}

