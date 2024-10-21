package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputMessage() {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            return Console.readLine();
        } catch (java.util.NoSuchElementException e) {
            return ""; // 빈 입력이 들어올 경우 빈 문자열 반환
        }
    }
}