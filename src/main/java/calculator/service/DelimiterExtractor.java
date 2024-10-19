package calculator.service;

import calculator.util.CustomDelimiterFormatParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimiterExtractor {

    private static final String MULTI_CUSTOM_DELIMIT = "\\s*,\\s*";

    private final CustomDelimiterFormatParser formatParser;
    private final List<String> delimiters;

    public DelimiterExtractor() {
        this.formatParser = new CustomDelimiterFormatParser();
        this.delimiters = new ArrayList<>();
    }

    public List<String> extract(String input) {
        if (formatParser.isCheckedFormat(input)) {
            extractCustomDelimiter(input);
        }
        extractBasicDelimiter(input);

        return delimiters;
    }

    private void extractCustomDelimiter(String input) {
        List<String> delimiterSections = formatParser.splitDelimiterSection(input);

        for (String section : delimiterSections) {
            delimiters.addAll(Arrays.asList(section.split(MULTI_CUSTOM_DELIMIT)));
        }
    }

    private void extractBasicDelimiter(String input) {
        Delimiter.getBasicDelimiters().forEach(delimiter -> {
            if (input.contains(delimiter)) {
                delimiters.add(delimiter);
            }
        });
    }

}
