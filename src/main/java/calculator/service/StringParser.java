package calculator.service;

import calculator.domain.OriginalString;

public class StringParser {

    public String parseInput(OriginalString originalString, boolean hasCustom) {
        if (hasCustom) {
            return originalString.value().split("\\n")[1];
        }
        return originalString.value();
    }
}
