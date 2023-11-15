package org.example.general;

import org.example.GenericTree;
import org.example.GenericTreeNode;

public class RedBlackTree<T extends Comparable<T>> extends GenericTree<T> {

    private final boolean RED = true;
    private final boolean BLACK = false;
    @Override
    public void insert(T elment) {
        if (root == null) {
            root = new RBTreeNode<T>(elment).black();
        }
        else {
            insert(root, elment);
        }

    }

    @Override
    protected void insert(GenericTreeNode<T> root, T value) {
        RBTreeNode<T> current = (RBTreeNode<T>) root;
        RBTreeNode<T> node = new RBTreeNode<>(value).red();
        RBTreeNode<T> parent;

        while (current != null) {
            parent = current;
            if (value.compareTo(current.getElement()) < 0) {
                current = (RBTreeNode<T>) current.getLeft();
                if (current == null) {
                    parent.setLeft(node);
                    break;
                }
            } else if (value.compareTo(current.getElement()) > 0) {
                current = (RBTreeNode<T>) current.getRight();
                if (current == null) {
                    parent.setRight(node);
                    break;
                }
            }
        }
    }


    private void fixRedBlackPropertiesAfterInsert(RBTreeNode<T> node){
        RBTreeNode<T> parent = node.getParent();
        if (parent.getColor() == BLACK){
            return;
        }
        RBTreeNode<T> grandParent = parent.getParent();



    }
    private RBTreeNode<T> getUncle(RBTreeNode<T> node) {
         RBTreeNode<T> parent = node.getParent();

         if (parent.getLeft() != node) {
             return (RBTreeNode<T>) parent.getLeft();
         }
         else{
             return (RBTreeNode<T>) parent.getRight();
         }
         }
    private void rotateLeft(RedBlackTree<T> node) {}
    private void rotateRight(RedBlackTree<T> node) {}





    @Override
    public void delete(T element) {

    }

    @Override
    protected void delete(GenericTreeNode<T> current, T value) {

    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    protected GenericTreeNode<T> find(T elment) {
        return null;
    }

    @Override
    protected void removeWithoutChildren(GenericTreeNode<T> parent, GenericTreeNode<T> child) {

    }

    @Override
    protected void removeWithOneChildren(GenericTreeNode<T> parent, GenericTreeNode<T> child) {

    }

    @Override
    protected void removeWithTwoChildren(GenericTreeNode<T> current) {

    }



    private class RBTreeNode<T> extends GenericTreeNode<T> {
        private boolean color;
        private RBTreeNode<T> parent;

        public RBTreeNode(T value) {
            super(value);
        }

        public RBTreeNode<T> red() {
            setColor(false);
            return this;
        }

        public RBTreeNode<T> black() {
            setColor(true);
            return this;
        }

        public boolean getColor() {
            return color;
        }

        private void setColor(boolean color) {
            this.color = color;
        }
        public RBTreeNode<T> parent(RBTreeNode<T> parent) {
            this.parent = parent;
            return this;
        }
        public RBTreeNode<T> getParent() {
            return parent;
        }
    }

}

