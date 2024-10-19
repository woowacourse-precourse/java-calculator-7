package calculator.service;

public class StringArrToIntegerArr {

    public static int[] toNumbers(String[] strArr) {
        int[] numbers = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].isEmpty()) {
                numbers[i] = 0;
            } else if (!strArr[i].isEmpty()) {
                numbers[i] = Integer.parseInt(strArr[i]);
            }
        }
        return numbers;
    }
}
