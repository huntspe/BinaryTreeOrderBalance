import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    @Test
    void insertBST() {
        Collection<Integer> elems;
        BinaryTree<Integer> btree, otree;

        elems = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        btree = BinaryTree.mkBalanced(elems);
        assertTrue(btree.isBalanced());
        assertEquals(4, btree.height());

        TreePrinter.print(btree);

        elems = Arrays.asList(1, 2, 3, 4, 5);
        btree = BinaryTree.mkBalanced(elems);
        otree = BinaryTree.mkBST(elems);

        TreePrinter.print(btree);
        TreePrinter.print(otree);
    }


    @Test
    void mapsum () {
        Collection<Integer> elems;
        BinaryTree<Integer> btree;
        BinaryTree<Integer> bst;

        elems = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        bst = BinaryTree.mkBST(elems);
        btree = BinaryTree.mkBalanced(elems);
        TreePrinter.print(btree);
        assertEquals(120, TreeTraversals.sum(bst));
        assertEquals(120, TreeTraversals.sum(btree));

        BinaryTree<Integer> mapped = TreeTraversals.map(x -> x * 2, btree);
        BinaryTree<Integer> mappedBST = TreeTraversals.map(x -> x * 2, bst);
        TreePrinter.print(mapped);
        assertEquals(240, TreeTraversals.sum(mappedBST));
        assertEquals(240, TreeTraversals.sum(mapped));
    }

   @Test
   void findBST(){
        Collection<Integer> elems;
        BinaryTree<Integer> btree;
        BinaryTree<Integer> bst;

        elems = Arrays.asList(1, 2, 3, 4, 5);
        bst = BinaryTree.mkBST(elems);
        btree = BinaryTree.mkBalanced(elems);
        TreePrinter.print(btree);
        assertTrue(bst.findBST(1));
        assertTrue(bst.findBST(2));
        assertTrue(bst.findBST(3));
        assertTrue(bst.findBST(4));
        assertTrue(bst.findBST(5));
        assertFalse(bst.findBST(6));
        assertFalse(bst.findBST(7));
   }

    @Test
    void mul () {
        Collection<Integer> elems;
        BinaryTree<Integer> btree;
        BinaryTree<Integer> bst;

        elems = Arrays.asList(1, 2, 3, 4, 5);
        bst = BinaryTree.mkBST(elems);
        btree = BinaryTree.mkBalanced(elems);
        TreePrinter.print(btree);
        assertEquals(120, TreeTraversals.mul(btree));
        assertEquals(120, TreeTraversals.mul(bst));

        BinaryTree<Integer> mapped = TreeTraversals.map(x -> x * 2, btree);
        BinaryTree<Integer> mappedBST = TreeTraversals.map(x -> x * 2, bst);

        TreePrinter.print(mapped);
        assertEquals(3840, TreeTraversals.mul(mappedBST));
        assertEquals(3840, TreeTraversals.mul(mapped));
    }

    @Test
    void mirror () {
        Collection<Integer> elems;
        BinaryTree<Integer> btree;
        BinaryTree<Integer> bst;

        elems = Arrays.asList(1, 2, 3, 4, 5);
        bst = BinaryTree.mkBST(elems);
        btree = BinaryTree.mkBalanced(elems);
        TreePrinter.print(btree);
        TreePrinter.print(TreeTraversals.mirror(btree));
        List<Integer> l = TreeTraversals.inOrderList(btree);
        List<Integer> r = TreeTraversals.inOrderList(TreeTraversals.mirror(btree));
        List<Integer> lBST = TreeTraversals.inOrderList(bst);
        List<Integer> rBST = TreeTraversals.inOrderList(TreeTraversals.mirror(bst));
        for (int i = 0; i < l.size(); i++) {
            assertEquals(l.get(i), r.get(r.size() - i - 1));
        }
        for (int i = 0; i < lBST.size(); i++) {
            assertEquals(lBST.get(i), rBST.get(rBST.size() - i - 1));
        }
    }

    @Test
    void breathFirstList() {
        Collection<Integer> elems = Arrays.asList(1, 2, 3, 4, 5);
        Collection<Integer> elems2 = Arrays.asList(4, 6, 3, 2, 5, 1);
        // Test with a balanced binary tree
        BinaryTree<Integer> balancedTree = BinaryTree.mkBalanced(elems);
        List<Integer> expectedBalancedBreadthFirstList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> balancedBreadthFirstList = TreeTraversals.breadthFirstList(balancedTree);
        assertEquals(expectedBalancedBreadthFirstList, balancedBreadthFirstList);

        // Test with a binary search tree
        BinaryTree<Integer> bst = BinaryTree.mkBST(elems2);
        List<Integer> expectedBSTBreadthFirstList = Arrays.asList(4, 3, 6, 2, 5, 1);
        List<Integer> bstBreadthFirstList = TreeTraversals.breadthFirstList(bst);
        assertEquals(expectedBSTBreadthFirstList, bstBreadthFirstList);
    }

    @Test
    void preOrderList() {
        Collection<Integer> elems = Arrays.asList(1, 2, 3, 4, 5);
        Collection<Integer> elems2 = Arrays.asList(4, 6, 3, 2, 5, 1);
        // Test with a balanced binary tree
        BinaryTree<Integer> balancedTree = BinaryTree.mkBalanced(elems);
        List<Integer> expectedBalancedPreOrderList = Arrays.asList(1, 2, 4, 3, 5);
        List<Integer> balancedPreOrderList = TreeTraversals.preOrderList(balancedTree);
        assertEquals(expectedBalancedPreOrderList, balancedPreOrderList);

        // Test with a binary search tree
        BinaryTree<Integer> bst = BinaryTree.mkBST(elems2);
        List<Integer> expectedBSTPreOrderList = Arrays.asList(4, 3, 2, 1, 6, 5);
        List<Integer> bstPreOrderList = TreeTraversals.preOrderList(bst);
        assertEquals(expectedBSTPreOrderList, bstPreOrderList);
    }

    @Test
    void postOrderList() {
        Collection<Integer> elems = Arrays.asList(1, 2, 3, 4, 5);
        Collection<Integer> elems2 = Arrays.asList(4, 6, 3, 2, 5, 1);

        // Test with a balanced binary tree
        BinaryTree<Integer> balancedTree = BinaryTree.mkBalanced(elems);
        List<Integer> expectedBalancedPostOrderList = Arrays.asList(4, 2, 5, 3, 1);
        List<Integer> balancedPostOrderList = TreeTraversals.postOrderList(balancedTree);
        assertEquals(expectedBalancedPostOrderList, balancedPostOrderList);

        // Test with a binary search tree
        BinaryTree<Integer> bst = BinaryTree.mkBST(elems2);
        List<Integer> expectedBSTPostOrderList = Arrays.asList(1, 2, 3, 5, 6, 4);
        List<Integer> bstPostOrderList = TreeTraversals.postOrderList(bst);
        assertEquals(expectedBSTPostOrderList, bstPostOrderList);


    }

    @Test
    void inOrderList() {
        Collection<Integer> elems = Arrays.asList(1, 2, 3, 4, 5);
        Collection<Integer> elems2 = Arrays.asList(4, 6, 3, 2, 5, 1);

        // Test with a balanced binary tree
        BinaryTree<Integer> balancedTree = BinaryTree.mkBalanced(elems);
        List<Integer> expectedBalancedInOrderList = Arrays.asList(2, 4, 1, 3, 5);
        List<Integer> balancedInOrderList = TreeTraversals.inOrderList(balancedTree);
        assertEquals(expectedBalancedInOrderList, balancedInOrderList);

        // Test with a binary search tree
        BinaryTree<Integer> bst = BinaryTree.mkBST(elems2);
        List<Integer> expectedBSTInOrderList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> bstInOrderList = TreeTraversals.inOrderList(bst);
        assertEquals(expectedBSTInOrderList, bstInOrderList);
    }

    @Test
    void height(){
        Collection<Integer> elems;
        BinaryTree<Integer> btree;
        BinaryTree<Integer> bst;

        elems = Arrays.asList(1, 2, 3, 4, 5);
        bst = BinaryTree.mkBST(elems);
        btree = BinaryTree.mkBalanced(elems);
        TreePrinter.print(btree);
        TreePrinter.print(TreeTraversals.mirror(btree));
        assertEquals(3, btree.height());
        assertEquals(5, bst.height());
    }

    @Test
    void isBalanced(){
        Collection<Integer> elems;
        BinaryTree<Integer> btree;
        BinaryTree<Integer> bst;

        elems = Arrays.asList(1, 2, 3, 4, 5);
        bst = BinaryTree.mkBST(elems);
        btree = BinaryTree.mkBalanced(elems);
        TreePrinter.print(btree);
        TreePrinter.print(TreeTraversals.mirror(btree));
        assertTrue(btree.isBalanced());
        assertFalse(bst.isBalanced());
    }

    @Test
    void isEmpty(){
        Collection<Integer> elems;
        BinaryTree<Integer> btree;
        BinaryTree<Integer> bst;

        elems = Arrays.asList();
        bst = BinaryTree.mkBST(elems);
        btree = BinaryTree.mkBalanced(elems);
        TreePrinter.print(btree);
        TreePrinter.print(TreeTraversals.mirror(btree));
        assertTrue(btree.isEmpty());
        assertTrue(bst.isEmpty());
    }
}