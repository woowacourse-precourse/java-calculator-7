package calculator.view.screen;

import camp.nextstep.edu.missionutils.Console;

public class Screen {

    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
        return userInput;
    }

    public void showResult(String result) {
        System.out.println("결과 : " + result);
    }
}
