package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    void run() {
        printInputMsg();
        String input = Console.readLine();
    }

    void printInputMsg() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

}
