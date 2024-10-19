package calculator;

public class Calculator {
    private static StringBuilder delimeters = new StringBuilder(":,");

    public static int add(String input) {
        StringBuilder number = new StringBuilder();
        int sum = 0;

        if (input.startsWith("//") && input.length() >= 4) {
            if (input.lastIndexOf("\\n") == 3) {
                delimeters.append(input.charAt(2));
                input = input.substring(5);
            } else if (input.lastIndexOf("\\n") == 2) {
                input = input.substring(4);
            } else {
                throw new IllegalArgumentException();
            }
        }

        int inputStringLength = input.length();
        for (int i = 0; i < inputStringLength; ++i) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                number.append(ch);
                continue;
            } else if (isDelimeter(ch)) {
                if (!number.isEmpty()) {
                    sum += Integer.parseInt(number.toString());
                }
                number.setLength(0);
                continue;
            }
            throw new IllegalArgumentException();

        }
        if (!number.isEmpty()) {
            sum += Integer.parseInt(number.toString());
        }

        return sum;
    }

    private static boolean isDelimeter(char ch) {
        int delimeterLength = delimeters.length();
        for (int i = 0; i < delimeterLength; ++i) {
            if (delimeters.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }
}
