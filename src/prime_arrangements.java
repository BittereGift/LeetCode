/*
 * @Author: Bittere_Gift 329056266@qq.com
 * @Date: 2022-06-30 21:54:35
 * @LastEditors: Bittere_Gift 329056266@qq.com
 * @LastEditTime: 2022-06-30 21:57:29
 * @FilePath: \leetcode\src\prime_arrangements.java
 * @Description: https://leetcode.cn/problems/prime-arrangements/submissions/
 * 
 * Copyright (c) 2022 by Bittere_Gift 329056266@qq.com, All Rights Reserved. 
 */
public class prime_arrangements {
    public int numPrimeArrangements(int n) {
        int sum = 0;
        if (n > 2){
            sum = fun(n);
        }else {
            return 1;
        }
        long cur = 1L;
        for (int i = 2;i <= sum; i++){
            cur = (cur * i) % (1000000000 + 7);
        }
        for (int i = 2;i <= n - sum; i++){
            cur = (cur * i) % (1000000000 + 7);
        }
        return (int)cur;
    }

    public int fun (int n){
        n += 1;
        int sum = 0;
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2;i < n; i++){
            if (isPrime[i] == false){
                sum ++;
                for (int j = 2; j*i < n; j++) {
                    isPrime[j*i] = true;
                }
            }
        }
        return sum;
    }
}
