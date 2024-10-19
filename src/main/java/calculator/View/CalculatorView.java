package calculator.View;

import calculator.Message.IOMessage;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public String getInput() { // 사용자 입력을 받음
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    public void showResult(int sum) { // 결과를 출력
        System.out.printf("결과 : %d", sum);
    }

    public void showError(String message) { // 오류 메시지를 출력
        System.out.println("오류: " + message);
    }
}
