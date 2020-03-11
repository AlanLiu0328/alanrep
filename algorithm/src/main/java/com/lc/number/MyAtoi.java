package com.lc.number;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 8 字符串转化数字
 */
public class MyAtoi {

    public static int myAtoi2(String str) {
        if (str == null) return 0;
        str = str.trim();
        if ("".equals(str)) return 0;

        if (str.charAt(0) != '+' && str.charAt(0) != '-' && (str.charAt(0) < '0' || str.charAt(0) > '9')) {
            return 0;
        }
        Pattern p = Pattern.compile("[+-]?\\d+");
        Matcher m = p.matcher(str);
        if (m.find()) {
            String s = m.group();
            Long l = Long.valueOf(s);
            if (l < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (l > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.parseInt(String.valueOf(l));
            }

        }
        return 0;
    }


    public static int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if ("".equals(str)) return 0;

        if (str.charAt(0) != '+' && str.charAt(0) != '-' && (str.charAt(0) < '0' || str.charAt(0) > '9')) {
            return 0;
        }

        boolean flag = true;
        int index = 0;
        if (str.charAt(0) == '+') {
            flag = true;
            index = 1;
        } else if (str.charAt(0) == '-') {
            flag = false;
            index = 1;
        }
        int result = 0;
        while (index < str.length()) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9')
                break;
            int n = str.charAt(index) - '0';
            if (flag && (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && n > 7)) {
                return Integer.MAX_VALUE;
            }
            if (!flag && (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && n > 8)) {
                return Integer.MIN_VALUE;
            }
            result = 10 * result + n;
            index++;
        }
        return flag ? result : -1 * result;
    }


    public static void main(String[] args) {
        System.out.println(myAtoi2(" 12345"));
    }
}
