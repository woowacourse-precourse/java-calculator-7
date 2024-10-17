package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        // 커스텀 구분자가 있는 경우
        if (input.startsWith("//")) {
            SeparatorManager separatorManager = new SeparatorManager();
            separatorManager.processInput(input);

            String numberString = separatorManager.getNumberString();
            ArrayList<String> separators = separatorManager.getSeparators();

            NumberManager numberManager = new NumberManager();
            numberManager.numberInput(numberString, separators);
        }

    }
}