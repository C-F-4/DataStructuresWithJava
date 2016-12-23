/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llist;

/**
 *
 * @author phoenix
 */
public class BinarySearchTree extends BinaryTree {
    BinarySearchTree() {
        this.root = null;
    }
    
    protected TreeNode insertKey(TreeNode node, int key) {
        if(node == null) {
            node = new TreeNode(key);
        }
        else if(key < node.getData()) {
            node.setLeft(this.insertKey(node.getLeft(), key));
        }
        else {
            node.setRight(this.insertKey(node.getRight(), key));
        }
        return node;
    }
    
    public void insertKey(int key) {
        this.root = this.insertKey(this.root, key);
    }
    
    public Integer getMinValue(TreeNode node) {
        Integer minV = 0;
        while(node != null) {
            minV = node.getData();
            node = node.getLeft();
        }
        return minV;
    }
    
    protected TreeNode deleteKey(TreeNode node, int key) {
        if(node == null) {
            return null;
        }
        else if(node.getData() < key) {
            node.setLeft(this.deleteKey(node.getLeft(), key));
        }
        else if(node.getData() > key) {
            node.setRight(this.deleteKey(node.getRight(), key));
        }
        else {
            // delete me
            // node with one child or no child
            if(node.getLeft() == null) {
                return node.getRight();
            }
            else if(node.getRight() == null) {
                return node.getLeft();
            }
            
            node.setData(this.getMinValue(node.getRight()));
            // node with two children
            node.setRight(deleteKey(node.getRight(), node.getData()));
        }
        
        return node;
    }
    
    public void deleteKey(int key) {
        this.root = this.deleteKey(this.root, key);
    }
    
    public TreeNode searchKey(TreeNode node, Integer key) {
        if(node == null || node.getData() == key) {
            return node;
        }
        else if(node.getData() < key) {
            return searchKey(node.getRight(), key);
        }
        else {
            return searchKey(node.getLeft(), key);
        }
    }
    
    public void printInOrder() {
        printInOrder(this.root);
    }
}
