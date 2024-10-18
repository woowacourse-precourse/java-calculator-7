package calculator;

import java.util.Arrays;

public class NumberExtractor {

    private final String baseText;

    public NumberExtractor(String baseText) {
        this.baseText = baseText;
    }

    public int extractNumber() {
        if (validateBaseText()) {
            return 0;
        }

        return Arrays.stream(baseText.split("[,:]"))
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .sum();
    }

    private boolean validateBaseText() {
        return baseText == null || baseText.isBlank();
    }
}
