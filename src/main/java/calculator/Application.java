package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        // 커스텀 구분자가 있는 경우
        if (input.startsWith("//")) {
            SeparatorManager separatorManager = new SeparatorManager();
            separatorManager.processInput(input);
        }
    }
}