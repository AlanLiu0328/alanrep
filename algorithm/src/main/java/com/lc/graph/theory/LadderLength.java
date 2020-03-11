package com.lc.graph.theory;

import java.util.*;

/**
 * 127
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LadderLength {
    private static int n;
    private static boolean[] visited;
    private static LinkedList<String> queue;

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        n = wordList.size();
        if (n == 0) return 0;
        if (!wordList.contains(endWord)) return 0;
        visited = new boolean[n];
        queue = new LinkedList<>();
        queue.addLast(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String head = queue.pollFirst();
                for (int j = 0; j < wordList.size(); j++) {
                    String s = wordList.get(j);
                    if (visited[j]) {
                        continue;
                    }
                    if (!check(s, head)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    queue.addLast(s);
                    visited[j] = true;
                }
            }
        }
        return 0;
    }


    public static boolean check(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int count = 0;
        if (c1.length != c2.length) return false;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) count++;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        String[] wordList = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> words = new ArrayList<>(Arrays.asList(wordList));

        System.out.println(ladderLength("hit", "cog", words));
    }
}
