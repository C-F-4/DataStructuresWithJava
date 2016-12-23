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
public class DiGraph extends Graph {
    protected Integer[] indegree;
    
    public DiGraph(int v) {
        super(v);
        indegree = new Integer[v];
    }
    
    @Override
    public void addEdge(int a, int b) {
        validateVertex(a);
        validateVertex(b);
        bag[a].add(b);
        indegree[b] ++;
        this.e++;
    }
    
    public int outdegree(int v) {
        validateVertex(v);
        return this.bag[v].size();
    }
    
    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }
    
    public DiGraph reverse() {
        DiGraph reverse = new DiGraph(this.v);
        for (int i = 0; i < this.v; i++) {
            for (int w : getAdjListOf(i)) {
                reverse.addEdge(w, i);
            }
        }
        return reverse;
    }

}
