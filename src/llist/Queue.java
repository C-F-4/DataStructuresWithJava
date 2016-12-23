/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llist;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *
 * @author phoenix
 */
public class Queue {
    protected Integer front;
    protected Integer rear;
    protected Integer size;
    protected Integer capacity;
    protected Integer[] array;
    
    Queue() {
        this.capacity = 1;
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        array = new Integer[capacity];
    }
    
    Queue(Integer capacity) {
        this.capacity = capacity;
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        array = new Integer[capacity];
    }
    
    boolean isFull() {
        return this.front == 0 && this.rear == this.capacity - 1;
        // or return this.size == this.capacity;
    }
    
    boolean isEmpty() {
        return this.front == -1;
        // or return this.size == 0;
    }
    
    public void enqueue(Integer data) {
        if(this.isFull()) {
            System.err.print("Err: Overflow. Queue is full.");
        }
        else {
            if(this.rear == -1) {
                this.front = 0;
            }
            this.array[++this.rear] = data;
            this.size ++;
        }
    }
    
    public Integer dequeue() {
        if(this.isEmpty()) {
            throw new NoSuchElementException("Underflow Exception");
        }
        else {
            this.size --;
            Integer popped = this.array[this.front];
            if(Objects.equals(this.front, this.rear)) {
                this.front = this.rear = -1;
            }
            else {
                this.front ++;
            }
            return popped;
        }
    }
    
    public Integer peek() {
        if(isEmpty()) {
            throw new NoSuchElementException("Underflow Exception");
        }
        return this.array[front];
    }
    
    public Integer getSize() {
        return this.size;
    }
    
    public Integer getFront() {
        return this.peek();
    }
    
    public Integer getRear() {
        if(this.isEmpty()) {
            throw new NoSuchElementException("Underflow Exception");
        }
        return this.array[rear];
    }
    
    public void print() {
        if(this.size == 0) {
            System.err.print("Err: Queue is empty");
        }
        else {
            for(int i = front; i <= rear; i++) {
                System.out.print(this.array[i] + " ");
            }
        }
        System.out.println();
    }
}
