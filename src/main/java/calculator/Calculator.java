package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator implements AutoCloseable {

    public static final String PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private String input;
    private String output;
    private double sum;
    private boolean hasCustomDelimiter;
    private String customDelimiter;
    private final Parser parser;
    private final DelimiterManager delimiterManager;

    public Calculator() {
        customDelimiter = "";
        parser = new Parser();
        delimiterManager = new DelimiterManager();
    }

    public void displayPrompt() {
        System.out.println(PROMPT_MESSAGE);
    }

    public void readInput(String input) {
        output = parser.parseString(input);
        // output은 "//.\n"가 delete된 문자열.
    }

    public void add() {

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
        private static final String DELIMITER_SUFFIX = "\n";
        private static final int CUSTOM_DELIMITER = 0;
        StringBuilder strippedStringBuilder;

        private Parser() {
        }

        private String parseString(String inputString) {
            // 문자열 양 끝에 존재하는 Whitespace 및 유니코드 공백 제거
            String strippedString = inputString.strip();
            // 빈 문자열 처리
            if (strippedString.isEmpty()) {
                return "0";
            }

            strippedStringBuilder = removeDelimiterPrefix(strippedString);
            if (hasCustomDelimiter) {
                removeDelimiterSuffix(strippedStringBuilder);
            }

            return strippedStringBuilder.toString();
        }

        private StringBuilder removeDelimiterPrefix(String targetString) {
            StringBuilder targetStringBuilder = new StringBuilder(targetString);

            if (targetString.startsWith(DELIMITER_PREFIX)) {
                hasCustomDelimiter = true;
                targetStringBuilder.delete(0, DELIMITER_PREFIX.length());
            }
            return targetStringBuilder;
        }

        private void removeDelimiterSuffix(StringBuilder targetStringBuilder) {
            customDelimiter = Character.toString(targetStringBuilder.charAt(CUSTOM_DELIMITER));
            // DelimiterManager 인스턴스에 customDelimiter 전달
            delimiterManager.addDelimiter(customDelimiter);
            // targetStringBuilder의 customDelimiter 제거
            targetStringBuilder.deleteCharAt(CUSTOM_DELIMITER);
            String stringWithSuffix = targetStringBuilder.toString();
            // Delimiter suffix를 제거. 만약 suffix가 없다면 유효하지 않은 문자열 예외 발생
            if (stringWithSuffix.startsWith(DELIMITER_SUFFIX)) {
                targetStringBuilder.delete(0, DELIMITER_SUFFIX.length());
            } else {
                throw new IllegalArgumentException("Invalid string: missing custom delimiter suffix.");
            }
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