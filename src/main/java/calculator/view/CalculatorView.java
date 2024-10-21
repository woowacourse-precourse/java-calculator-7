package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public String displayOutput(int result) {
        String output = "결과 : " + result;
        System.out.println(output);
        return output;
    }
}
