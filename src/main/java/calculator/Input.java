package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String word = Console.readLine();

    private boolean isCustomDivision() {
        return word.startsWith("//") && word.contains("\\n");
    }

    public String findCustomDivision() {
        if (isCustomDivision()) {
            int startIndex = 2;
            int endIndex = word.indexOf("\\n");
            return word.substring(startIndex, endIndex);
        }
        return null;
    }

    public String numbers() {
        if (isCustomDivision()) {
            return word.substring(word.indexOf("\\n") + 2);
        }
        return word;
    }
}