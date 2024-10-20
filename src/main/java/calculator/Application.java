package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = addNumbers(input);
        System.out.println("결과 : " + result);
    }

    private static int addNumbers(String input) {
        // 빈 문자열 처리
        if (input.isEmpty()) {
            return 0;
        }

        // 사용자 정의 구분자 확인
        String delimiter = "[,:]"; // 기본 구분자
        if (input.startsWith("//")) {
            delimiter = input.substring(2, 3);
            // 사용자 정의 구분자가 여러 문자일 수 있으므로 정규 표현식으로 감싸기
            input = input.substring(5); // 문자열에서 구분자 부분 제거
        }

        // 구분자를 사용하여 숫자 분리
        String[] numbers = input.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            int num = parseNumber(number.trim());
            sum += num;
        }

        return sum;
    }


    private static int parseNumber(String number) {
        if (number.isEmpty()) {
            return 0; // 빈 문자열일 경우 0으로 처리
        }
        try {
            int num = Integer.parseInt(number);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 잘못되었습니다: " + number);
        }
    }
}
