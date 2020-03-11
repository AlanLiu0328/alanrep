package com.lc.util;

import com.lc.graph.theory.SparseGraph;

import java.io.*;

public class ReadGraph {
    public static SparseGraph createGraph(String file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
        String firstLine = reader.readLine();
        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int m = Integer.parseInt(firstLine.split(" ")[1]);
        SparseGraph graph = new SparseGraph(n, false);

        for (int i = 0; i < m; i++) {
            String line = reader.readLine();
            int v = Integer.parseInt(line.split(" ")[0]);
            int w = Integer.parseInt(line.split(" ")[1]);
            graph.addEdge(v,w);
        }

        return graph;
    }


    public static void main(String[] args) throws Exception {
        createGraph("F:\\GIT_CODE\\Data-Structures\\algorithm\\src\\main\\java\\com\\lc\\graph\\theory\\g1.txt");
    }
}
