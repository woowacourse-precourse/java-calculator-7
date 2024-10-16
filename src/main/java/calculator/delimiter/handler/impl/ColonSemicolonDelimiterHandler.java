package calculator.delimiter.handler.impl;

import calculator.delimiter.handler.DelimiterHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ColonSemicolonDelimiterHandler implements DelimiterHandler {
    @Override
    public List<String> split(String str) {
        if (str.matches(".*[^0-9,:].*")) {
            throw new IllegalArgumentException("지원되지 않는 구분자입니다.");
        }

        String[] splits = str.split("[,:]");

        return Arrays.stream(splits)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isSupport(String string) {
        return string.contains(",") || string.contains(":");
    }
}

