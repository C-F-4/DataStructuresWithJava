/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llist;

import java.util.Scanner;

/**
 *
 * @author phoenix
 */
public class LList {

    static void printLine() {
        for(int i = 0; i < 64; i++) {
            System.out.print('_');
        }
        System.out.println();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList list = new LinkedList();
        list.appendData(5);
        list.appendData(4);
        list.appendData(3);
        list.appendData(2);
        list.appendData(1);
        list.prependData(5);
        list.prependData(4);
        list.prependData(3);
        list.prependData(2);
        list.prependData(1);
        list.print();
        list.deleteAt(3);
        list.print();
        System.out.println("Deleted NodeCount: " + list.deleteData(5));
        list.print();
        System.out.println("Length: " + list.getLength());
        System.out.println("Length (Rec): " + list.getLengthR(list.getHead()));
        list.swapData(2, 3);
        list.print();
        list.reverseList();
        list.print();
        list.reverseListR();
        list.print();
        list.rotateBy(4+5*list.getLength());
        list.print();
        list.rotateBy(-(4+5*list.getLength()));
        list.print();
        if(list.joinTail()) {
            // CAUTION: Don't uncomment this!!!
            // list.print();
            if(list.loopDetector()) {
                System.out.print("After removing loop: ");
                list.print();
            }
        }
        else {
            // Dog's too busy to be chasing his tail
        }
        System.out.print("List 1: ");
        list.printNumber();
        LinkedList list_2 = new LinkedList(list);
        System.out.print("List 2: ");
        list_2.printNumber();
        LinkedList list_3 = list.addListAsNumbers(list_2.getHead());
        System.out.print("List 3: ");
        list_3.printNumber();
        
        printLine();
        
        Stack<Integer> s = new Stack<>(1);
        s.push(5);
        System.out.println("Stack Size: " + s.getCapacity());
        System.out.println("Top: " + s.peek());
        s.push(4);
        s.push(3);
        System.out.println("Popped: " + s.pop());
        s.push(0);
        System.out.println("New Top: " + s.peek());
        s.print();
        System.out.println("Stack Size: " + s.getCapacity());
        s.pop();
        System.out.println("Stack Size: " + s.getCapacity());
        s.pop();
        System.out.println("Stack Size: " + s.getCapacity());
        s.pop();
        System.out.println("Stack Size: " + s.getCapacity());
        
        printLine();
        
        String infix = "1+2*4/5-7+3/6";
        String postfix = Expression.infixToPostfix(infix);
        System.out.println(postfix + " " + Expression.evalPostfix(postfix));
        
        printLine();
        
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue.getSize());
        while(!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
        System.out.println(queue.getSize());
        
        printLine();
        
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        
        BinaryTree tree = new BinaryTree(root);
        tree.printInOrder(root);
        System.out.println();
        tree.printPreOrder(root);
        System.out.println();
        tree.printPostOrder(root);
        System.out.println();
        tree.printLevelOrderBasic();
        System.out.println();
        tree.printLevelOrder();
        System.out.println();
        System.out.println("Height of the Tree: " + tree.getHeight());
        System.out.println("Width of the Tree: " + tree.getMaxWidthBasic());
        System.out.println("Diameter of the Tree: " + tree.getDiameter());
        tree.printNDistance(root, 1);
        System.out.println();
        tree.printAncestors(root, 1);
        System.out.println();
        System.out.println(tree.isSubtree(root, tree.getRoot()));
        
        printLine();
        
        /*        50
         *      /     \
         *     30      70
         *    /  \    /  \
         *  20   40  60   80 
         */
        BinarySearchTree tree_2 = new BinarySearchTree();
        tree_2.insertKey(50);
        tree_2.insertKey(30);
        tree_2.insertKey(20);
        tree_2.insertKey(40);
        tree_2.insertKey(70);
        tree_2.insertKey(60);
        tree_2.insertKey(80);
        tree_2.printInOrder();
        System.out.println();
        tree_2.deleteKey(20);
        tree_2.printInOrder();
        System.out.println();
        tree_2.deleteKey(30);
        tree_2.printInOrder();
        System.out.println();
        tree_2.deleteKey(50);
        tree_2.printInOrder();
        System.out.println();
        System.out.println("MinValue: " + tree_2.getMinValue(tree_2.getRoot()));
        
        printLine();
        
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        Graph graph = new Graph(v);
        for (int i = 0; i < e; i++) {
            graph.addEdge(in.nextInt(), in.nextInt());
        }
        graph.printAdjacencyList();
        Graph graph_2 = new Graph(graph);
        graph_2.printAdjacencyList();
    }
    
}
