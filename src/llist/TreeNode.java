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
public class TreeNode {
    protected int data;
    protected TreeNode left;
    protected TreeNode right;
    
    TreeNode() {
        this.data = Integer.MIN_VALUE;
        this.left = null;
        this.right = null;
    }
    
    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    TreeNode(int data, TreeNode left) {
        this.data = data;
        this.left = left;
        this.right = null;
    }
    
    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    int getData() {
        return this.data;
    }
    
    TreeNode getLeft() {
        return this.left;
    }
    
    TreeNode getRight() {
        return this.right;
    }
    
    void setData(int data) {
        this.data = data;
    }
    
    void setLeft(TreeNode left) {
        this.left = left;
    }
    
    void setRight(TreeNode right) {
        this.right = right;
    }
}
