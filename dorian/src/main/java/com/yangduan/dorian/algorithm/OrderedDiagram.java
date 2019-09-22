package com.yangduan.dorian.algorithm;

import java.util.*;

public class OrderedDiagram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, ArrayList<Integer>> diagram = new HashMap<>();

        for(int i = 0; i < m; i++) {
            int first = scanner.nextInt();
            int last = scanner.nextInt();
            if (diagram.containsKey(first)) {
                diagram.get(first).add(last);
            } else {
                diagram.put(first, new ArrayList<Integer>(){{add(last);}});
            }
        }

        Set<String> set = new HashSet<>();
        for (Integer node : diagram.keySet()) {
            StringBuilder sb = new StringBuilder(node);
            int key = node;
            for(int i = 1; i < n; i ++) {
                if (!diagram.containsKey(key) || !diagram.get(key).contains(key)) {
                    break;
                }
                for(int value: diagram.get(key)) {
                    sb.append(value);
                }
            }
        }


    }

    private static void traverse(Map<Integer, ArrayList<Integer>> diagram){

    }

}
