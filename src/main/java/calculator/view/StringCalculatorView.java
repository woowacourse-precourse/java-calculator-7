package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculatorView implements View {

    @Override
    public String displayInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public void displayOutput(String output) {
        System.out.printf("결과 : %s\n", output);
    }
}
