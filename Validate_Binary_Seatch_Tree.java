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

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    public static boolean isValid(TreeNode root, Integer max, Integer min) {

        if(root == null)
            return true;

        if((max != null && root.val >= max) || (min != null && root.val <= min)) {
            return false;
        }

        return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = constructTree(sc);
        sc.close();

        System.out.println(isValidBST(root));
    }
}
