package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String REGEX = "//(.)\\s*(.*)";

    /**
     * 문자열에서 숫자를 추출하고 더한 결과를 반환하는 메서드
     *
     * @param input 입력 문자열
     * @return 더한 결과 값
     */
    public static int add(String input) {
        // 3. 문자열 유효성 검사 1: 공백 문자열 처리
        if (isEmpty(input)) {
            return 0;
        }

        // 4. 구분자 확인 및 설정
        // 기본 구분자로 구분자 설정
        String delimiters = DEFAULT_DELIMITERS;
        // 숫자 부분 설정
        String numbers = input;

        // 커스텀 구분자 존재 여부 확인 및 추출
        if (input.startsWith("//")) {
            // 커스텀 구분자 추출
            delimiters = extractCustomDelimiter(input);
            // 커스텀 구분자 이후의 숫자 부분 추출
            numbers = extractNumbersAfterDelimiter(input);
        }

        return 0;
    }

    /**
     * 입력된 문자열이 공백 또는 null인지 검사
     *
     * @param input 입력 문자열
     * @return 공백 문자열 여부
     */
    private static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    /**
     * 문자열에서 커스텀 구분자를 추출
     *
     * @param input 입력 문자열
     * @return 커스텀 구분자
     */
    private static String extractCustomDelimiter(String input) {
        // // 와 \n 사이의 임의의 한 문자 추출
        Matcher matcher = Pattern.compile(REGEX).matcher(input);

        if (matcher.find()) {
            // 찾은 첫번째 구분자와 기본 구분자 함께 반환
            String customDelimiter = Pattern.quote(matcher.group(1));
            return customDelimiter + "|" + DEFAULT_DELIMITERS;
        }

        // 그 외의 경우 커스텀 구분자 형식이 잘못됨을 알림(ex //;'\n )
        throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
    }

    /**
     * 문자열에서 커스텀 구분자 이후의 숫자 부분을 추출
     *
     * @param input 입력 문자열
     * @return 숫자 부분 문자열
     */
    private static String extractNumbersAfterDelimiter(String input) {
        // //{임의의 한 문자}\n 이후의 모든 문자열 추출
        Matcher matcher = Pattern.compile(REGEX).matcher(input);
        if (matcher.find()) {
            // 찾은 첫번째 문자열 줄바꿈 제외하고 반환
            String numbers = matcher.group(2);
            numbers = numbers.replace("\\n", "");
            return numbers;
        }

        // 그 외의 경우 커스텀 구분자 이후에 숫자가 올바르게 입력되지 않음을 알림
        throw new IllegalArgumentException("커스텀 구분자 이후에 숫자가 올바르게 입력되지 않았습니다.");
    }

}
