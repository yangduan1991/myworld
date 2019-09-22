package com.yangduan.dorian.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangduan
 * leetcode no.3. 给定一个字符串，找出其中不含有重复字符的 最长子串 的长度。
 */
public class UnduplicatedSubString {

    public int lengthOfLongestSubstring(String s) {
        if (null == s) {
            return 0;
        }
        if(s.length() < 2) {
            return s.length();
        }
        int i = 0, j = 0, max = 1, index = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        while (i < s.length()) {
            j ++;

            if(j >= s.length()) {
                break;
            }
            if(!map.containsKey(s.charAt(j))) {
                int temp = j - i + 1;
                if(temp > max) {
                    max = temp;
                    index = i;
                }
                map.put(s.charAt(j), j);
            } else {
                i = map.get(s.charAt(j)) + 1;
                j = i;
                map.clear();
                map.put(s.charAt(i), i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbbcbabacbacbabcsbjkcsdsdbvdadqkjscscsdfhuwergtjhsbca";
        UnduplicatedSubString solution = new UnduplicatedSubString();
        int len = solution.lengthOfLongestSubstring(s);
        System.out.print(len);
    }

}
