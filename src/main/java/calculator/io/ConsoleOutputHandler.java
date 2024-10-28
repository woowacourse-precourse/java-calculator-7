package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void showStartComments() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    @Override
    public void printResult(int result) {
        System.out.println("결과 : " + result);
        Console.close();
    }
}
