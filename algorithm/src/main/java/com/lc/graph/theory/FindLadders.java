package com.lc.graph.theory;

import java.util.*;

/**
 * 126
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLadders {
    private static boolean[] visited;
    private static List<List<String>> result;
    private static int count;
    private static LinkedList<String> curList;

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        visited = new boolean[n];
        result = new LinkedList<>();
        count = Integer.MAX_VALUE;
        LinkedList<String> res = new LinkedList<>();
//        visited[wordList.indexOf(beginWord)] = true;
        curList = new LinkedList<>();
        curList.addLast(beginWord);
        dfs(beginWord, endWord, wordList, 0);

        Iterator<List<String>> iterator = result.iterator();
        while (iterator.hasNext()) {
            List<String> next = iterator.next();
            if (next.size() > count + 1) {
                iterator.remove();
            }
        }
        return result;

    }

    public static void dfs(String beginWord, String endWord, List<String> wordList, int level) {
        if (level + 2 > count) return;
        for (String s : wordList) {
            if (visited[wordList.indexOf(s)]) continue;
            if (!check(s, beginWord)) continue;
            if (s.equals(endWord)) {
                curList.add(s);
                result.add(new LinkedList<>(curList));
                count = Math.min(level + 1, count);
                curList.removeLast();
                return;
            }
            curList.add(s);
            visited[wordList.indexOf(s)] = true;
            dfs(s, endWord, wordList, level + 1);
            visited[wordList.indexOf(s)] = false;
            curList.removeLast();
        }
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
        String[] wordList = new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        List<String> words = new ArrayList<>(Arrays.asList(wordList));

        System.out.println(findLadders("qa", "sq", words));
    }
}

