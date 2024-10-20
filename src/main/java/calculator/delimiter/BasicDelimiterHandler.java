package calculator.delimiter;

import calculator.DelimiterHandler;

public class BasicDelimiterHandler implements DelimiterHandler {

    private static final String DEFAULT_DELIMITERS = "[,:]";

    @Override
    public String[] split(String input) {
        // 기본 구분자(,와 :)를 기준으로 분리
        return input.split(DEFAULT_DELIMITERS);
    }
}
