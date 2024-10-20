package calculator.delimiter;

import calculator.delimiter.impl.ColonDelimiter;
import calculator.delimiter.impl.CommaDelimiter;
import calculator.delimiter.impl.CustomDelimiter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Delimiters {
    private static final String SPACE_STRING = " ";

    private final List<Delimiter> delimiters = new ArrayList<>();

    public Delimiters(String delimiter) {
        addDefaultDelimiters();
        addCustomDelimiters(delimiter);
    }

    private void addDefaultDelimiters() {
        delimiters.add(new ColonDelimiter());
        delimiters.add(new CommaDelimiter());
    }

    public void addCustomDelimiters(final String delimiter) {
        delimiters.add(new CustomDelimiter(delimiter));
    }

    public String replace(final String input) {
        String s = input;
        for (Delimiter delimiter : delimiters) {
            if (delimiter.isApplicable()) {
                String regex = "(?<=\\d)" + Pattern.quote(delimiter.getDelimiter()) + "(?=\\d)";
                s = s.replaceAll(regex, SPACE_STRING);
            }
        }
        return s;
    }
}
