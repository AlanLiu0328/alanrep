package com.lc.number;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 */
public class Convert {
    public static String convert(String s, int numRows) {
        if (s == null || "".equals(s)) return "";
        if (numRows==1){
            return s;
        }
        List<StringBuilder> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(new StringBuilder());
        }
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (index == 0 || index == numRows - 1) flag = !flag;
            result.get(index).append(s.charAt(i));

            index = index + (flag ? 1 : -1);

        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder builder : result) {
            sb.append(builder);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }
}
