package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String inputString;

    public InputView() {
        this.inputString = readInput();  // 별도의 메서드로 입력 처리
    }

    private String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public String getInputString(){
        return this.inputString;
    }
}
