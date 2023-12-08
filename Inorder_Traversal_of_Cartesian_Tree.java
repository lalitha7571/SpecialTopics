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

    public static TreeNode buildTree(ArrayList<Integer> inorder) {
        if (inorder == null || inorder.size() == 0) {
            return null;
        }
        return inorderTraversal(inorder, 0, inorder.size() - 1);
    }

    private static TreeNode inorderTraversal(ArrayList<Integer> inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int maxVal = Integer.MIN_VALUE, maxIndex = -1;
        
        for (int i = start; i <= end; i++) {
            int currentVal = inorder.get(i);
            if (currentVal > maxVal) {
                maxVal = currentVal;
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = inorderTraversal(inorder, start, maxIndex - 1);
        root.right = inorderTraversal(inorder, maxIndex + 1, end);
        return root;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> inorder = new ArrayList<>();
        for(int i=0; i<n; i++) {
            inorder.add(sc.nextInt());
        }
      
        TreeNode result = buildTree(inorder);
        System.out.println(result.val);
    }
}
