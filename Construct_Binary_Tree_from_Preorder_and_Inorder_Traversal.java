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

    private static int in = 0;
    private static int pre = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private static TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            ++in;
            return null;
        }

        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int preorder[] = new int[n];
        int inorder[] = new int[n];
        for(int i=0; i<n; i++) {
            preorder[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            inorder[i] = sc.nextInt();
        }
       
        TreeNode result = buildTree(preorder, inorder);
        System.out.println(result.val);
    }
}
