package leet.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class No_113 {
    public static void main(String[] args) {
        No_113 main = new No_113();

        Integer treeVal[]=new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1};
        Queue<TreeNode> treeNodeQueue=new ArrayDeque<>();
        TreeNode root = new TreeNode(treeVal[0]);
        treeNodeQueue.add(root);
        for (int i = 1; i < treeVal.length;) {
            TreeNode node = treeNodeQueue.poll();
            Integer val = treeVal[i];
            if (val != null) {
                node.left=new TreeNode(val);
                treeNodeQueue.add(node.left);
            }
            i++;
            val = treeVal[i];
            if (val != null) {
                node.right=new TreeNode(val);
                treeNodeQueue.add(node.right);
            }
            i++;
        }
        System.out.println(main.pathSum(root, 22));


    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        pathSumSearchTree(root, result, new ArrayList<>(), 0, targetSum);
        return result;
    }

    public void pathSumSearchTree(TreeNode cur, List<List<Integer>> result, List<Integer> path, int sum, int targetSum) {
        if(cur==null)
            return;
        sum += cur.val;
        path.add(cur.val);
        if (cur.left == null && cur.right == null) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        pathSumSearchTree(cur.left, result, path, sum, targetSum);
        pathSumSearchTree(cur.right, result, path, sum, targetSum);
        path.remove(path.size() - 1);
        return;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
