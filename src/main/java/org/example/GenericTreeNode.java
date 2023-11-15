/**
 * Abstract class representing a generic tree node.
 *
 * @param <T> the type of element in the node
 * @author Athos Ferreira Duarte
 */
package org.example;

public abstract class GenericTreeNode<T> {
    protected T element;
    protected GenericTreeNode<T> left;
    protected GenericTreeNode<T> right;

    /**
     * Constructor to initialize the node with a specified element.
     *
     * @param value the element of the node
     */
    public GenericTreeNode(T value) {
        this.element = value;
    }

    /**
     * Sets the right child of the node.
     *
     * @param node the right child node
     */
    public void setRight(GenericTreeNode<T> node) {
        right = node;
    }

    /**
     * Sets the left child of the node.
     *
     * @param node the left child node
     */
    public void setLeft(GenericTreeNode<T> node) {
        left = node;
    }

    /**
     * Sets the element of the node.
     *
     * @param element the element to be set
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Gets the right child of the node.
     *
     * @return the right child node
     */
    public GenericTreeNode<T> getRight() {
        return right;
    }

    /**
     * Gets the left child of the node.
     *
     * @return the left child node
     */
    public GenericTreeNode<T> getLeft() {
        return left;
    }

    /**
     * Gets the element of the node.
     *
     * @return the element of the node
     */
    public T getElement() {
        return element;
    }
}
