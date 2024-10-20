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

    /**
     * 지정된 메시지를 프롬프트에 출력하는 메서드
     */
    public void displayPrompt() {
        System.out.println(PROMPT_MESSAGE);
    }

    /**
     * 지정된 형식으로 문자열에서 추출한 숫자를 더한 값을 출력하는 메서드
     */
    public void printSum() {
        System.out.println(String.format("결과 : %.0f", sum));
    }


    /** 입력받은 문자열을 파싱하는 클래스 */
    private class Parser {

        /**
         * DELIMITER_PREFIX: 커스텀 구분자 정의 접두사
         * DELIMITER_SUFFIX: 커스텀 구분자 정의 접미사
         * START_INDEX: StringBuilder.delete() 메서드 호출 시, 잘라낼 문자열의 시작 인덱스 값을 나타냅니다.
         * strippedStringBuilder: String의 가변 객체로, 구분자 섹션을 잘라내기 위해 사용합니다.
         */
        private static final String DELIMITER_PREFIX = "//";
        private static final String DELIMITER_SUFFIX = "\\n";
        private static final int START_INDEX = 0;
        StringBuilder strippedStringBuilder;

        private Parser() {
        }

        private String parseString(String inputString) {
            String strippedString = inputString.strip();

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
            customDelimiter = Character.toString(targetStringBuilder.charAt(START_INDEX));
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

    /**
     * 구분자를 관리하는 클래스.
     * 커스텀 구분자 지정 시, 예외 처리와 커스텀 구분자 저장을 담당합니다.
     */
    private class DelimiterManager {

        /**
         * MAX_CUSTOM_DELIMITERS: 커스텀 구분자를 포함한 구분자 문자열의 최대 길이
         * delimiters: 구분자 문자열
         * count: 현재 구분자 문자열의 길이
         */

        private static final int MAX_CUSTOM_DELIMITERS = 3;
        private String delimiters;
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