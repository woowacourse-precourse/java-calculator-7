package calculator.controller;

import java.util.Arrays;

public class Divider {

    public String[] spliter(String str, char de) {
        String[] strArray;
        String newStr;
        if (str.startsWith("/")) {
            newStr = str.substring(5);
        } else if (str.isEmpty()){
            newStr = "0";
        } else {
            newStr  = str.replace(":", ",");
        };

        strArray = newStr.split(String.valueOf(de));
//        System.out.println(Arrays.toString(strArray));
        return strArray;
    }

    public int[] strToNum(String[] strArray) {
        int[] numArray = new int[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            try { numArray[i] = Integer.parseInt(strArray[i]);
//                System.out.println(numArray[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자가 잘못되었습니다.");
            }

        }
        return numArray;
    }
}
