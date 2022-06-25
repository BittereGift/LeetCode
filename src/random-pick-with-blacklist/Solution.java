import java.util.Arrays;
import java.util.Random;

/*
 * @Author: Bittere_Gift 329056266@qq.com
 * @Date: 2022-06-25 19:06:53
 * @LastEditors: Bittere_Gift 329056266@qq.com
 * @LastEditTime: 2022-06-26 01:26:41
 * @FilePath: \leetcode\src\random-pick-with-blacklist\Solution.java
 * 
 * https://leetcode.cn/problems/random-pick-with-blacklist/
 */
class Solution {
    private int n;
    private int[] blacklist;
    private Random random;

    public Solution(int n, int[] blacklist) {
        //排序
        Arrays.sort(blacklist);
        this.n = n;
        this.blacklist = new int[blacklist.length];
        for (int i = 0; i < blacklist.length; i++) {
            this.blacklist[i] = blacklist[i];
        }
        random = new Random();
    }

    public int pick() {
        int pickRangeLength = n - blacklist.length;
        int randomNum = random.nextInt(pickRangeLength);
        //在blackList中寻找在0到randomNum之间的值，如果这个值是blackList中的，randomNum向后取一位
        for (int i = 0; i < blacklist.length; i++) {
            if (blacklist[i] <= randomNum) {
                randomNum++;
            } else {
                break;
            }
        }
        return randomNum;
    }
}