import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
- Given the root of a binary search tree (BST) with duplicates,
  return all the mode(s) (i.e., the most frequently occurred element) in it.
- If the tree has more than one mode, return them in any order.
* A mode is a value that has the maximum frequency. Note that there could be multiple modes

- Assume a BST is defined as follows:
  The left subtree of a node contains only nodes with keys less than or equal to the node's key.
  The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
  Both the left and right subtrees must also be binary search trees.
*/

// Given a TreeNode of a binary search tree (BST)
class TreeNode {
    int nodeVal;
    TreeNode left;
    TreeNode right;

    public TreeNode(int nodeVal) {
        this.nodeVal = nodeVal;
    }

    public TreeNode(int nodeVal, TreeNode left, TreeNode right) {
        this.nodeVal = nodeVal;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {}
}

// Approach 1: Count Frequency With Hash Map (DFS)

/**
Algorithm
1. Initialize a hash map counter.
2. Create a function dfs(node, counter):
    - If node is null, immediately exit the function.
    - Increment the frequency of node.val in counter.
    - Call dfs on both children with dfs(node.left, counter) and dfs(node.right, counter).
3. Call dfs(root, counter).
4. Find the maximum value in counter as maxFreq.
5. Initialize the answer list ans.
6. Iterate over all key-value pairs in counter. If the value is equal to maxFreq, add the key to ans.
7. Return ans.
*/

public class findModeInBinarySearchTree {
    public List<Integer> findMode(TreeNode root) {
        Map<Integer, Integer> counter = new HashMap<>();
        dfs(root, counter);
        int maxFreq = 0;
        for(int key: counter.keySet()) {
            maxFreq = Math.max(maxFreq, counter.get(key));
        }

        List<Integer> ans = new ArrayList<>();
        for (int key: counter.keySet()) {
            if (counter.get(key) == maxFreq) {
                ans.add(key);
            }
        }
        return ans;
    }

    public void dfs(TreeNode node, Map<Integer, Integer> counter) {
        if (node == null) {
            return;
        }
        // Add value from TreeNode as key and count as value to HashMap
        counter.put(node.nodeVal, counter.getOrDefault(node.nodeVal, 0) +1);
        dfs(node.left, counter);
        dfs(node.right, counter);
    }
}