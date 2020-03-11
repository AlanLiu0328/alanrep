package com.lc.util;

public class GNode {
    public int id;
    public GNode next;

    public GNode(int id, GNode next) {
        this.id = id;
        this.next = next;
    }

    public GNode(int id) {
        this.id = id;
    }

    public GNode() {
    }
}
