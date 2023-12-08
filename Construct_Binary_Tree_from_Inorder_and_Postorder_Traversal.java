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
    private static int post = 0;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder.length - 1;
        post = postorder.length - 1;
        return build(inorder, postorder, Integer.MIN_VALUE);
    }
    
    private static TreeNode build(int[] inorder, int[] postorder, int stop) {
        if (post < 0) {
            return null;
        }
        if (inorder[in] == stop) {
            --in;
            return null;
        }
        
        TreeNode node = new TreeNode(postorder[post--]);
        node.right = build(inorder, postorder, node.val);
        node.left = build(inorder, postorder, stop);
        
        return node;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int inorder[] = new int[n];
        int postorder[] = new int[n];
        for(int i=0; i<n; i++) {
            inorder[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            postorder[i] = sc.nextInt();
        }
       
        TreeNode result = buildTree(inorder, postorder);
        System.out.println(result.val);
    }
}
