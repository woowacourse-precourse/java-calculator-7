package calculator;

public class Calculator {

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

    public void readInput(String input) {
        // 구분자 문자열이 제거된 String 타입의 문자열이 반환됩니다.
        output = parser.parseString(input);
        sum(output);
    }

    public void sum(String strippedInput) {
        String digitString = "";
        if (Character.isDigit(strippedInput.charAt(0)) != true) {
            throw new IllegalArgumentException("Invalid String: The input contains invalid characters.");
        }

        for (char c : strippedInput.toCharArray()) {
            if (Character.isDigit(c) || (!customDelimiter.equals(".") && c == '.')) {
                digitString += Character.toString(c);
            } else if (delimiterManager.isDelimiter(c)) {
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

    /** 지정된 메시지를 프롬프트에 출력하는 메서드 */
    public void displayPrompt() {
        System.out.println(PROMPT_MESSAGE);
    }

    /** 지정된 형식으로 문자열에서 추출한 숫자를 더한 값을 출력하는 메서드 */
    public void printSum() {
        System.out.println(String.format("결과 : %.0f", sum));
    }

    /* 입력받은 문자열을 파싱하는 클래스 */
    private class Parser {

        /*
         * DELIMITER_PREFIX: 커스텀 구분자 정의 접두사
         * DELIMITER_SUFFIX: 커스텀 구분자 정의 접미사
         * START_INDEX: StringBuilder.delete() 메서드 호출 시, 잘라낼 문자열의 시작 인덱스 값을 나타냅니다.
         */
        private static final String DELIMITER_PREFIX = "//";
        private static final String DELIMITER_SUFFIX = "\\n";
        private static final int START_INDEX = 0;

        public Parser() {
        }

        private String parseString(String inputString) {
            String strippedString = inputString.strip();

            if (strippedString.isEmpty()) {
                return "0";
            }
            StringBuilder strippedStringBuilder = removeDelimiterPrefix(strippedString);

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
            /* 커스텀 구분자를 추출 */
            extractCustomDelimiter(targetStringBuilder);

            /* Delimiter suffix를 제거. 만약 suffix가 없다면 유효하지 않은 문자열 예외 발생 */
            if (!isDelimiterSuffix(targetStringBuilder)) {
                throw new IllegalArgumentException("Invalid string: missing custom delimiter suffix.");
            }
            targetStringBuilder.delete(START_INDEX, DELIMITER_SUFFIX.length());
        }

        private boolean isDelimiterSuffix(StringBuilder targetStringBuilder) {
            String stringWithSuffix = targetStringBuilder.toString();

            return stringWithSuffix.startsWith(DELIMITER_SUFFIX);
        }

        private void extractCustomDelimiter(StringBuilder targetStringBuilder) {
            customDelimiter = Character.toString(targetStringBuilder.charAt(START_INDEX));
            /* DelimiterManager 인스턴스에 customDelimiter 전달 */
            delimiterManager.addDelimiter(customDelimiter);
            /* targetStringBuilder의 customDelimiter 제거 */
            targetStringBuilder.deleteCharAt(START_INDEX);
        }
    }
}