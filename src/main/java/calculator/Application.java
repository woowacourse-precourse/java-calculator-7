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

        Calc calculator = new Calc();
        int totalSum = calculator.calculate(inputString, delimiterPattern);

        System.out.println("결과 : " + totalSum);
    }
}