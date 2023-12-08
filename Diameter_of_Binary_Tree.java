import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public static TreeNode constructTree(Scanner sc) {
        TreeNode root = null;
        if (sc.hasNextInt()) {
            int val = sc.nextInt();
            if (val != -1) {
                root = new TreeNode(val);
                root.left = constructTree(sc);
                root.right = constructTree(sc);
            }
        }
        return root;
    }

    public static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        DFS(root);
        return diameter;
    }

    public static int DFS(TreeNode root) {
        if (root == null)
            return -1;

        int left = DFS(root.left);
        int right = DFS(root.right);

        diameter = Math.max(diameter, left + right + 2);

        return 1 + Math.max(left, right);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = constructTree(sc);
        sc.close();
        System.out.println(diameterOfBinaryTree(root));
    }
}
