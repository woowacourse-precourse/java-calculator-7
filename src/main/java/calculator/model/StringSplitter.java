package calculator.model;

import static calculator.validate.Validator.handleConversionError;
import static calculator.validate.Validator.validateInputStringAndDelimiters;

import java.util.ArrayList;
import java.util.List;

public class StringSplitter {

    private static final String OR_OPERATOR = "|";
    private static final String REGEX_QUOTE_START = "\\Q";
    private static final String REGEX_QUOTE_END = "\\E";

    public List<Integer> splitAndConvertToIntegers(String inputString, List<String> delimiters,
                                                   boolean allowNegativeNumbers) {
        validateInputStringAndDelimiters(inputString, delimiters);

        String[] splitInputString = splitInputStringByDelimiters(inputString, delimiters);

        return convertStringArrayToIntegerList(splitInputString, allowNegativeNumbers);
    }

    private String[] splitInputStringByDelimiters(String inputString, List<String> delimiters) {
        String regex = createRegexFromDelimiters(delimiters);
        return inputString.split(regex);
    }

    private String createRegexFromDelimiters(List<String> delimiters) {
        StringBuilder regexBuilder = new StringBuilder();

        for (String delimiter : delimiters) {
            appendOrOperatorWhenNeeded(regexBuilder);

            // "-" 구분자를 처리
            if (delimiter.equals("-")) {
                regexBuilder.append("\\-");
            } else {
                regexBuilder.append(makeDelimiterRegexWithEscape(delimiter));
            }
        }
        return regexBuilder.toString();
    }

    private void appendOrOperatorWhenNeeded(StringBuilder regexBuilder) {
        if (!regexBuilder.isEmpty()) {
            regexBuilder.append(OR_OPERATOR);
        }
    }

    private String makeDelimiterRegexWithEscape(String delimiter) {
        return REGEX_QUOTE_START + delimiter + REGEX_QUOTE_END;
    }

    private List<Integer> convertStringArrayToIntegerList(String[] splitInputString, boolean allowNegativeNumbers) {
        List<Integer> convertedIntegerList = new ArrayList<>();

        for (String inputStringPart : splitInputString) {
            if (!inputStringPart.trim().isEmpty()) {
                convertedIntegerList.add(convertToInteger(inputStringPart, allowNegativeNumbers));
            }
        }

        return convertedIntegerList;
    }

    private Integer convertToInteger(String inputStringPart, boolean allowNegativeNumbers) {
        try {
            int number = Integer.parseInt(inputStringPart.trim());

            // 음수를 허용하지 않는 경우 에러 발생
            if (!allowNegativeNumbers && number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + inputStringPart);
            }

            return number;
        } catch (NumberFormatException e) {
            handleConversionError(inputStringPart);
            return null;
        }
    }
}
