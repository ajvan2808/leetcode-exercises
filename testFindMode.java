import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class testFindMode {
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(2);
    TreeNode root = new TreeNode(1, node2, node3);

    @Test
    public void FindMode() {
        findModeInBinarySearchTree FindModeInBinarySearchTree = new findModeInBinarySearchTree();

        List<Integer> actualResult = FindModeInBinarySearchTree.findMode(root);
        List<Integer> expected = Arrays.asList(2);

        Assert.assertEquals(expected, actualResult);

    }

}
