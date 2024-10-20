package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputReader {

    public static String readInput() {

        String input = readLine();
        validateInput(input);

        return input;
    }

    private static void validateInput(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("사용자의 입력이 없거나 공백입니다.");
        }
    }
}