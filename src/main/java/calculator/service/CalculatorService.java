package calculator.service;

import calculator.domain.DelimiterAndNumber;
import calculator.exception.CalculatorException;
import calculator.validation.DelimiterValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    private static final List<String> DEFAULT_DELIMITERS = Arrays.asList(",", ":");

    // 기본 구분자, 커스텀 구분자 타입 체크
    private DelimiterAndNumber isDelimiterCustomOrDefault(String input, DelimiterValidation validation) {
        DelimiterAndNumber delimiterAndNumberInput;

        if (validation.isCustomDelimiter(input)) {
            delimiterAndNumberInput = getCustomInputParse(input);
        } else {
            delimiterAndNumberInput = new DelimiterAndNumber(DEFAULT_DELIMITERS, input);
        }

        return delimiterAndNumberInput;
    }

    private ArrayList<String> extractEscapedAndCustomDelimiter(String delimiter) {
        ArrayList<String> customDelimiter = new ArrayList<>();
        String specialChars = ".*+?^$[]{}()|\\";

        for (int i = 0; i < delimiter.length(); i++) {
            char ch = delimiter.charAt(i);
            if (specialChars.indexOf(ch) >= 0) {
                customDelimiter.add("\\" + ch);
            } else {
                customDelimiter.add(String.valueOf(ch));
            }
        }

        return customDelimiter;
    }

    private void isCheckSameDelimiterName(List<String> delimiters, List<String> customDelimiters) {
        for (String delimiter : customDelimiters) {
            if (!delimiters.contains(delimiter)) {
                delimiters.add(delimiter);
            }
        }
    }

    private String[] splitNumbersByDelimiter(DelimiterAndNumber parsedInput) {
        String numbers = parsedInput.getNumbers();
        List<String> delimiters = parsedInput.getDelimiters();

        // 구분자를 기준으로 숫자 분리
        String delimiterRegex = String.join("|", delimiters);

        return numbers.split(delimiterRegex);
    }

    private int sum(String[] numbers) {

        int sum = 0;

        for (String number : numbers) {

            if (number.isEmpty()) {
                number = "0";
            }

            sum += Integer.parseInt(number);
        }

        return sum;
    }

}
