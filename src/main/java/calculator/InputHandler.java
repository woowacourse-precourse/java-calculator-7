package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler { //TODO: 사용자의 입력이 올바른지 판단
    public static String getInput() {
        return readLine();
    }

    public static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }
}
