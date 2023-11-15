/**
 * Binary Tree implementation that extends the GenericTree class.
 * The elements in the tree must be comparable.
 *
 * @param <T> the type of elements in the tree, must extend Comparable
 * @author Athos Ferreira Duarte
 */
package org.example.general;

import org.example.GenericTree;
import org.example.GenericTreeNode;

public class BinaryTree<T extends Comparable<T>> extends GenericTree<T> {

    /**
     * Inserts an element into the binary tree.
     *
     * @param element the element to be inserted
     */
    @Override
    public void insert(T element) {

        if (root == null) {
            root = new BinaryTreeNode<T>(element);
        } else {
            insert(root, element);
        }
    }

    /**
     * Recursive method to insert an element into the binary tree.
     *
     * @param current the current node being considered
     * @param value   the value to be inserted
     */
    @Override
    protected void insert(GenericTreeNode<T> current, T value) {
        GenericTreeNode<T> node = new BinaryTreeNode<>(value);
        GenericTreeNode<T> parent;

        while (true) {
            parent = current;
            if (value.compareTo(current.getElement()) < 0) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(node);
                    break;
                }
            } else if (value.compareTo(current.getElement()) > 0) {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(node);
                    break;
                }
            } else {
                break;
            }
        }
    }

    /**
     * Deletes the specified value from the binary tree.
     *
     * @param value the value to be deleted
     */
    @Override
    public void delete(T value) {
        delete(root, value);
    }

    /**
     * Recursive method to delete a value from the binary tree.
     *
     * @param child the current node being considered
     * @param value the value to be deleted
     */
    @Override
    protected void delete(GenericTreeNode<T> child, T value) {
        GenericTreeNode<T> parent = child;

        while (child != null && value.compareTo(child.getElement()) != 0) {
            parent = child;

            if (value.compareTo(child.getElement()) < 0) {
                child = child.getLeft();
            } else if (value.compareTo(child.getElement()) > 0) {
                child = child.getRight();
            }
        }

        if (child == null) {
            return;
        }

        int countChildren = 0;

        if (child.getLeft() != null) {
            countChildren++;
        }
        if (child.getRight() != null) {
            countChildren++;
        }
        switch (countChildren) {
            case 0:
                removeWithoutChildren(parent, child);
                break;
            case 1:
                removeWithOneChildren(parent, child);
                break;
            case 2:
                removeWithTwoChildren(child);
                break;
        }
    }

    /**
     * Finds the successor node for a given node.
     *
     * @param genericTreeNode the node for which the successor is to be found
     * @return the successor node
     */
    private GenericTreeNode<T> findSuccessor(GenericTreeNode<T> genericTreeNode) {

        GenericTreeNode<T> successor = genericTreeNode.getRight();
        while (successor.getLeft() != null) {
            successor = successor.getLeft();
        }
        return successor;
    }

    /**
     * Removes a node without children.
     *
     * @param parent the parent node
     * @param child  the child node to be removed
     */
    protected void removeWithoutChildren(GenericTreeNode<T> parent, GenericTreeNode<T> child) {

        if (child == root) {
            root = null;
        } else {
            if (parent.getLeft() == child) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
    }

    /**
     * Removes a node with one child.
     *
     * @param parent the parent node
     * @param child  the child node to be removed
     */
    protected void removeWithOneChildren(GenericTreeNode<T> parent, GenericTreeNode<T> child) {
        GenericTreeNode<T> newChild = child.getLeft() != null ? child.getLeft() : child.getRight();

        if (parent.getLeft() == child) {
            parent.setLeft(newChild);
        } else {
            parent.setRight(newChild);
        }

    }

    /**
     * Removes a node with two children.
     *
     * @param current the current node to be removed
     */
    protected void removeWithTwoChildren(GenericTreeNode<T> current) {

        GenericTreeNode<T> successor = findSuccessor(current);
        current.setElement(successor.getElement());
        delete(current.getRight(), successor.getElement());
    }

    /**
     * Checks if the binary tree contains the specified element.
     *
     * @param element the element to be checked for existence
     * @return true if the element is found, false otherwise
     */
    @Override
    public boolean contains(T element) {

        GenericTreeNode<T> current = root;
        while (current != null) {
            if (element.compareTo(current.getElement()) < 0) {
                current = current.getLeft();

            } else if (element.compareTo(current.getElement()) > 0) {
                current = current.getRight();
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a node with the specified element in the binary tree.
     *
     * @param element the element to be searched for
     * @return the node with the specified element, or null if not found
     */
    @Override
    protected GenericTreeNode<T> find(T element) {
        return null;
    }

}
