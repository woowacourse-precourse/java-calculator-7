package calculator.model.delimiter;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private static final String EMPTY = "";

    private List<Delimiter> delimiters;

    public Delimiters(String input) {
        setDefaultDelimiter();
        addCustomDelimiters(input);
    }

    private void setDefaultDelimiter() {
        delimiters = new ArrayList<>();

        for (DefaultDelimiterType delimiterType : DefaultDelimiterType.values()) {
            delimiters.add(new DefaultDelimiter(delimiterType.getValue()));
        }
    }

    private void addCustomDelimiters(String input) {
        while (true) {
            CustomDelimiter customDelimiter = new CustomDelimiter(input);

            if (!customDelimiter.isApplicable(input)) {
                break;
            }
            delimiters.add(customDelimiter);

            input = input.replace(customDelimiter.getCustomDelimiterPattern(), EMPTY);
        }
    }

    public List<Delimiter> getDelimiters() {
        return delimiters;
    }
}
