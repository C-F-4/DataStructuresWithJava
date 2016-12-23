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
public class Stack<T extends Object> {
    protected T[] array;
    protected Integer top;
    protected Integer capacity;
    
    Stack() {
        this.capacity = 1;
        this.array = (T[])new Object[this.capacity];
        this.top = -1;
    }
    
    Stack(Integer capacity) {
        this.capacity = capacity;
        this.array = (T[])new Object[this.capacity];
        this.top = -1;
    }
    
    boolean isFull() {
        return this.top == this.capacity - 1;
    }
    
    boolean isEmpty() {
        return this.top == -1;
    }
    
    boolean push(T data) {
        if(this.isFull()) {
            // System.err.println("Err: Stack is full.");
            // return false;
            this.capacity = this.capacity * 2;
            T[] tmp = (T[])new Object[this.capacity];
            System.arraycopy(this.array, 0, tmp, 0, this.array.length);
            this.array = tmp;
        }
        this.array[++this.top] = data;
        return true;
    }
    
    T pop() {
        if(this.isEmpty()) {
            return null;
        }
        // Do This
        /*if(this.top < this.capacity / 2) {
            this.capacity = this.capacity / 2;
            T[] tmp = (T[])new Object[this.capacity];
            System.arraycopy(this.array, 0, tmp, 0, this.top);
            this.array = tmp;
        }*/
        return this.array[top--];
    }
    
    T peek() {
        if(this.isEmpty()) {
            return null;
        }
        return this.array[top];
    }
    
    Integer getCapacity() {
        return this.capacity;
    }
    
    void print() {
        if(this.isEmpty()) {
            System.err.println("Err: Stack is empty");
            return;
        }
        for(int i = this.top; i >= 0; i--) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
}
