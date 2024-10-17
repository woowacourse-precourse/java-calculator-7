package calculator.utils;

import static calculator.constant.DefaultSeparator.COLON;
import static calculator.constant.DefaultSeparator.COMMA;
import static calculator.constant.StandardIndex.FIRST_STANDARD;
import static calculator.constant.StandardIndex.SECOND_STANDARD;

import java.util.ArrayList;
import java.util.List;

public class DelimiterFilter {

    public boolean hasCustomDelimiter(String input) {
        int firstIndex = input.indexOf(FIRST_STANDARD.getStandard());
        int secondIndex = input.indexOf(SECOND_STANDARD.getStandard());
        return firstIndex == 0 && secondIndex > 0;
    }

    public List<Character> getDelimiter(boolean hasCustomDelimiter, String input) {
        if (hasCustomDelimiter) {
            List<Character> separators = new ArrayList<>();
            int secondIndex = input.indexOf(SECOND_STANDARD.getStandard());
            for (int i = 2; i < secondIndex; i++) {
                separators.add(input.charAt(i));
            }
            return separators;
        }
        return new ArrayList<>(List.of(COMMA.getSeparator(), COLON.getSeparator()));
    }
}
