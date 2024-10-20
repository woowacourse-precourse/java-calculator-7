package calculator;

public class Parser {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    /* input이 빈 문자열이 아닌 경우
     * 커스텀 구분자 사용 시:
     * - (커스텀 구분자 시작, 커스텀 구분자 종료) = 정상 작동
     * - (커스텀 구분자 시작, 커스텀 구분자 끝 없음) = 에러
     * - (커스텀 구분자 시작 없음, 커스텀 구분자 끝 있음) = 에러
     * 커스텀 구분자 미사용 시:
     * - (커스텀 구분자 시작 없음, 커스텀 구분자 시작 있음) = 정상 작동
     */
    public static String[] parse(String input) {
        // 커스텀 구분자를 사용할 수 있는지 검증
        Validator.validateCustomDelimiterUsage(input, CUSTOM_DELIMITER_START, CUSTOM_DELIMITER_END);

        // 커스텀 구분자로 사용할 수 있고, 커스텀 구분자로 시작하는 경우
        if (input.startsWith(CUSTOM_DELIMITER_START)) {
            int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_END);

            // 커스텀 구분자의 종료점 여부 검증
            Validator.validateCustomDelimiterPresence(2, delimiterIndex);

            // 커스텀 구분자의 종료점이 있는 경우
            String customDelimiter = input.substring(2, delimiterIndex);
            String regulatedInput = input.substring(delimiterIndex + 2);

            // 커스텀 구분자로 파싱하는 함수
            return splitUsingCustomDelimiter(regulatedInput, customDelimiter);
        }

        // 커스텀 구분자의 종료점이 없는 경우, 기본 구분자를 이용
        return input.split(DEFAULT_DELIMITER);
    }

    private static String[] splitUsingCustomDelimiter(String regulatedInput, String customDelimiter) {
        // split() 메서드를 사용할 수 없으므로, indexOf와 substring을 활용해서 배열의 길이 결정
        int count = 1;
        int index = regulatedInput.indexOf(customDelimiter);
        int customDelimiterLength = customDelimiter.length();
        while (index != -1) {
            count++;
            index = regulatedInput.indexOf(customDelimiter, index + customDelimiterLength);
        }

        // 결정한 배열의 길이를 이용해서 계산식을 숫자 문자열로 분할
        String[] result = new String[count];

        int startIndex = 0;
        int endIndex = regulatedInput.indexOf(customDelimiter, startIndex);
        int tempIndex = 0;
        while (endIndex != -1) {
            result[tempIndex] = regulatedInput.substring(startIndex, endIndex);
            startIndex = endIndex + customDelimiterLength;
            tempIndex++;
            endIndex = regulatedInput.indexOf(customDelimiter, startIndex);
        }
        result[tempIndex] = regulatedInput.substring(startIndex);

        return result;
    }
}
