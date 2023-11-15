/**
 * Class providing static methods for tree traversal.
 *
 * @param <T> the type of elements in the tree
 * @author Athos Ferreira Duarte
 */
package org.example;

import java.util.*;

public abstract class TreeTraversal<T> {

    public final static int IN_ORDER = 1;
    public final static int PRE_ORDER = 2;
    public final static int POST_ORDER = 3;
    public final static int IN_LEVEL_ORDER = 4;

    /**
     * Performs an in-order traversal of the tree.
     *
     * @param root the root of the tree
     * @param <T>  the type of elements in the tree
     * @return a list of elements traversed in in-order
     */
    public static <T> List<T> inOrderTraversal(GenericTreeNode<T> root) {
        if (root == null) {
            return new ArrayList<>();
        }
        GenericTreeNode<T> current = root;
        Stack<GenericTreeNode<T>> stack = new Stack<>();
        List<T> elements = new ArrayList<>();
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            elements.add(current.getElement());
            current = current.getRight();
        }

        return elements;
    }

    /**
     * Performs a pre-order traversal of the tree.
     *
     * @param root the root of the tree
     * @param <T>  the type of elements in the tree
     * @return a list of elements traversed in pre-order
     */
    public static <T> List<T> preOrderTraversal(GenericTreeNode<T> root) {
        if (root == null) {
            return new ArrayList<>();
        }
        GenericTreeNode<T> current;
        Stack<GenericTreeNode<T>> stack = new Stack<>();
        List<T> elements = new ArrayList<>();

        stack.push(root);

        while (!stack.empty()) {
            current = stack.pop();
            elements.add(current.getElement());
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }

        return elements;
    }

    /**
     * Performs a post-order traversal of the tree.
     *
     * @param root the root of the tree
     * @param <T>  the type of elements in the tree
     * @return a list of elements traversed in post-order
     */
    public static <T> List<T> postOrderTraversal(GenericTreeNode<T> root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<GenericTreeNode<T>> stack = new Stack<>();
        stack.push(root);

        List<T> elements = new ArrayList<>();

        while (!stack.isEmpty()) {
            GenericTreeNode<T> current = stack.pop();
            elements.add(0, current.getElement()); // Adds to the beginning of the list to reverse the order

            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
        }

        return elements;
    }

    /**
     * Performs a level-order traversal of the tree.
     *
     * @param root the root of the tree
     * @param <T>  the type of elements in the tree
     * @return a list of elements traversed in level-order
     */
    public static <T> List<T> levelOrderTraversal(GenericTreeNode<T> root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<GenericTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        GenericTreeNode<T> current;
        List<T> elements = new ArrayList<>();

        while (!queue.isEmpty()) {
            current = queue.poll();
            elements.add(current.getElement());
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        return elements;
    }
}
