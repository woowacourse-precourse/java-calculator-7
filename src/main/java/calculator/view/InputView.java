package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.List;

public class InputView {

    private static final String COMMA = ",";
    private static final String COLON = ":";

    public List<Integer> getAdditionNumbers() {
        String input = Console.readLine();

        if (input.isBlank()) {
            return Collections.emptyList();
        }

        String separators = getSeparators(input);

        return null;
    }

    private String getSeparators(String input) {
        if (hasCustomSeparator(input)) {
            int separatorEndIndex = getSeparatorEndIndex(input);
            validateCustomSeparator(separatorEndIndex);

            String customSeparator = getCustomSeparator(input, separatorEndIndex);

            return COMMA + "|" + COLON + "|" + customSeparator;
        }

        return COMMA + "|" + COLON;
    }

    private boolean hasCustomSeparator(String input) {
        return input.startsWith("//");
    }

    private void validateCustomSeparator(int customSeparatorEndIndex) {
        if (customSeparatorEndIndex == -1) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }

    private int getSeparatorEndIndex(String input) {
        return input.indexOf("\n");
    }

    private String getCustomSeparator(String input, int separatorEndIndex) {
        return input.substring(2, separatorEndIndex);
    }
}
