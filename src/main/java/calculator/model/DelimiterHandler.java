package calculator.model;

import calculator.common.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class DelimiterHandler {
    private final List<String> delimiters = new ArrayList<>();

    public DelimiterHandler() {
        init();
    }

    private void init() {
        delimiters.add(",");
        delimiters.add(":");
    }

    public void addCustomDelimiter(String delimiter) {
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CUSTOM_DELIMITER.getMessage());
        }
        if (!delimiters.contains(delimiter)) {
            delimiters.add(delimiter);
        }
    }

    public List<String> getDelimiters() {
        return new ArrayList<>(delimiters);
    }
}
