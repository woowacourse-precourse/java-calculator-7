package calculator.util;

import calculator.service.Delimiter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class DelimiterExtractor {

    private static final String MULTI_CUSTOM_DELIMIT = "\\s*,\\s*";

    public static List<String> extract(String input) {
        List<String> customDelimiters = extractCustomDelimiter(input);
        List<String> basicDelimiters = extractBasicDelimiter(input);

        return mergeDelimiters(customDelimiters, basicDelimiters);
    }

    private static List<String> extractCustomDelimiter(String input) {
        List<String> customDelimiters = new ArrayList<>();
        if (CustomDelimiterFormatParser.isCheckedFormat(input)) {
            List<String> delimiterSections = CustomDelimiterFormatParser.splitDelimiterSection(input);
            for (String section : delimiterSections) {
                customDelimiters.addAll(Arrays.asList(section.split(MULTI_CUSTOM_DELIMIT)));
            }
        }
        return customDelimiters;
    }

    private static List<String> extractBasicDelimiter(String input) {
        List<String> basicDelimiters = new ArrayList<>();
        Delimiter.getBasicDelimiters().forEach(delimiter -> {
            if (input.contains(delimiter)) {
                basicDelimiters.add(delimiter);
            }
        });

        return basicDelimiters;
    }

    private static List<String> mergeDelimiters(List<String> customDelimiters, List<String> basicDelimiters) {
        List<String> delimiters = new ArrayList<>();
        delimiters.addAll(customDelimiters);
        delimiters.addAll(basicDelimiters);

        return delimiters;
    }

}
