package calculator.service;

import calculator.model.DelimiterGroup;
import calculator.model.Delimiters;
import java.util.List;

public class TokenizationService {

    private final CustomDelimiterChecker customDelimiterChecker;

    private final static int CALCULATION_START_INDEX = 5;

    public TokenizationService(CustomDelimiterChecker customDelimiterChecker) {
        this.customDelimiterChecker = customDelimiterChecker;
    }

    private boolean isCustomDelimiterExist(String input) {
        return input.startsWith("//");
    }

    private String getCustomDelimiter(String input) {

        // 커스텀 구분자 지정 형식에 맞는 입력인지 확인
        customDelimiterChecker.checkCustomDelimiterRule(input);
        customDelimiterChecker.checkCustomDelimiter(input);

        String delimiter = input.substring(2, 3);

        return delimiter;
    }

    public DelimiterGroup makeDelimiterGroup(String input) {

        DelimiterGroup delimiterGroup = new DelimiterGroup(new Delimiters());
        Delimiters delimiters = delimiterGroup.getDelimiters();

        delimiters.addAllDelimiter(List.of(",", ":"));              // 기본 구분자 추가

        if (isCustomDelimiterExist(input)) {
            String customDelimiter = getCustomDelimiter(input);
            delimiters.addDelimiter(customDelimiter);
        }

        return delimiterGroup;
    }

    public String[] tokenize(String input, DelimiterGroup delimiterGroup) {

        Delimiters delimiters = delimiterGroup.getDelimiters();

        StringBuilder delimiterRegex = new StringBuilder();
        for (String delimiter : delimiters.getDelimiterList()) {
            delimiterRegex.append(delimiter).append("|");
        }
        delimiterRegex.deleteCharAt(delimiterRegex.length() - 1);

        if (isCustomDelimiterExist(input)) {
            input = input.substring(CALCULATION_START_INDEX);
        }

        return input.split(delimiterRegex.toString());
    }


}
