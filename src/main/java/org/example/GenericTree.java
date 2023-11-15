/**
 * Abstract class representing a generic tree structure.
 *
 * @param <T> the type of elements in the tree, must extend Comparable
 * @author Athos Ferreira Duarte
 */
package org.example;

import java.util.List;

public abstract class GenericTree<T extends Comparable<T>> {
    protected GenericTreeNode<T> root;

    /**
     * Inserts an element into the tree.
     *
     * @param element the element to be inserted
     */
    public abstract void insert(T element);

    /**
     * Recursive method to insert an element into the tree.
     *
     * @param current the current node being considered
     * @param value   the value to be inserted
     */
    protected abstract void insert(GenericTreeNode<T> current, T value);

    /**
     * Deletes the specified element from the tree.
     *
     * @param element the element to be deleted
     */
    public abstract void delete(T element);

    /**
     * Recursive method to delete an element from the tree.
     *
     * @param current the current node being considered
     * @param value   the value to be deleted
     */
    protected abstract void delete(GenericTreeNode<T> current, T value);

    /**
     * Checks if the tree contains the specified element.
     *
     * @param element the element to be checked for existence
     * @return true if the element is found, false otherwise
     */
    public abstract boolean contains(T element);

    /**
     * Finds a node with the specified element in the tree.
     *
     * @param element the element to be searched for
     * @return the node with the specified element, or null if not found
     */
    protected abstract GenericTreeNode<T> find(T element);

    /**
     * Removes a node without children.
     *
     * @param parent the parent node
     * @param child  the child node to be removed
     */
    protected abstract void removeWithoutChildren(GenericTreeNode<T> parent, GenericTreeNode<T> child);

    /**
     * Removes a node with one child.
     *
     * @param parent the parent node
     * @param child  the child node to be removed
     */
    protected abstract void removeWithOneChildren(GenericTreeNode<T> parent, GenericTreeNode<T> child);

    /**
     * Removes a node with two children.
     *
     * @param current the current node to be removed
     */
    protected abstract void removeWithTwoChildren(GenericTreeNode<T> current);

    /**
     * Traverses the tree in the specified order and returns a list of elements.
     *
     * @param order the order of traversal (see TreeTraversal class for constants)
     * @return a list of elements traversed in the specified order
     */
    public List<T> traverse(int order) {
        return switch (order) {
            case TreeTraversal.PRE_ORDER -> TreeTraversal.preOrderTraversal(root);
            case TreeTraversal.POST_ORDER -> TreeTraversal.postOrderTraversal(root);
            case TreeTraversal.IN_LEVEL_ORDER -> TreeTraversal.levelOrderTraversal(root);
            case TreeTraversal.IN_ORDER -> TreeTraversal.inOrderTraversal(root);
            default -> TreeTraversal.inOrderTraversal(root);
        };
    }
}
