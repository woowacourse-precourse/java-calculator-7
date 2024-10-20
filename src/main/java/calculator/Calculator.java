package calculator;

public class Calculator {

    public static final String PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private String input;
    private String output;
    private double sum;
    private boolean hasCustomDelimiter;
    //    private String customDelimiter;
    private final Parser parser;
    private final DelimiterManager delimiterManager;

    public Calculator() {
//        customDelimiter = "";
        parser = new Parser();
        delimiterManager = new DelimiterManager();
    }

    public void readInput(String input) {
        output = parser.parseString(input);
        // output은 "//.\n"가 delete된 문자열.
        sum(output);
    }

    public void sum(String strippedInput) {
        String digitString = "";
        if (Character.isDigit(strippedInput.charAt(0)) != true) {
            throw new IllegalArgumentException();
        }

        for (char c : strippedInput.toCharArray()) {
            if (Character.isDigit(c)) {
                digitString += Character.toString(c);
            } else if (delimiterManager.delimiters.indexOf(c) != -1) {
                add(digitString);
                digitString = "";
            } else {
                throw new IllegalArgumentException("Invalid String: The input contains invalid characters.");
            }
        }
        add(digitString);
    }

    public void add(String digitString) {
        sum += Double.valueOf(digitString);
    }

    public void displayPrompt() {
        System.out.println(PROMPT_MESSAGE);
    }

    public void printSum() {
        System.out.println(String.format("결과 : %.0f", sum));
    }

    private class Parser {

        private static final String DELIMITER_PREFIX = "//";
        private static final String DELIMITER_SUFFIX = "\\n";
        private static final int START_INDEX = 0;
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
            String customDelimiter = Character.toString(targetStringBuilder.charAt(START_INDEX));
            // DelimiterManager 인스턴스에 customDelimiter 전달
            delimiterManager.addDelimiter(customDelimiter);
            // targetStringBuilder의 customDelimiter 제거
            targetStringBuilder.deleteCharAt(START_INDEX);
            String stringWithSuffix = targetStringBuilder.toString();
            // Delimiter suffix를 제거. 만약 suffix가 없다면 유효하지 않은 문자열 예외 발생
            if (stringWithSuffix.startsWith(DELIMITER_SUFFIX)) {
                targetStringBuilder.delete(0, DELIMITER_SUFFIX.length());
            } else {
                throw new IllegalArgumentException("Invalid string: missing custom delimiter suffix.");
            }
        }
    }

    /* 구분자를 관리하는 클래스. 커스텀 구분자 지정 시, 예외처리와 커스텀 구분자 저장을 담당합니다. */
    private class DelimiterManager {

        /* 커스텀 구분자를 포함한 구분자 문자열의 최대 길이 */
        private static final int MAX_CUSTOM_DELIMITERS = 3;
        /* 구분자 문자열 */
        private String delimiters;
        /* 현재 구분자 문자열의 길이 */
        private int count;

        private DelimiterManager() {
            delimiters = ",:";
            count = 2;
        }

        /**
         * @param delimiter 기존의 구분자 문자열에 추가할 새로운 커스텀 구분자
         * @throws IllegalArgumentException 커스텀 구분자의 개수는 1개를 초과할 수 없습니다.
         * @throws IllegalArgumentException 기존의 구분자(",", ":")와 동일한 구분자는 커스텀 구분자가 될 수 없습니다.
         */
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
    }
}