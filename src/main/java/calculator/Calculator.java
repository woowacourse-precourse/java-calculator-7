package calculator;

import calculator.constant.Delimiter;
import calculator.constant.ErrorCode;
import calculator.constant.Prompt;
import java.util.regex.Pattern;

public class Calculator {

    public Calculator() {
    }

    protected void start(String input) {
        String[] results = getNumberLists(input);

        int answer = getSum(results);
        System.out.println(Prompt.RESULT.getText() + answer);
    }

    public String[] getNumberLists(String str) {
        if (str.startsWith(Delimiter.CUSTOM_DELIMITER_PREFIX.getValue())) {
            int delimiterIndex = str.indexOf(Delimiter.CUSTOM_DELIMITER_SUFFIX.getValue());
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException(ErrorCode.INVALID_CUSTOM_DELIMITER.getMessage());
            }
            String delimiter = str.substring(2, delimiterIndex);
            String newStr = str.substring(delimiterIndex + 2);

            return newStr.split(
                    "[" + Pattern.quote(delimiter) +
                            Delimiter.COMMA.getValue() + Delimiter.COLON.getValue() + "]+");
        }
        return str.split("[" + Delimiter.COMMA.getValue() + Delimiter.COLON.getValue() + "]+");
    }

    public int getSum(String[] results) {
        int answer = 0;

        try {
            for (String result : results) {
                if (result.isEmpty()) {
                    continue;
                }
                int number = Integer.parseInt(result.strip());
                if (number <= 0) {
                    throw new IllegalArgumentException(ErrorCode.ONLY_POSITIVE_NUMBERS_ALLOWED.getMessage());
                }
                answer += number;

            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.ONLY_NUMBERS_ALLOWED.getMessage());
        }
        return answer;
    }
}
