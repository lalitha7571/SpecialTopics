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
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        innerLevels(root, 0, list);
        Collections.reverse(list); 
        return list;
    }

    private static List<List<Integer>> innerLevels(TreeNode node, int level, List<List<Integer>> levels) {
        if (node == null) {
            return levels;
        } else {
            if (level == levels.size()) {
                List<Integer> newList = new ArrayList<>();
                newList.add(node.val);
                levels.add(newList);
            } else {
                levels.get(level).add(node.val);
            }
            innerLevels(node.left, level + 1, levels); 
            innerLevels(node.right, level + 1, levels);
        }
        return levels;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = constructTree(sc);
        sc.close();
        List<List<Integer>> result = levelOrderBottom(root);
        for (List<Integer> innerList : result) {
            for (Integer element : innerList) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
