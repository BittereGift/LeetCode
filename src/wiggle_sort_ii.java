import java.util.Arrays;

/*
 * @Author: Bittere_Gift 329056266@qq.com
 * @Date: 2022-06-28 21:36:12
 * @LastEditors: Bittere_Gift 329056266@qq.com
 * @LastEditTime: 2022-06-28 22:32:09
 * @FilePath: \leetcode\src\wiggle_sort_ii.java
 * @Description: https://leetcode.cn/problems/wiggle-sort-ii/
 * 
 * Copyright (c) 2022 by Bittere_Gift 329056266@qq.com, All Rights Reserved. 
 */
public class wiggle_sort_ii {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }
}
