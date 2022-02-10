package com.truongtd.bookstore.infrastructure.utils;

import org.springframework.util.StringUtils;

public class NumericUtils {

    /**
     * check input is number
     * @param str
     * @return
     */
    public static boolean checkNumeric(String str) {
        if (!StringUtils.isEmpty(str)) {
            if (str.matches("[0-9]+")) {
                return true;
            }
        }
        return false;
    }
}
