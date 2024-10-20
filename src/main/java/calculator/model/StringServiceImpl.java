package calculator.model;

import calculator.utils.CalculatorDelimiter;
import calculator.utils.InputWithDelimiter;
import calculator.validator.InputValidator;
import calculator.validator.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringServiceImpl implements StringService {
    @Override
    public List<Integer> parse(String input) {
        CalculatorDelimiter delimiter = new CalculatorDelimiter();
        InputWithDelimiter inputWithDelimiter;
        if (input.startsWith("//")) {
            inputWithDelimiter = extractCustomInputAndDelimiter(input);
        } else {
            inputWithDelimiter = new InputWithDelimiter(input, delimiter);
        }

        /* 입력값 검증*/
        Validator<InputWithDelimiter> inputValidator = new InputValidator();
        inputValidator.isValid(inputWithDelimiter);
        return toIntegerList(split(inputWithDelimiter));
    }

    public static List<String> split(InputWithDelimiter inputWithDelimiter) {

        String input = inputWithDelimiter.getInput();
        CalculatorDelimiter delimiter = inputWithDelimiter.getCalculatorDelimiter();

        if (input.isEmpty()) {
            return new ArrayList<>();
        }

        return Arrays.asList(input.split(delimiter.getDelimiterRegex()));
    }


    public static List<Integer> toIntegerList(List<String> stringList) {
        return stringList.stream().map(Integer::parseInt).toList();
    }

    public static InputWithDelimiter extractCustomInputAndDelimiter(String customInput) {
        Matcher matcher = Pattern.compile("//(.+)\\\\n(.*)").matcher(customInput);
        if (matcher.matches()) {
            CalculatorDelimiter delimiter = new CalculatorDelimiter();
            String customDelimiter = matcher.group(1);
            delimiter.addDelimiter(customDelimiter);
            return new InputWithDelimiter(matcher.group(2), delimiter);
        } else {
            throw new IllegalArgumentException("알맞은 형식이 아닙니다.");
        }
    }
}
