package calculator.utils;

import static calculator.constant.StandardIndex.FIRST_STANDARD;
import static calculator.constant.StandardIndex.SECOND_STANDARD;

public class DelimiterFilter {

    public boolean hasCustomDelimiter(String input) {
        int firstIndex = input.indexOf(FIRST_STANDARD.getStandard());
        int secondIndex = input.indexOf(SECOND_STANDARD.getStandard());
        return firstIndex == 0 && secondIndex > 0;
    }
}
