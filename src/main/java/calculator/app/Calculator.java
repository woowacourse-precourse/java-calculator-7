package calculator.app;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Calculator {
    private static StringChecker stringChecker = new StringChecker();

    public void start() {
        String input = Console.readLine();
        List<Character> separatorList = stringChecker.checkCustomSeparator(input);
        List<Integer> integerList = List.of();
        try {
            if (separatorList.size() == 3) {
                integerList = stringChecker.checkExpressionValidation(input.substring(5), separatorList);
            } else if (separatorList.size() == 2) {
                integerList = stringChecker.checkExpressionValidation(input, separatorList);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
