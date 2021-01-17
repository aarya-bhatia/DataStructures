package com.aarya.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public void insert(T data) {
        BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(data);
        if (root == null) {
            root = newNode;
        } else {
            insert(root, newNode);
        }
    }

    public void insert(BinaryTreeNode<T> currentNode, BinaryTreeNode<T> newNode) {
        if (newNode.compareTo(currentNode) < 0) {
            if (!currentNode.hasLeft()) {
                currentNode.setLeft(newNode);
            } else {
                insert(currentNode.getLeft(), newNode);
            }
        } else {
            if (!currentNode.hasRight()) {
                currentNode.setRight(newNode);
            } else {
                insert(currentNode.getRight(), newNode);
            }
        }
    }

    public BinaryTreeNode<T> delete(T data) {
        if (root.equals(data)) {
            BinaryTreeNode<T> prevRoot = root;
            if (root.hasLeft()) {
                root = root.getLeft();
                if (prevRoot.hasRight()) {
                    insert(root, prevRoot.getRight());
                }
            } else {
                root = root.getRight();
                if (prevRoot.hasLeft()) {
                    insert(root, prevRoot.getLeft());
                }
            }
            return prevRoot;
        }

        Queue<BinaryTreeNode<T>> q = new LinkedList<>();
        q.add(root);
        BinaryTreeNode<T> child = null;
        while (!q.isEmpty()) {
            BinaryTreeNode<T> node = q.remove();
            if (node.hasLeft()) {
                if (node.getLeft().equals(data)) {
                    child = node.getLeft();
                    node.setLeft(null);
                    if (child.hasLeft()) { // left subtree
                        insert(node, child.getLeft());
                    }
                    if (child.hasRight()) { // right subtree
                        insert(node, child.getRight());
                    }
                    break;
                } else {
                    q.add(node.getLeft());
                }
            }
            if (node.hasRight()) {
                if (node.getRight().equals(data)) {
                    child = node.getRight();
                    node.setRight(null);
                    if (child.hasLeft()) {
                        insert(node, child.getLeft());
                    }
                    if (child.hasRight()) {
                        insert(node, child.getRight());
                    }
                    break;
                } else {
                    q.add(node.getRight());
                }
            }
        }
        return child;
    }

    public BinaryTreeNode<T> search(T data) {
        // TODO Auto-generated method stub
        return null;
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(BinaryTreeNode<T> currentNode) {
        if (currentNode == null)
            return;
        System.out.println(currentNode.getData());
        preOrder(currentNode.getLeft());
        preOrder(currentNode.getRight());
    }

    public void postOrder(BinaryTreeNode<T> currentNode) {
        if (currentNode == null) {
            return;
        }
        postOrder(currentNode.getLeft());
        postOrder(currentNode.getRight());
        System.out.println(currentNode.getData());
    }

    public void inOrder() {
        // TODO Auto-generated method stub

    }

    public void levelOrder() {
        // TODO Auto-generated method stub

    }
}
