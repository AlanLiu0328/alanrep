package com.lc.number;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TransNumber {
    public static void trans(){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine().substring(2);
            System.out.println(Integer.parseInt(str,16));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i =0;i<n;i++){
            String line = in.nextLine();
            String[] nums = line.split(" ");
            int key = Integer.valueOf(nums[0]);
            int value = Integer.valueOf(nums[1]);
            int sum = 0;
            if (map.containsKey(key)){
                sum = map.get(key);
            }
            map.put(key,sum+value);
        }
        map.entrySet().stream().forEach(e->{
            System.out.println(e.getKey()+" "+e.getValue());
        });
    }
}
