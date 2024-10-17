package calculator.model;

public class Calculator {
    public static String[] separateNumber(String input, String delimiter) {
        String[] numberGroup = input.split(delimiter);
        return numberGroup;
    }

    public static int findSum(String[] numberGroup) {
        int sum = 0;
        for (String number : numberGroup) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
