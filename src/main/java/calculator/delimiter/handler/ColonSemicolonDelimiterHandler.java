package calculator.delimiter.handler;

import calculator.delimiter.handler.DelimiterHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ColonSemicolonDelimiterHandler implements DelimiterHandler {
    @Override
    public List<String> split(String str) {
        if (str.matches(".*[^0-9,:].*")) {
            throw new IllegalArgumentException("형식이 일치하지 않습니다.");
        }

        String[] splits = str.split("[,:]");

        return Arrays.stream(splits)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isSupport(String str) {
        return str.contains(",") || str.contains(":");
    }
}