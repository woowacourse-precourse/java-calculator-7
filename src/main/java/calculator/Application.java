package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();  // 사용자 입력 받기

        String delimiterPattern = "[,:]";  // 기본 구분자 설정

        // 커스텀 구분자 확인 및 처리
        if (inputString.startsWith("//")) {
            int endIndex = inputString.indexOf("\\n");  // 문자로서의 "\n"을 찾음
            if (endIndex != -1) {
                delimiterPattern = inputString.substring(2, endIndex);  // 커스텀 구분자 추출
                inputString = inputString.substring(endIndex + 2);  // "\n" 뒤의 문자열 추출
            } else {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        }

        // 잘못된 입력 처리 (숫자와 구분자만 허용)
        String validInputPattern = "[0-9" + delimiterPattern + " ]*";
        if (!inputString.matches(validInputPattern)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자와 구분자만 포함되어야 합니다.");
        }

        String[] numbers = inputString.split(delimiterPattern);
        for (String number : numbers) {
            number = number.trim();
            if (!number.isEmpty()) {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
                }
            }
        }

        Calc calculator = new Calc();
        int totalSum = calculator.calculate(inputString, delimiterPattern);

        System.out.println("결과 : " + totalSum);
    }
}