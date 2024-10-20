package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public String[] getDigits() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String separator = ",:";

        //커스텀 구분자
        int startIndex = input.indexOf("//"); //정규표현식도 고려해볼 것
        int endIndex = input.indexOf("\\n");
        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            separator += input.substring(startIndex + 2, endIndex);
            input = input.substring(endIndex + 2);
        }

        return input.split("[" + separator + "]");
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
