package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 문자열 분리
        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            printResult(0);
            return;
        }

        int sum = calculateSum(input);
        printResult(sum);
    }

    // 문자열 처리
    private static int calculateSum(String input) {
        String delimiter = ",|:"; // 기본 구분자 설정

        input = input.replace("\\n", "\n");  // 줄바꿈 처리

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n"); // 구분자와 숫자 부분 분리
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
            // 커스텀 구분자 추출
            delimiter = input.substring(2, delimiterIndex);
            // 구분자 이후 숫자 부분 추출
            input = input.substring(delimiterIndex + 1);
        }

        // 숫자 분리
        String[] inputNumbers = input.split(delimiter);
        return sumNumbers(inputNumbers);
    }

    // 숫자 합 계산
    private static int sumNumbers(String[] inputNumbers) {
        int sum = 0;

        for (String number : inputNumbers) {
            number = number.trim();

            // 숫자 확인 및 예외 처리
            if (!isNumeric(number)) {
                throw new IllegalArgumentException("잘못된 입력입니다: " + number);
            }

            int integerNum = Integer.parseInt(number);

            // 음수 예외 처리
            if (integerNum < 0) {
                throw new IllegalArgumentException("양수만 입력됩니다: " + number);
            }

            sum += integerNum;
        }

        return sum;
    }

    // 숫자 여부 확인
    private static boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 결과 출력
    private static void printResult(int sum) {
        System.out.println("결과 : " + sum);
    }
}
