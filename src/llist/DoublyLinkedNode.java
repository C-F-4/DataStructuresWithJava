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
public class DoublyLinkedNode extends Node {
    protected Node prev;
    DoublyLinkedNode() {
        super();
        prev = null;
    }
    DoublyLinkedNode(int data) {
        super(data);
        prev = null;
    }
    DoublyLinkedNode(int data, Node next) {
        super(data, next);
        prev = null;
    }
    DoublyLinkedNode(int data, Node next, Node prev) {
        super(data, next);
        this.prev = prev;
    }
    Node getPrev() {
        return this.prev;
    }
    void setPrev(Node prev) {
        this.prev = prev;
    }
}
