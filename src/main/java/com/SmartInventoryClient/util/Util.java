package com.SmartInventoryClient.util;

public class Util {
    public static Integer convertToNumber(String value){
        if (value!=null){
            if ( (value.split(" ").length>0) && isDigit(value.split(" ")[0].trim()))
            {
                Integer v = Integer.parseInt(value.split(" ")[0]);
                return v;
            }
        }
        return 0;
    }
    private static boolean isDigit(String s) {
        return s.matches("[0-9]*");
    }
}
