package com.qingao.hello;

/**
 * Created by qingao on 2016/11/30.
 */
public class Utils {
    private Utils(){}
    public static String generateGetSMSRedisKey(String phone,int type) {
        return String.format("#%s_@%d",phone,type);
    }
}
