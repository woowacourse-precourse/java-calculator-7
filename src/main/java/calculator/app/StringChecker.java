package calculator.app;

import java.util.ArrayList;
import java.util.List;

public class StringChecker {

    private static String LEFT_SEPARATOR = "//";
    private static String RIGHT_SEPARATOR = "\\n";
    private static List<Character> BASIC_SEPARATOR = List.of(',', ':');

    public List<Character> checkCustomSeparator(String expression) {
        if (expression.length() >= 5 && expression.substring(0, 2).equals(LEFT_SEPARATOR) && expression.substring(3, 5)
                .equals(RIGHT_SEPARATOR)) {
            List<Character> customSeparator = new ArrayList<>(BASIC_SEPARATOR);
            customSeparator.add(expression.charAt(2));
            return customSeparator;
        }
        return BASIC_SEPARATOR;
    }


    public List<Integer> checkExpressionValidation(String string, List<Character> separatorList) { //구분자를 기준으로 하여
        ArrayList<Integer> positiveNumberList = new ArrayList<>();
        StringBuilder numberBuilder = new StringBuilder();
        try {
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);

                if (separatorList.contains(ch)) {
                    int number = Integer.parseInt(numberBuilder.toString());
                    if (number <= 0) {
                        throw new Exception();
                    }
                    positiveNumberList.add(number);
                    numberBuilder.setLength(0);
                    continue;
                } else if (Character.isDigit(ch)) {
                    numberBuilder.append(ch);
                    continue;
                }

                throw new Exception();
            }
            if (numberBuilder.isEmpty()) {
                return positiveNumberList;
            }
            int number = Integer.parseInt(numberBuilder.toString());
            if (number <= 0) {
                throw new Exception();
            }
            positiveNumberList.add(number);
            return positiveNumberList;

        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }


}
