package calculator.controller;

public class Divider {

    public String[] spliter(String str, char de) {
        String[] strArray;
        strArray = str.split(String.valueOf(de));
        return strArray;
    }

    public int[] strToNum(String[] strArray) {
        int[] numArray = new int[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            try { numArray[i] = Integer.parseInt(strArray[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자가 잘못됨");
            }

        }
        return numArray;
    }
}
