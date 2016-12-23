/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llist;

/**
 *
 * @author phoenix
 * DO THIS: 11, 12, 13, 17
 */
public class LinkedList {
    protected Node head;
    
    LinkedList() {
        this.head = null;
    }
    
    LinkedList(Node head) {
        this.head = head;
    }
    
    LinkedList(LinkedList l) {
        Node beg = l.getHead();
        this.head = null;
        while(beg != null) {
            if(this.head == null) {
                this.head = new Node(beg.getData(), null);
            }
            else {
                this.appendData(beg.getData());
            }
            beg = beg.getNext();
        }
    }
    
    void prependData(int data) {
        Node new_node = new Node(data, this.head);
        this.head = new_node;
    }
    
    boolean insertAfter(Node a, int data) {
        Node new_node = new Node(data);
        Node tmp = this.head;
        if(a == null && tmp == null) {
            this.head = new_node;
            return true;
        }
        else if(a == null && tmp != null) {
            System.err.println("Err: Previous Node reference is null, while list is not null");
            return false;
        }
        else if(a != null) {
            // found or not found
            while(tmp != a && tmp != null) {
                tmp = tmp.getNext();
            }
            if(tmp == a) {
                new_node.setNext(a.getNext());
                tmp.setNext(new_node);
                return true;
            }
            else if(tmp == null) {
                System.err.print("Err Insert: Previous Node Not found");
                return false;
            }
        }
        // Do This
        // unreachable case. Modify code for else if(tmp == null)
        return false;
    }
    
