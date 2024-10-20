package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        String delimiterPattern = "[,:]";

        if (inputString.startsWith("//")) {
            int endIndex = inputString.indexOf("\\n");
            if (endIndex != -1) {
                delimiterPattern = inputString.substring(2, endIndex);
                inputString = inputString.substring(endIndex + 2);
            } else {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        }

        // 잘못된 입력 처리 (숫자와 구분자만 허용)
        // 구분자를 허용한 숫자 패턴을 구성
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

        // SumCalculator 인스턴스 생성
        SumCalculator calculator = new SumCalculator();
        int totalSum = calculator.calculate(inputString, delimiterPattern);

        System.out.println("결과 : " + totalSum);
    }
}