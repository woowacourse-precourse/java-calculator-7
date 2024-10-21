package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public String getInput() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열입니다.");
        }
        ;

        return input;
    }


    public void getOutput(int total) {
        System.out.println("결과 : " + total);
    }


}
