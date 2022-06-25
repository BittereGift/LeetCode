/*
 * @Author: Bittere_Gift 329056266@qq.com
 * @Date: 2022-06-25 19:06:53
 * @LastEditors: Bittere_Gift 329056266@qq.com
 * @LastEditTime: 2022-06-25 19:51:53
 * @FilePath: \leetcode\src\paint_house.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * 
 * https://leetcode.cn/problems/JEj789/
 */
public class paint_house {
    /*
     * 经典的动态规划问题，我们可以引入一个dp数组，第一组的数据就是正常的价格，而后面的每一个房子的每一种颜色都去找到前面的不是相同颜色的房子里面的最低价钱，然后相加，存放到dp中
     * 因为我们不会对后面的数据进行修改，所以我们可以直接覆盖原来的数组，这样就减少了一个dp的内存消耗，耗时也会减少
     */
    public int minCost(int[][] costs) {
        for (int i = 0; i < costs.length; i++) {
            if (i != 0) {
                costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
                costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
                costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
            }
        }

        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
}