package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String RESULT_STATEMENT = "결과 : ";
    private static final String DEFAULT_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_FORMAT = "//#\\n";

    public static void main(String[] args) {
        String input = Console.readLine();

        // 빈 문자열이 입력되었을 경우 0을 출력하고 프로그램 실행 종료
        if (input.isBlank()) {
            System.out.println(RESULT_STATEMENT + 0);
            return;
        }
        run(input);
    }

    private static void run(String input) {
        String regex = DEFAULT_REGEX;

        // 커스텀 지정자를 사용하는 경우
        if (checkWhetherInputUsingCustomDelimiter(input)) {
            // 입력받은 문자열에서 커스텀 지정자를 추출한 후, 이 또한 구분자의 역할을 하도록 regex를 수정.
            regex = regex + '|' + getCustomDelimiter(input);

            // 커스텀 지정자 형식은 더 이상 필요하지 않으므로 문자열에서 삭제.
            input = input.substring(5);
        }

        // regex를 통해 구분자를 기준으로 문자열 분할
        String[] splited = input.split(regex);
        // 덧셈 연산 수행 및 출력
        System.out.println(RESULT_STATEMENT + calculate(splited));
    }

    private static boolean checkWhetherInputUsingCustomDelimiter(String input) {
        if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
            return false; // 문자열의 시작이 숫자인 경우 커스텀 지정자를 사용하지 않는 것이므로 false 반환.
        } else if (input.charAt(0) == CUSTOM_DELIMITER_FORMAT.charAt(0)) {
            return true; // 문자열의 시작이 커스텀 지정자 형식의 시작과 같다면 커스텀 지정자를 사용하는 것이므로 true 반환.
        }

        // 문자열의 시작이 숫자도, 커스텀 지정자 형식도 아니라면 잘못된 입력이므로 예외 발생.
        throw new IllegalArgumentException();
    }

    private static char getCustomDelimiter(String input) {
        // 입력된 문자열의 길이가 커스텀 지정자 형식의 길이보다 작다면 커스텀 지정자의 형식을 만족시키지 않는 입력이므로 예외 발생.
        if (input.length() < 5) {
            throw new IllegalArgumentException();
        }

        // 문자열의 인덱스 값을 증가시키며 입력된 문자열의 각 문자가 커스텀 지정자 형식에 맞는지 확인, 맞지 않는 인덱스가 존재한다면 예외 발생.
        for (int i = 1; i <= 4; i++) {
            if (i == 1 && input.charAt(i) != CUSTOM_DELIMITER_FORMAT.charAt(1)) {
                throw new IllegalArgumentException();
            } else if (i == 3 && input.charAt(i) != CUSTOM_DELIMITER_FORMAT.charAt(3)) {
                throw new IllegalArgumentException();
            } else if (i == 4 && input.charAt(i) != CUSTOM_DELIMITER_FORMAT.charAt(4)) {
                throw new IllegalArgumentException();
            }
        }

        // 예외가 발생하지 않고 for문이 정상적으로 실행 종료되었다면 커스텀 지정자 반환.
        return input.charAt(2);
    }

    private static int calculate(String[] numbers) {
        int sum = 0;
        try {
            // 문자열 배열에 저장된 각 숫자들을 int 타입으로 변환하여 누적 합 연산.
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        } // NumberFormatException 발생 시 배열의 요소가 숫자 형태가 아닌 잘못된 입력이 존재하는 것이므로 예외 발생.

        return sum;
    }
}