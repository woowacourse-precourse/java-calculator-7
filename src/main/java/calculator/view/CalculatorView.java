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
        if (startIndex == 0 && endIndex != -1) {
            for (int i = startIndex + 2; i < endIndex; i++) {
                if ('0' <= input.charAt(i) && input.charAt(i) <= '9') {
                    throw new IllegalArgumentException("구분자에 숫자가 들어가면 안됩니다.");
                }
            }
            separator += input.substring(startIndex + 2, endIndex);
            input = input.substring(endIndex + 2);
        }

        return input.split("[" + separator + "]");
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
