package calculator;

public class MyCalculator {

    private static String customDelimiter(String str) {
        String newStr = "";

        if (str.matches("^//[\\D]*\\\\n.*$")) {
            newStr += str.substring(str.indexOf("n") + 1);
        }
        return newStr.isEmpty() ? str : newStr;
    }

    private static String[] splitString(String str) {
        String newStr = customDelimiter(str);

        String[] splitNumber = newStr.split("[\\D]+");

        return splitNumber;
    }

    public static int getSum(String str) {
        String newStr = customDelimiter(str);
        String[] strArray = splitString(newStr);

        int sum = 0;

        for (String s : strArray) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}
