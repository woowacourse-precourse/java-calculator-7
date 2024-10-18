package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String inputString = "";

    public InputView() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputString = Console.readLine();
    }

    public String getInputString(){
        return this.inputString;
    }
}
