package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        if (input.isBlank()) {
            System.out.println(0);
            return;
        }
    }
}