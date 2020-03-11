package com.lc.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParenthesis {
    private static List<String> result;
    private static Stack<String> stack;

    public static List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        result = new ArrayList<>();
        stack = new Stack<>();
        help("", n, n);
        return result;
    }

    public static void help(String res, int n1, int n2) {
        if (n1 == 0 && n2 == 0) {
            result.add(res);
            return;
        }
        if (n1 > 0) {
            stack.add("(");
            n1--;
            help(res + "(", n1, n2);
            n1++;
            stack.pop();
        }
        if (n2 > 0) {
            if (!stack.isEmpty() && stack.peek() == "(") {
                stack.pop();
                n2--;
                help(res + ")", n1, n2);
                n2++;
                stack.add("(");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(5));
    }
}
