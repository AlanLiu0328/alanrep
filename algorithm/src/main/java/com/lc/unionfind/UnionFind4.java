package com.lc.unionfind;

public class UnionFind4 {
    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFind4(int count) {
        this.count = count;
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /*public int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }*/

    /**
     * 路径压缩
     * @param p
     * @return
     */
    public int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }


    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] = Math.max(qRoot, 1 + pRoot);
        }
    }
}
