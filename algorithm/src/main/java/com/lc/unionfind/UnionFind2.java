package com.lc.unionfind;

public class UnionFind2 {
    private int[] parent;
    private int[] sz;
    private int count;

    public UnionFind2(int count) {
        this.count = count;
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (sz[pRoot] > sz[qRoot]) {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
    }
}
