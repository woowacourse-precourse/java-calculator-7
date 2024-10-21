package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String word = Console.readLine();

    public boolean isCustomDivision() {
        return word.startsWith("//") && word.contains("\n");
    }

    public String findCustomDivision() {
        int startIndex = 2;
        int endIndex = word.indexOf("\n");
        return word.substring(startIndex, endIndex);
    }
}
