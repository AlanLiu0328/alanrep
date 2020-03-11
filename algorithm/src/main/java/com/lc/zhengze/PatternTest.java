package com.lc.zhengze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[+-]?\\d+");
        Matcher m = p.matcher("-11324324324afafdasf");
        boolean b = m.find();
        String group;
        if (b) {
            group = m.group();
            System.out.println(group);
            Integer result = Integer.valueOf(group);
            System.out.println(result);

        }


    }
}
