package calculator.domain;

import calculator.domain.model.PreprocessedInput;

import java.util.ArrayList;
import java.util.Arrays;

public class Preprocessor {
    private static final String DELIMITER_PREFIX = "//";
    private static final String DELIMITER_SUFFIX = "\n";
    private static final ArrayList<Character> DELIMITERS = new ArrayList<>(Arrays.asList(',', ';'));
    // TODO: 여기가 final일 경우 코드가 좀 더 더러워 지는데, 여기가 final이 아니면 어떤 문제가 생길지 생각해보기
    private String input;

    public Preprocessor(String input) {
        this.input = input == null ? "" : input;
    }

    public PreprocessedInput preprocess() {
        if (input.startsWith(DELIMITER_PREFIX)) {
            addCustomDelimiter(input);
            input = input.split(DELIMITER_SUFFIX)[1];
        }

        return new PreprocessedInput(input, DELIMITERS);
    }

    private void addCustomDelimiter(String input) {
        int delimiterEnd = getDelimiterEndOrThrow(input);
        String customDelimiter = input.substring(DELIMITER_PREFIX.length(), delimiterEnd);
        DELIMITERS.add(customDelimiter.charAt(0));
    }

    private int getDelimiterEndOrThrow(String input) {
        int delimiterEnd = input.indexOf(DELIMITER_SUFFIX);
        if (delimiterEnd == -1) { // suffix가 없으면 잘못된 입력
            throw new IllegalArgumentException();
        }
        return delimiterEnd;
    }
}
