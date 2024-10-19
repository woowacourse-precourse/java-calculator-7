package calculator.View;

import calculator.Message.IOMessage;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public String getInput() { // 사용자 입력을 받음
        System.out.println(IOMessage.INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        return input;
    }

    public void showResult(int sum) { // 결과를 출력
        System.out.printf(IOMessage.OUTPUT_MESSAGE.getMessage() + sum);
    }

    public void showError(String message) { // 오류 메시지를 출력
        System.out.println("오류: " + message);
    }
}
