package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            String input = Console.readLine();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
