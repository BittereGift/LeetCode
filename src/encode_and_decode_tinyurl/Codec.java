/*
 * @Author: Bittere_Gift 329056266@qq.com
 * @Date: 2022-06-29 22:02:36
 * @LastEditors: Bittere_Gift 329056266@qq.com
 * @LastEditTime: 2022-06-29 22:52:27
 * @FilePath: \leetcode\src\encode_and_decode_tinyurl\Codec.java
 * @Description: https://leetcode.cn/problems/encode-and-decode-tinyurl/
 * 
 * Copyright (c) 2022 by Bittere_Gift 329056266@qq.com, All Rights Reserved. 
 */
package encode_and_decode_tinyurl;

import java.util.HashMap;
import java.util.Map;

public class Codec {
    private Map<Integer, String> urlDataBase = new HashMap<>();
    private int id = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urlDataBase.put(id, longUrl);
        id++;
        return "http://tinyurl.com/" + id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(index));
        return urlDataBase.get(key);
    }
}
