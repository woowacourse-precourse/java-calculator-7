package calculator.util;

import java.util.HashSet;
import java.util.Set;

public abstract class SeparatorUtils {
    private static final Set<String> separators = new HashSet<>(Set.of(",", ":"));

    public static Set<String> getSeparators() {
        return separators;
    }

    public static String parseSeparators(String input) {
        if (input.startsWith("//")) {
            input = input.replace("\\n", "\n"); // \n을 개행문자로 변환
            int newLineIndex = input.indexOf("\n");

            if (newLineIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            String separatorsPart = input.substring(2, newLineIndex);
            for (char c : separatorsPart.toCharArray()) {
                separators.add(String.valueOf(c));
            }

            return input.substring(newLineIndex + 1);
        }

        return input;
    }
}