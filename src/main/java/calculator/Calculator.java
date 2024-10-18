package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator implements AutoCloseable {

    public static final String PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private String input;
    private String output;
    private double sum;
    private boolean isCustom;
    private char customChar;
    private final Parser parser;
    private final DelimiterManager delimiterManager;

    public Calculator() {
        parser = new Parser();
        delimiterManager = new DelimiterManager();
    }

    public void displayPrompt() {
        System.out.println(PROMPT_MESSAGE);
    }

    public void readInput(String input) {
        output = parser.parseString(input);
    }

    public void sum() {
        output = String.valueOf(sum);
    }

    public void printSum() {
        System.out.println(String.format("결과 : %.0f", sum));
    }

    @Override
    public void close() throws Exception {
        Console.close();
    }

    private class Parser {

        private static final String DELIMITER_PREFIX = "//";
        private static final String DELIMITER_DEFINITION_END = "\n";
        StringBuilder stringBuilder;

        private Parser() {
        }

        private String parseString(String str) {
            // 문자열 양 끝에 존재하는 Whitespace 및 유니코드 공백 제거
            String newStr = str.strip();
            // 빈 문자열 처리
            if (newStr.isEmpty()) {
                return "0";
            }
        }

        private static boolean isValidString(String str) {
        }
    }

    private class DelimiterManager {

        private static final int MAX_CUSTOM_DELIMITERS = 3;
        private String delimiters;
        private int count;

        private DelimiterManager() {
            String delimiters = ",:";
            count = 2;
        }

        public void addDelimiter(String delimiter) {

            if (count >= MAX_CUSTOM_DELIMITERS) {
                throw new IllegalArgumentException("Only one custom delimiter is allowed.");
            }

            if (delimiters.contains(delimiter)) {
                throw new IllegalArgumentException("Custom delimiter cannot be a default delimiter (',' or ':').");
            }

            delimiters += delimiter;
            count++;
        }

        public String getDelimiters() {
            return delimiters;
        }
    }
}
