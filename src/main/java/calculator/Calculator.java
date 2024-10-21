package calculator;

/** 입력한 문자열에서 숫자를 추출하여 더하는 계산기 클래스 */
public class Calculator {

    /**
     * PROMPT_MESSAGE : 사용자에게 보여줄 메시지
     * sum : 최종적으로 반환할 모든 값을 더한 값
     * originalInput : 사용자 입력 문자열의 원본
     * modifiedInput : 파싱을 거쳐 구분자 섹션을 제외한 사용자 입력 문자열
     * parser : 파싱을 담당하는 Calculator의 내부 클래스
     * delimiterManager : 구분자와 관련된 속성과 기능을 구현한 클래스
     */
    public static final String PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private double sum;
    private String originalInput;
    private String modifiedInput;
    private final Parser parser;
    private final DelimiterManager delimiterManager;

    public Calculator() {
        originalInput = "";
        modifiedInput = "";
        parser = new Parser();
        delimiterManager = new DelimiterManager();
    }

    /**
     * 사용자가 입력한 문자열을 파싱하고 처리합니다.
     *
     * @param input 사용자 입력 문자열
     */
    public void readInput(String input) {
        originalInput = input;
        if (input.isEmpty()) {
            return;
        }
        String output = parser.parseString(input);

        if (output.isEmpty()) {
            return;
        }
        sum(output);
    }

    /**
     * 숫자형 문자의 값을 더합니다.
     *
     * @param modifiedInput 구분자 섹션이 분리된 문자열
     */
    private void sum(String modifiedInput) {
        if (Character.isDigit(modifiedInput.charAt(0)) != true) {
            throw new IllegalArgumentException("The input contains invalid characters.");
        }

        String[] splittedString = splitByDelimiters(modifiedInput);
        for (String string : splittedString) {
            if (string.isEmpty()) {
                throw new IllegalArgumentException("The input contains invalid characters.");
            }
            add(string);
        }
    }

    /**
     * 구분자들을 기준으로 문자열을 쪼개는 메서드
     *
     * @param modifiedInput
     * @return 쪼개진 문자열 배열
     */
    private String[] splitByDelimiters(String modifiedInput) {
        String regex = "[" + delimiterManager.getDelimiters() + "]";
        return modifiedInput.split(regex);
    }

    /**
     * 합산한 값(sum)에 인자로 들어온 값을 더합니다.
     *
     * @param digitString
     */
    private void add(String digitString) {
        if (isNumeric(digitString)) {
            sum += Double.valueOf(digitString);
        } else {
            throw new IllegalArgumentException("The input contains invalid characters.");
        }
    }

    /**
     * 정규표현식을 사용해 숫자형 문자인지 확인합니다.
     * @param str 판별할 문자열
     * @return 숫자형 문자인지 판별 여부
     */
    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    /** 프롬프트에 지정한 메시지를 출력합니다. */
    public void displayPrompt() {
        System.out.println(PROMPT_MESSAGE);
    }

    /** 지정한 형식으로 결과값을 출력합니다. */
    public void printSum() {
        System.out.println(String.format("결과 : %.1f", sum));
    }

    /** 입력한 문자열의 파싱을 담당하는 내부 클래스 */
    private class Parser {

        public Parser() {
        }

        /**
         * 입력된 문자열이 유효한 문자열인지 검사하고 문자열을 재조립합니다.
         *
         * @param originalInput 사용자 입력 문자열의 원본
         * @return 구분자 섹션이 있으면, 구분자 섹션을 제외한 사용자 입력 문자열을 구분자 섹션이 없으면 원본 문자열을 반환
         */
        private String parseString(String originalInput) {
            String strippedInput = originalInput.strip();

            if (strippedInput.equals("\"\"")) {
                return "0";
            }
            hasDelimiterSection(strippedInput);

            if (delimiterManager.getCustomDelimiter() != '\0') {
                String splittedString = splitByDelimiterChar(strippedInput);
                modifiedInput = compareToSuffix(splittedString);
                return modifiedInput;
            }
            return originalInput;
        }

        /**
         * 앞,뒤로 White space를 제거한 사용자 입력 문자열에 구분자 섹션이 있는지 확인합니다.
         *
         * @param strippedInput 앞,뒤로 White space를 제거한 사용자 입력 문자열
         */
        private void hasDelimiterSection(String strippedInput) {
            if (Character.isDigit(strippedInput.charAt(0))) {
                return;
            }
            checkValidInput(strippedInput);
            delimiterManager.setCustomChar(
                    strippedInput.charAt(delimiterManager.getLenOfPrefix()));
        }

        /**
         * 유효한 형식을 갖춘 문자열인지 확인합니다.
         *
         * @param targetString 검증받을 문자열
         */
        private void checkValidInput(String targetString) {
            if (targetString.length() <= delimiterManager.getLenOfPrefix() + delimiterManager.CUSTOM_DELIMITER_LEN) {
                throw new IllegalArgumentException("The input formats invalidly.");
            }
        }

        /**
         * 커스텀 구분자를 기준으로 문자열을 쪼개 커스텀 구분자를 포함하지 않은 뒤 문자열을 반환합니다.
         *
         * @param strippedInput 쪼개질 대상이 될 문자열
         * @return 커스텀 구분자를 포함하지 않은 뒤 문자열
         */
        private String splitByDelimiterChar(String strippedInput) {
            String customDelimiter = Character.toString(delimiterManager.getCustomDelimiter());

            String regexDelimiter = customDelimiter.replace("\\", "\\\\"); // \를 \\로 이스케이프

            String[] splittedString = strippedInput.split("[" + regexDelimiter + "]");

            return splittedString[1];
        }

        /**
         * 해당 문자열이 구분자 섹션 접미사와 일치하는지 확인합니다.
         *
         * @param stringWithSuffix 커스텀 구분자 뒤부터 시작하는 문자열
         * @return 구분자 섹션을 제외한 문자열
         */
        private String compareToSuffix(String stringWithSuffix) {
            if (stringWithSuffix.length() < delimiterManager.getLenOfSuffix()) {
                throw new IllegalArgumentException("The input formats invalidly. especially at suffix.");
            }

            if (stringWithSuffix.startsWith(delimiterManager.DELIMITER_SUFFIX)) {
                stringWithSuffix = stringWithSuffix.replace(delimiterManager.DELIMITER_SUFFIX, "n");
                return stringWithSuffix.substring(delimiterManager.getLenOfSuffix() - 1);
            }
            throw new IllegalArgumentException("The provided suffix is invalid or not present.");
        }
    }
}