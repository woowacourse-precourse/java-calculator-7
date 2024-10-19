package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        int result = calculateSum(input);
    }

    public static int calculateSum(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return -1;
    }
}
