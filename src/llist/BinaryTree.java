/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llist;

import java.util.Queue;
import java.util.LinkedList;
/**
 *
 * @author phoenix
 */
public class BinaryTree {
    TreeNode root;
    
    BinaryTree() {
        this.root = null;
    }
    
    BinaryTree(TreeNode root) {
        this.root = root;
        this.root = this.copy(root);
    }
    
    protected final TreeNode copy(TreeNode node) {
        TreeNode left = null;
        TreeNode right = null;
        if(node != null) {
            if(node.getLeft() != null) {
                left = this.copy(node.getLeft());
            }
            if(node.getRight() != null) {
                right = this.copy(node.getRight());
            }
            return new TreeNode(node.getData(), left, right);
        }
        else {
            return null;
        }
    }
    
    public boolean areCopies(TreeNode a, TreeNode b) {
        if(a == null && b == null) {
            return true;
        }
        else if(a == null || b == null) {
            return false;
        }
        else {
            return (a.getData() == b.getData()) &&
                    this.areCopies(a.getLeft(), b.getLeft()) &&
                    this.areCopies(a.getRight(), b.getRight());
        }
    }
    
    public boolean isSubtree(TreeNode a, TreeNode b) {
        if(b == null) {
            return true;
        }
        else if(a == null) {
            return false;
        }
        else if(areCopies(a, b)) {
            return true;
        }
        else {
            return (this.isSubtree(a.left, b) ||
                    this.isSubtree(a.right, b));
        }
    }
    
    public TreeNode getRoot() {
        return this.root;
    }
    
    protected Integer getHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }
        else {
            Integer l_height = getHeight(node.getLeft());
            Integer r_height = getHeight(node.getRight());
            return (l_height > r_height) ? (l_height + 1) : (r_height + 1);
        }
    }
    
    public Integer getHeight() {
        return this.getHeight(this.root);
    }
    
    protected Integer getDiameter(TreeNode node) {
        if(node == null) {
            return 0;
        }
        else {
            Integer l_height = getHeight(node.getLeft());
            Integer r_height = getHeight(node.getRight());
            
            Integer l_diameter = this.getDiameter(node.getLeft());
            Integer r_diameter = this.getDiameter(node.getRight());
            
            return Math.max(l_height + r_height + 1,
                    Math.max(l_diameter, r_diameter));
        }
    }
    
    public Integer getDiameter() {
        return this.getDiameter(this.root);
    }
    
    public Integer getMaxWidthBasic() {
        int h = this.getHeight();
        Integer max_width = 0;
        for(int i = 1; i <= h; i++) {
            Integer width = this.printLevel(this.root, i);
            if(width > max_width) {
                max_width = width;
            }
        }
        return max_width;
    }
    
    public void printInOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        this.printInOrder(node.getLeft());
        System.out.print(node.getData() + " ");
        this.printInOrder(node.getRight());
    }
    
    public void printPreOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        this.printPreOrder(node.getLeft());
        this.printPreOrder(node.getRight());
    }
    
    public void printPostOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        this.printPostOrder(node.getLeft());
        this.printPostOrder(node.getRight());
        System.out.print(node.getData() + " ");
    }
    
    public Integer printLevel(TreeNode node, int level) {
        if(node == null) {
            return 0;
        }
        else if(level == 1) {
            System.out.print(node.getData() + " ");
            return 1;
        }
        else if(level > 1) {
            return (this.printLevel(node.getLeft(), level - 1) +
                    this.printLevel(node.getRight(), level - 1));
        }
        return 0;
    }
    
    public void printLevelOrderBasic() {
        Integer h = this.getHeight();
        for(int i = 1; i <= h; i++) {
            this.printLevel(this.root, i);
        }
    }
    
    public void printLevelOrder() {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tmp = this.root;
        while(tmp != null) {
            System.out.print(tmp.getData() + " ");
            queue.add(tmp.getLeft());
            queue.add(tmp.getRight());
            tmp = queue.poll();
        }
    }
    
    public void printNDistance(TreeNode node, int dist) {
        if(node == null) {
        }
        else if(dist == 0) {
            System.out.print(node.getData() + " ");
        }
        else {
            this.printNDistance(node.getLeft(), dist - 1);
            this.printNDistance(node.getRight(), dist - 1);
        }
    }
    
    public boolean printAncestors(TreeNode node, int key) {
        if(node == null) {
            return false;
        }
        if(node.getData() == key) {
            if(this.root.getData() == key) {
                System.out.println("Root doesn't have a parent");
            }
            return true;
        }
        if(printAncestors(node.getLeft(), key) || 
           printAncestors(node.getRight(), key)) {
            System.out.println(node.getData() + " ");
            return true;
        }
        return false;
    }
}
