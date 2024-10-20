package calculator.utils;

import static calculator.constant.DefaultSeparator.COLON;
import static calculator.constant.DefaultSeparator.COMMA;
import static calculator.constant.StandardIndex.FIRST_STANDARD;
import static calculator.constant.StandardIndex.SECOND_STANDARD;

import java.util.ArrayList;
import java.util.List;

public class DelimiterFilter {

    private final int STANDARD_INDEX_LENGTH = 2;
    private final int INDEX_THRESHOLD = 0;

    public boolean hasCustomDelimiter(String input) {
        int firstIndex = input.indexOf(FIRST_STANDARD.getStandard());
        int secondIndex = input.indexOf(SECOND_STANDARD.getStandard());
        return firstIndex == INDEX_THRESHOLD && secondIndex > INDEX_THRESHOLD;
    }

    public List<Character> getDelimiter(boolean hasCustomDelimiter, String input) {
        if (hasCustomDelimiter) {
            List<Character> separators = new ArrayList<>();
            int secondIndex = input.indexOf(SECOND_STANDARD.getStandard());
            for (int i = STANDARD_INDEX_LENGTH; i < secondIndex; i++) {
                separators.add(input.charAt(i));
            }
            return separators;
        }
        return new ArrayList<>(List.of(COMMA.getSeparator(), COLON.getSeparator()));
    }

    public String getPureString(String input) {
        int secondIndex = input.indexOf(SECOND_STANDARD.getStandard());

        return input.substring(secondIndex + STANDARD_INDEX_LENGTH);
    }
}
