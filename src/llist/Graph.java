/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;
/**
 *
 * @author phoenix
 */
public class Graph {
    /**
     * total number of vertices in the graph
     */
    protected Integer v;

    /**
     * number of edges in the graph
     */
    protected Integer e;

    /**
     * Adjacency List
     */
    protected LinkedList<Integer>[] bag;

    /**
     * Initializes the Graph Object with default values
     */
    public Graph() {
        this.v = 0;
        this.e = 0;
        this.bag = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.bag[i] = new LinkedList<>();
        }
    }

    /**
     * Initializes the Graph Object and LinkedList bag with v empty LinkedLists
     * @param vertex
     * @throws IllegalArgumentException if vertex argument is negative
     */
    public Graph(int vertex) {
        if (vertex < 0) {
            throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
        }
        this.v = vertex;
        this.e = 0;
        this.bag = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.bag[i] = new LinkedList<>();
        }
    }

    /**
     * Initializes the Graph Object using Scanner Object
     * Need modifications so that file read can be handled
     * @throws IllegalArgumentException if vertex input is negative
     * @throws IndexOutOfBoundsException if v is invalid
     * @param in Scanner Object
     */
    public Graph(Scanner in) {
        int vertex = in.nextInt();
        if (vertex < 0) {
            throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
        }
        this.v = vertex;
        int edge = in.nextInt();
        this.e = 0;
        this.bag = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.bag[i] = new LinkedList<>();
        }
        for (int i = 0; i < edge; i++) {
            this.addEdge(in.nextInt(), in.nextInt());
        }
    }
    
    /**
     * Initializes a new graph that is a deep copy of {@code G}.
     *
     * @param  G the graph to copy
     */
    public Graph(Graph G) {
        this.v = G.getVertexCount();
        this.e = G.getEdgeCount();
        for (int i = 0; i < G.getVertexCount(); i++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<>();
            for (int w : G.getAdjListOf(i)) {
                reverse.push(w);
            }
            for (Integer w : reverse) {
                this.bag[i].add(w);
            }
        }
    }

    /**
     * Creates a two-way Edge between Vertex a with Vertex b
     * @param a Vertex 1
     * @param b Vertex 2
     * @throws IndexOutOfBoundsException if a or b is invalid
     */
    public void addEdge(int a, int b) {
        validateVertex(a);
        validateVertex(b);
        bag[a].add(b);
        bag[b].add(a);
        this.e++;
    }

    /**
     *
     * @return number of vertices in the Graph
     */
    public Integer getVertexCount() {
        return this.v;
    }

    /**
     *
     * @return number of edges in the Graph
     */
    public Integer getEdgeCount() {
        return this.e;
    }

    /**
     * Degree of a Graph : Number of directly connected nodes to vertex v
     * @param v a valid vertex in the graph
     * @throws IndexOutOfBoundsException if v is invalid
     * @return degree of vertex v
     */
    public Integer getDegree(int v) {
        validateVertex(v);
        return bag[v].size();
    }

    /**
     *
     * @param v
     * @return Adjacency List for the Vertex v
     */
    /*public Object[] getAdjListOf(int v) {
        validateVertex(v);
        return bag[v].toArray();
    }
    */
    
    /**
     *
     * @param v
     * @throws IndexOutOfBoundsException if v is invalid
     * @return Iterable &lt;Integer&gt; Adjacency List for the Vertex v
     */
    public Iterable<Integer> getAdjListOf(int v) {
        validateVertex(v);
        return bag[v];
    }

    /**
     * Validates whether v is a valid vertex or not
     * @param v 
     * @throws IndexOutOfBoundsException if v is invalid
     */
    protected void validateVertex(int v) {
        if (v < 0 || v >= this.v) {
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (v - 1));
        }
    }
    
    /**
     * Prints the Graph in the form of Adjacency List
     */
    public void printAdjacencyList() {
        for (int i = 0; i < this.v; i++) {
            System.out.println(i + " : " + Arrays.toString(bag[i].toArray()));
        }
    }

    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices v, followed by the number of edges e,
     * followed by the v adjacency lists
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(v).append(" vertices, ").append(e).append(" edges ").append(System.getProperty("line.separator"));
        for (int i = 0; i < v; i++) {
            s.append(i).append(": ");
            for (Iterator<Integer> it = bag[i].iterator(); it.hasNext();) {
                int w = it.next();
                s.append(w).append(" ");
            }
            s.append(System.getProperty("line.separator"));
        }
        return s.toString();
    }
}
