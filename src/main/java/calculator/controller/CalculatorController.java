package calculator.controller;

import calculator.domain.CustomDelimiter;
import calculator.exception.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    private final CustomDelimiter customDelimiter;

    public CalculatorController() {
        this.customDelimiter = new CustomDelimiter();
    }

    public void run() {
        // 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 입력이 빈 문자열이거나 null인 경우 예외 발생
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }

        // 커스텀 구분자 유무 확인 및 추출
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == 2) {
                throw new IllegalArgumentException(ErrorMessage.EMPTY_CUSTOM_DELIMITER.getMessage());
            }

            if (delimiterEndIndex != -1) {
                // //와 \n 사이 구분자 추출하여 커스텀 구분자에 추가
                customDelimiter.addCustomDelimiter(input.substring(2, delimiterEndIndex));
                // 커스텀 구분자 쪽 버리고 숫자 부분만 남기기
                input = input.substring(delimiterEndIndex + 2);
            }
        }

        // 문자열 파싱에 사용할 구분자로 이루어진 정규식 생성
        String regex = customDelimiter.toRegex();

        // 정규식을 활용하여 문자로 이뤄진 부분으로 분할.
        double sum = 0;
        String[] numbers = input.split(regex);
        for (String str : numbers) {
            if (!isNumb(str)) {
                throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_VALUE.getMessage());
            }

            double num = Double.parseDouble(str);
            if (num < 0) {  // 음수 값이면 예외 발생
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_VALUE.getMessage());
            }
            sum += num;
        }

        // 결과 출력
        System.out.println("결과 : " + sum);
    }

    // 숫자로 이루어진 값이 맞는지 확인
    public static boolean isNumb(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
