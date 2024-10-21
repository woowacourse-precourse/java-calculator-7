package calculator.Service;

import calculator.Util.NumberParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateService {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.*?)\\\\n(.*)";

    public int calculate(String input) {
        String[] numbers;

        //빈 문자열이면 0 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        //custom 구분자 있는지 확인하고 구분자로 나누기
        String regex = CUSTOM_DELIMITER;
        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            numbers = matcher.group(2).split(customDelimiter);
        } else {
            numbers = input.split(DEFAULT_DELIMITER);
        }
        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += NumberParser.parseAndValidateNumber(number);
        }
        return sum;
    }

}
