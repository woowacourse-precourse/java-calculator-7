package calculator.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        return readLine();
    }
    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void printError(String errorMessage) {
        System.out.println("에러: " + errorMessage);
    }
}