    final void appendData(int data) {
        Node tmp = this.head;
        Node new_node = new Node(data);
        if(tmp == null) {
            this.head = new_node;
        }
        else {
            while(tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(new_node);
        }
    }
    
    boolean deleteAt(int pos) {
        Node tmp = this.head;
        if(tmp == null) {
            System.err.println("Err Delete: Empty List.");
            return false;
        }
        else if(pos < 0) {
            System.err.println("Err Delete: Position can't be negative.");
            return false;
        }
        else if(pos == 0) {
            this.head = this.head.getNext();
            tmp.setNext(null);
            return true;
        }
        else {
            // Iterating to the previous of node to be deleted
            for(int i = 0; i < pos - 1 && tmp != null; i++) {
                tmp = tmp.getNext();
            }
            // if node to be deleted is null or position is invalid
            if(tmp == null || tmp.getNext() == null) {
                System.err.println("Err Delete: Invalid Position given.");
                return false;
            }
            else {
                Node del_ptr = tmp.getNext();
                tmp.setNext(del_ptr.getNext());
                del_ptr.setNext(null);
                return true;
            }
        }
    }
    
    int deleteData(int key) {
        Node tmp = this.head;
        Node prev = null;
        int count = 0;
        while(tmp != null) {
            if(tmp.getData() == key) {
                // delete me
                if(tmp == this.head) {
                    this.head = this.head.getNext();
                    tmp.setNext(null);
                    tmp = this.head;
                    prev = null;
                }
                else {
                    prev.setNext(prev.getNext().getNext());
                    tmp = tmp.getNext();
                }
                count ++;
            }
            else {
                if(prev == null) {
                    prev = this.head;
                }
                else {
                    prev = prev.getNext();
                }
                tmp = tmp.getNext();
            }
        }
        return count;
    }
    
    boolean deleteHead() {
        if(this.head == null) {
            return false;
        }
        else {
            Node tmp = this.head;
            this.head = this.head.getNext();
            tmp.setNext(null);
            return true;
        }
    }
    
    /*
     * Assumes there are no reps of x and y.
     * In case of reps it'll swap first found x and y.
     */
    boolean swapData(int x, int y) {
        if(x == y) {
            System.err.println("Err(Log): x and y are same. No swap done.");
            return false;
        }
        
        // Searching for x
        Node prevX = null, currX = this.head;
        while(currX != null && currX.getData() != x) {
            prevX = currX;
            currX = currX.getNext();
        }
        
        if(currX == null) {
            System.err.println("Err: First key not found.");
            return false;
        }
        // Searching for y
        Node prevY = null, currY = this.head;
        while(currY != null && currY.getData() != y) {
            prevY = currY;
            currY = currY.getNext();
        }
        
        if(currY == null) {
            System.err.println("Err: Second key not found.");
            return false;
        }
        
        // cuz for head node previous is null
        // if x is not head node
        if(prevX != null) {
            prevX.setNext(currY);
        }
        else {
            this.head = currY;
        }
        
        // if y is not head node
        if(prevY != null) {
            prevY.setNext(currX);
        }
        else {
            this.head = currX;
        }
        
        // swap next Nodes
        Node tmp = currX.getNext();
        currX.setNext(currY.getNext());
        currY.setNext(tmp);
        
        return true;
    }
    
    void reverseList() {
        Node curr = this.head;
        Node prev = null;
        Node next;
        
        while(curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        
        this.head = prev;
    }
    
    void reverseUtil(Node prev, Node curr) {
        if(curr == null) {
            return;
        }
        else if(curr.getNext() == null) {
            this.head = curr;
            curr.setNext(prev);
            return;
        }
        else {
            Node next = curr.getNext();
            curr.setNext(prev);
            this.reverseUtil(curr, next);
        }
    }
    
    void reverseListR() {
        reverseUtil(null, this.head);
    }
    
    // Clockwise
    void rotateByPUtil(int k) {
        Node curr = head;
        for(int count = 1; count < k; count ++) {
            curr = curr.getNext();
        }
        
        Node kNode = curr;
        
        while(curr.getNext() != null) {
            curr = curr.getNext();
        }
        
        curr.setNext(this.head);
        this.head = kNode.getNext();
        kNode.setNext(null);
    }
    
    // Do This
    // Counter Clockwise
    void rotateByNUtil(int k) {
    }
    
    void rotateBy(int k) {
        int l = this.getLength();
        if(k == 0) {
            return;
        }
        else if(k > 0) {
            // rotateBy k
            while(k > l) {
                k -= l;
            }
            this.rotateByPUtil(k);
        }
        else {
            // rotateBy -k
            if(-k > l) {
                int tmp = -k;
                while(tmp > l) {
                    tmp -= l;
                }
                k = -tmp;
            }
            this.rotateByNUtil(k);
        }
    }
    
    boolean joinTail() {
        if(head == null) {
            return false;
        }
        Node last = this.getLast();
        if(last == null) {
            return false;
        }
        last.setNext(this.head);
        return true;
    }
    
    // Optimize Do This
    /*
     * Utility function to remove loop
     */
    void removeLoop(Node loop_node, Node curr) {
        Node ptr1 = curr,
             ptr2 = null;
        while(true) {
            ptr2 = loop_node;
            // First condition to run just once for each Node in the loop
            // Second condition checks if it's where the loop started
            while(ptr2.getNext() != loop_node && ptr2.getNext() != ptr1) {
                ptr2 = ptr2.getNext();
            }
            if(ptr2.getNext() == ptr1) {
                break;
            }
            ptr1 = ptr1.getNext();
        }
        ptr2.setNext(null);
    }
    
    boolean loopDetector() {
        Node turtle = this.head,
             rabbit = this.head;
        while(turtle != null && rabbit != null && rabbit.getNext() != null) {
            turtle = turtle.getNext();
            rabbit = rabbit.getNext().getNext();
            
            if(turtle == rabbit) {
                removeLoop(turtle, this.head);
                return true;
            }
        }
        return false;
    }
    
    /*
     * First List:   1 > 5 > 9 > 4
     * Second List:  5 > 5 > 2
     * Returns:      6 > 0 > 2 > 5 
     */
    LinkedList addListAsNumbers(Node second) {
        LinkedList new_num = new LinkedList();
        int carry = 0, 
            sum;
        Node first = this.head;
        
        while(first != null || second != null) {
            sum = carry + (first != null ? first.getData() : 0)
                        + (second != null ? second.getData() : 0);
            
            carry = (sum > 9) ? 1 : 0;
            sum %= 10;
            new_num.appendData(sum);
            
            if(first != null) {
                first = first.getNext();
            }
            if(second != null) {
                second = second.getNext();
            }
        }
        
        if(carry > 0) {
            new_num.appendData(carry);
        }
        
        return new_num;
    }
    
    Node getHead() {
        return this.head;
    }
    
    Node getLast() {
        Node tmp = this.head;
        if(tmp == null) {
            return null;
        }
        while(tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        return tmp;
    }
    
    int getLength() {
        int count = 0;
        Node tmp = this.head;
        while(tmp != null) {
            count ++;
            tmp = tmp.getNext();
        }
        return count;
    }
    
    int getLengthR(Node tmp) {
        if(tmp == null) {
            return 0;
        }
        else {
            return 1 + this.getLengthR(tmp.getNext());
        }
    }
    
    void print() {
        Node tmp = this.head;
        if(tmp == null) {
            System.err.println("Err Print: Empty List");
        }
        else {
            while(tmp.getNext() != null) {
                System.out.print(tmp.getData() + " -> ");
                tmp = tmp.getNext();
            }
            System.out.println(tmp.getData());
        }
    }
    
    void printNumber() {
        Node tmp = this.head;
        if(tmp == null) {
            System.err.println("Err Print: Empty List");
        }
        else {
            while(tmp.getNext() != null) {
                System.out.print(tmp.getData());
                tmp = tmp.getNext();
            }
            System.out.println(tmp.getData());
        }
    }
}