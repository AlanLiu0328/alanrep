package com.lc.graph.theory;

import com.lc.util.GNode;


public class SparseGraph {
    private int n, m;
    private boolean directed;
    private GNode[] g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new GNode[n + 1];
        for (int i = 0; i <= n; i++) {
            this.g[i] = new GNode(i);
        }
    }

    int V() {
        return n;
    }

    int E() {
        return m;
    }

    public void addEdge(int v, int w) {
        GNode p = g[v];
        while (p.next != null) p = p.next;
        p.next = new GNode(w);
        if (v != w && !directed) {
            p = g[w];
            while (p.next != null) p = p.next;
            p.next = new GNode(v);
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        GNode p = g[v];
        while (p != null) {
            if (p.id == w) {
                return true;
            }
        }
        return false;
    }


    public void printGraph(){
        for (int i = 1; i <= n; i++) {

        }
    }
}
