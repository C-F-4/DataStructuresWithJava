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
public class Node {
    protected int data;
    protected Node next;
    
    Node() {
        this.data = Integer.MIN_VALUE;
        this.next = null;
    }
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
    
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    
    int getData() {
        return this.data;
    }
    
    Node getNext() {
        return this.next;
    }
    
    void setData(int data) {
        this.data = data;
    }
    
    void setNext(Node next) {
        this.next = next;
    }
}