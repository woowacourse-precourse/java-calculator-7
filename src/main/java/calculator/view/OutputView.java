package calculator.view;

import calculator.util.io.IOConsole;

public class OutputView {

    public void printBeforeReadUserInput() {
        IOConsole.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void printSumResult(Object result) {
        IOConsole.print("결과 : " + result);
    }
}
