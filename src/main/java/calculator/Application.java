package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    private static final String READ_INPUT_STATEMENT = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_STATEMENT = "결과 : ";
    private static final String DEFAULT_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//.\\\\n.*";

    public static void main(String[] args) {
        System.out.println(READ_INPUT_STATEMENT);
        String input = Console.readLine();

        // 빈 문자열이 입력되었을 경우 0을 출력하고 프로그램 실행 종료
        if (input.isBlank()) {
            System.out.println(RESULT_STATEMENT + 0);
            return;
        }

        System.out.println("결과 : " + run(input));;
    }

    private static int run(String input) {
        String regex = DEFAULT_REGEX;

        // 커스텀 지정자를 사용하는 경우
        if (Pattern.matches(CUSTOM_DELIMITER_PATTERN, input)) {
            // 입력받은 문자열에서 커스텀 지정자를 추출한 후, 이 또한 구분자의 역할을 하도록 regex를 수정.
            regex = regex + '|' + input.charAt(2);

            // 커스텀 지정자 형식은 더 이상 필요하지 않으므로 문자열에서 삭제.
            input = input.substring(5);
        }

        // regex를 통해 구분자를 기준으로 문자열 분할
        String[] splited = input.split(regex);
        // 덧셈 연산 수행 결과 반환
        return calculate(splited);
    }

    private static int calculate(String[] numbers) {
        int sum = 0;
        try {
            // 문자열 배열에 저장된 각 숫자들을 int 타입으로 변환하여 누적 합 연산.
            for (String number : numbers) {
                // 양수가 아닌 경우 예외 발생.
                if (Integer.parseInt(number) <= 0) {
                    throw new IllegalArgumentException();
                }
                sum += Integer.parseInt(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        } // NumberFormatException 발생 시 배열의 요소가 숫자 형태가 아닌 잘못된 입력이 존재하는 것이므로 예외 발생.

        return sum;
    }
}