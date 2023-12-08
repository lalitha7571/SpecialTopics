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
     static Map<Integer, Map<Integer, List<Integer>>> map;

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        preorder(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();

        for (Integer i : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            for (Integer j : map.get(i).keySet()) {
                Collections.sort(map.get(i).get(j));
                temp.addAll(map.get(i).get(j));
            }
            result.add(temp);
        }

        return result;
    }

    public static void preorder(TreeNode root, int x, int y) {
        if (root == null) return;
        map.computeIfAbsent(y, i -> new TreeMap<>())
                .computeIfAbsent(x, i -> new ArrayList<>())
                .add(root.val);
        preorder(root.left, x + 1, y - 1);
        preorder(root.right, x + 1, y + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = constructTree(sc);
        sc.close();
        List<List<Integer>> result = verticalTraversal(root);
        for (List<Integer> innerList : result) {
            for (Integer element : innerList) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
