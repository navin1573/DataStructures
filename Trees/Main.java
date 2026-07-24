import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Main {

    // Build tree using level order input
    static TreeNode buildTree(Scanner sc) {
        
        if (!sc.hasNextInt())
            return null;

        int val = sc.nextInt();

        if (val == -1)
            return null;

        TreeNode root = new TreeNode(val);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (!sc.hasNextInt())
                break;
            int left = sc.nextInt();

            if (left != -1) {
                current.left = new TreeNode(left);
                queue.offer(current.left);
            }

            if (!sc.hasNextInt())
                break;
            int right = sc.nextInt();

            if (right != -1) {
                current.right = new TreeNode(right);
                queue.offer(current.right);
            }
        }

        return root;
    }

    // Example DFS
    static void preorder(TreeNode root) {

        if (root == null)
            return;

        System.out.print(root.val + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
         * Example Input:
         * 1 2 3 4 5 -1 6 -1 -1 7 8
         */

        TreeNode root = buildTree(sc);

        preorder(root);

        sc.close();
    }
}
