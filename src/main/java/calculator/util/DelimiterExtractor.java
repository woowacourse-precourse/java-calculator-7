package calculator.util;

import calculator.exception.CalculatorErrorMessage;
import calculator.exception.CalculatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String DEFAULT_DELIMITER = ",|:";

    private static final int CUSTOM_DELIMITER_LENGTH = 5;
    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    private static final Pattern CAPTURE_CUSTOM_DELIMITER = Pattern.compile("^//(.)\\\\n");

    public static String extractDelimiterAndInput(String input){
        StringBuilder delimiterAndInput = new StringBuilder(DEFAULT_DELIMITER);

        if(input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.length() >= CUSTOM_DELIMITER_LENGTH){
            return delimiterAndInput.append("|").append(getCustomDelimiterAndRemain(input)).toString();
        }

        return delimiterAndInput.append(" ").append(input).toString();
    }

    public static String getCustomDelimiterAndRemain(String input){
        StringBuilder customDelimiterAndRemain = new StringBuilder();
        Matcher matcher = CAPTURE_CUSTOM_DELIMITER.matcher(input);

        if(!matcher.find()){
            throw new CalculatorException(CalculatorErrorMessage.INVALID_CUSTOM_DELIMITER_SEPARATION_ERROR);
        }

        if(containsDefaultDelimiter(matcher.group())){
            throw new CalculatorException(CalculatorErrorMessage.CONTAIN_DEFAULT_DELIMITER_ERROR);
        }

        // 커스텀 구분자 + " " + 뒤 문자열
        return customDelimiterAndRemain.append(matcher.group(1)).append(" ").append(input.substring(matcher.end())).toString();
    }

    private static boolean containsDefaultDelimiter(String customDelimiter){
        Pattern pattern = Pattern.compile(DEFAULT_DELIMITER);
        Matcher matcher = pattern.matcher(customDelimiter);

        return matcher.find();
    }
}
