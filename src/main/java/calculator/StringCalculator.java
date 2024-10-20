package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    String userInput;

    public void getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.userInput = Console.readLine();
        System.out.println("사용자 입력값 : " + this.userInput); //메서드 기능 점검용 코드 - 추후 삭제
    }
}