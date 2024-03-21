package com.xzs.exam.configuration.property;

public class CookieConfig {

    /**
     * 获取名称
     * @return name
     */
    public static String getName() {
        return "LearnTextSystem";
    }

    /**
     * 获取最大区间
     * @return interval
     */
    public static Integer getInterval() {
        return 30 * 24 * 60 * 60;
    }
}
