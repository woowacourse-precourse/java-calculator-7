package calculator.service;

import static calculator.util.Const.SUFFIX;
import static calculator.util.Const.SUFFIX_SIZE;

import calculator.domain.OriginalString;

public class StringParser {

    public String parseInput(OriginalString originalString, boolean hasCustom) {
        if (hasCustom) {
            int indexOfSplitDelimiter = originalString.value().indexOf(SUFFIX);
            return originalString.value().substring(indexOfSplitDelimiter + SUFFIX_SIZE);
        }
        return originalString.value();
    }
}
