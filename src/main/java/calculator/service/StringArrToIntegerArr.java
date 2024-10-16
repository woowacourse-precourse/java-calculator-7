package calculator.service;

public class StringArrToIntegerArr {

    public static int[] toNumbers(String[] strArr) {
        int[] numbers = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numbers[i] = Integer.parseInt(strArr[i]);
        }
        return numbers;
    }
}
