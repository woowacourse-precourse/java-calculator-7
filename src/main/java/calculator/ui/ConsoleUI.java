package calculator.ui;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleUI implements UserInterface{

    @Override
    public void displayPrompt() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    @Override
    public String getInput() {
        return Console.readLine();
    }

    @Override
    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }
}
