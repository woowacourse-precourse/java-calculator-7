package calculator.service;

import calculator.domain.OriginalString;

public class StringParser {

    public String parseInput(OriginalString originalString, boolean hasCustom) {
        if (hasCustom) {
            int indexOfSplitDelimiter = originalString.value().indexOf("\\n");
            return originalString.value().substring(indexOfSplitDelimiter + 2);
        }
        return originalString.value();
    }
}
