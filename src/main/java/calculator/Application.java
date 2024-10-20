package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String DEFAULT_DELIMITERS = ",|:"; // 쉼표 또는 콜론을 기본 구분자로 정의
    private static final String CUSTOM_DELIMITER_PREFIX = "//"; // 커스텀 구분자 접두사
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n"; // 커스텀 구분자 접미사

    public static void main(String[] args) {
        try { //TODO: 제출할 땐 try-catch 블록을 제거
            // 사용자 입력 받기
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            // 계산 결과 출력
            int result = calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 stack trace 출력
            e.printStackTrace();
        }
    }

    /**
     * 문자열을 입력받아 덧셈을 계산하는 메소드
     *
     * @param input
     * @return 계산 결과
     */
    private static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers;

        // 커스텀 구분자 처리
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int customDelimiterEnd = input.indexOf(CUSTOM_DELIMITER_SUFFIX);  // 커스텀 구분자 끝 인덱스
            String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(),
                    customDelimiterEnd); // 커스텀 구분자 추출
            // TODO: 커스텀 구분자에 대한 예외 처리
            // 커스텀 구분자와 기본 구분자 모두를 처리하도록 구분자 연결
            String combinedDelimiters = customDelimiter + "|" + DEFAULT_DELIMITERS; // OR 연산자로 구분자 연결
            numbers = split(input.substring(customDelimiterEnd + CUSTOM_DELIMITER_SUFFIX.length()),
                    combinedDelimiters); // 구분자를 기준으로 문자열 분리
        } else {
            numbers = split(input, DEFAULT_DELIMITERS);
        }

        // 숫자 배열 및 입력에 대한 유효성 검사
        validateInput(numbers, input);

        return sum(numbers);
    }

    /**
     * 문자열을 구분자로 분리하는 메소드
     *
     * @param input
     * @param delimiter
     * @return 분리된 문자열 배열
     */
    private static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    /**
     * 문자열 배열을 정수로 변환하여 합산하는 메소드
     *
     * @param numbers
     * @return 합산 결과
     */
    private static int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    /**
     * 입력값을 검증하는 메소드
     *
     * @param numbers 분리된 숫자 배열
     * @param input   원본 입력 문자열
     */
    private static void validateInput(String[] numbers, String input) {
        // 공백이 포함된 경우 확인
        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력에 공백이 포함될 수 없습니다.");
        }
        
        // 입력이 '//'로 시작하지 않고 숫자로 시작하지 않으면 예외 발생
        if (!input.startsWith("//") && !Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("입력은 '//'로 시작하거나 숫자로 시작해야 합니다.");
        }

        // 입력이 숫자로 끝나지 않으면 예외 발생
        if (!Character.isDigit(input.charAt(input.length() - 1))) {
            throw new IllegalArgumentException("입력은 숫자로 끝나야 합니다.");
        }

        for (String number : numbers) {
            if (number.isEmpty()) { // 구분자가 연속으로 나오는 경우
                throw new IllegalArgumentException("연속된 구분자는 허용되지 않습니다.");
            }
            int num = Integer.parseInt(number); // 문자열을 정수로 변환
            // 음수 입력 검증
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            if (!number.matches("-?\\d+")) {  // 정수인지 확인 (음수 포함)
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되었습니다: " + number);
            }
        }
    }
}
