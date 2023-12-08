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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
       if( p == null && q == null)
            return true;
        if(p == null || q == null){
            return false;
        }
        if(p != null && q != null){
            return (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root1 = constructTree(sc);
        sc.close();
        sc = new Scanner(System.in);
        TreeNode root2 = constructTree(sc);
        sc.close();
        System.out.println(isSameTree(root1, root2));
    }
}
