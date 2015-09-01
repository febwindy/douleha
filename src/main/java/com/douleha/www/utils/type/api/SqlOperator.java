package com.douleha.www.utils.type.api;

/**
 * Created by ivan_ on 2015/9/1.
 */
public class SqlOperator {

    /**
     * like运算 % 添加
     * @param s
     * @param l
     * @return
     */
    public static String like(String s, Like l) {

        StringBuilder sb = new StringBuilder();
        switch (l) {
            case LEFT:
                sb.append("%")
                        .append(s);
                break;
            case RIGHT:
                sb.append(s)
                        .append("%");
                break;
            case ANYWHERE:
                sb.append("%")
                        .append(s)
                        .append("%");
                break;
        }

        return sb.toString();
    }

    public enum Like {
        LEFT,
        RIGHT,
        ANYWHERE;
    }
}
