package com.lc.graph.theory;

public class DenseGraph {
    private int n, m;
    private boolean directed;
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

    public void addEdge(int v, int w) {
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        return g[v][w];
    }
}
