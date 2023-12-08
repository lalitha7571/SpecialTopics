import java.util.Scanner;

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

    public static int count = 0;

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        countNodes(root.right);
        count++;
        countNodes(root.left);
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = constructTree(sc);
        sc.close();
        System.out.println(countNodes(root));
    }
}
