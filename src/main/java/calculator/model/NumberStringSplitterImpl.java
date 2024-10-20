package calculator.model;

import java.util.Arrays;
import java.util.List;

public class NumberStringSplitterImpl implements NumberStringSplitter {

    private final DelimiterManager delimiterManager;

    public NumberStringSplitterImpl(DelimiterManager delimiterManager) {
        this.delimiterManager = delimiterManager;
    }

    @Override
    public String[] split(String inputStr) {
        List<String> delimiters = delimiterManager.getDelimiters();
        String delimiterPattern = "[" + String.join("", delimiters).replaceAll("([\\W])", "\\\\$1") + "]";

        if (delimiterPattern.contains("-")) {
            inputStr = inputStr.replaceAll("--", "-00 ");

            return Arrays.stream(inputStr.split(delimiterPattern))
                    .map(part -> part.contains("00 ") ? part.replace("00 ", "-") : part)
                    .toArray(String[]::new);
        }

        return Arrays.stream(inputStr.split(delimiterPattern))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
