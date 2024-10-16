package calculator.viewer;

import calculator.entity.Input;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {

    public void displayMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

    }

    public void result(Integer total) {
        System.out.println("결과 : " + total.toString());
    }

    public Input input() {
        return new Input(Console.readLine());
    }

}
