/*
 * @Author: Bittere_Gift 329056266@qq.com
 * @Date: 2022-06-27 22:06:19
 * @LastEditors: Bittere_Gift 329056266@qq.com
 * @LastEditTime: 2022-06-27 22:40:07
 * @FilePath: \leetcode\src\longest_uncommon_subsequence_ii.java
 * @Description: https://leetcode.cn/problems/longest-uncommon-subsequence-ii/
 * 
 * Copyright (c) 2022 by Bittere_Gift 329056266@qq.com, All Rights Reserved. 
 */
public class longest_uncommon_subsequence_ii {
    public int findLUSlength(String[] strs) {
         int maxLength = -1;
         boolean flag = true;
         for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubString(strs[i], strs[j])) { //一旦是SubString，就不需要考虑这一个字符串，直接跳过
                    flag = false;
                    break;
                }
            }
            if (flag) {
                maxLength = Math.max(maxLength, strs[i].length());
            }
            flag = true;
         }
         return maxLength;
    }

    public boolean isSubString(String str1, String str2) {
        int i = 0;
        int j = 0;
        while (true) {
            if (i >= str1.length() || j >= str2.length()) { //读取完毕，跳出循环
                break;
            }
            if (str1.charAt(i) == str2.charAt(j)) { //如果二者相等，两个指针都向后移一位，否则只移动其中之一
                i++;
            }
            j++;
        }
        return i == str1.length(); //i指针一定在j指针之后，如果i指针已经指到最后，说明这两者是SubString的关系
    }
}
