/**
 * Abstract class representing a tree balancer.
 * Provides a method to balance a generic tree.
 *
 * @author Athos Ferreira Duarte
 */
package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class TreeBalancer {

    /**
     * Balances a generic tree.
     *
     * @param unbalancedTree the unbalanced tree to be balanced
     * @param <T>            the type of elements in the tree, must extend Comparable
     * @return the balanced tree
     */
    public static <T extends Comparable<T>> GenericTree<T> balanceTree(GenericTree<T> unbalancedTree) {
        try {
            List<T> orderElements = (ArrayList<T>) unbalancedTree.traverse(TreeTraversal.IN_ORDER);
            List<T> balancedElements = new ArrayList<>();

            @SuppressWarnings("unchecked")
            @Deprecated
            GenericTree<T> balancedTree = unbalancedTree.getClass().newInstance();

            while (!orderElements.isEmpty()) {
                T firstElement = orderElements.remove(0);

                if (!orderElements.isEmpty()) {
                    T nextElement = orderElements.remove(0);
                    balancedElements.add(nextElement);
                }

                balancedElements.add(firstElement);
            }

            while (!balancedElements.isEmpty()) {
                balancedTree.insert(balancedElements.remove(0));
            }

            return balancedTree;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

    }
}
