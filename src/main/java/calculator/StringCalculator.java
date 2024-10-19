package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class StringCalculator {
    public void run() {
        String input = askForStringInput();
    }

    private String askForStringInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return readLine();
    }
}
