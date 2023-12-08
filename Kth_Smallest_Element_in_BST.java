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
    public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> storeElements=new ArrayList<>();
        inorder(root,storeElements);
        return storeElements.get(k-1);
    }
    public static void inorder(TreeNode root,ArrayList<Integer> storeElements){
        if(root==null){
            return;
        }
        inorder(root.left,storeElements);
        storeElements.add(root.val);
        inorder(root.right,storeElements);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = constructTree(sc);
        sc.close();
        System.out.println(kthSmallest(root, n));
    }
}
