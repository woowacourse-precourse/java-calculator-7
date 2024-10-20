package calculator.model.impl;

import calculator.model.DelimiterParser;

public class DelimiterParserImpl implements DelimiterParser {

    @Override
    public String[] parseNumbers(String input) {
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");

            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다. \\n이 필요합니다.");
            }

            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 2);
        }

        return input.split(delimiter);
    }
}
