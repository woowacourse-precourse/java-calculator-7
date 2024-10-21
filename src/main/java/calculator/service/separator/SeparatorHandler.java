package calculator.service.separator;

import calculator.domain.number.Numbers;
import calculator.domain.separator.BasicSeparator;
import calculator.domain.separator.CustomSeparator;

public class SeparatorHandler {

    private static final String PREFIX_CUSTOM_SEPARATOR = "//";
    private static final String SUFFIX_CUSTOM_SEPARATOR = "\\\\n";
    private final SeparatorService separatorService;

    public SeparatorHandler(SeparatorService separatorService) {
        this.separatorService = separatorService;
    }

    public Numbers process(String input) {
        if (hasCustomSeparator(input)) {
            return separatorService.separate(
                    new CustomSeparator(extractCustomSeparator(input)),
                    extractValue(input)
            );
        }

        return separatorService.separate(new BasicSeparator(), input);
    }

    private boolean hasCustomSeparator(String input) {
        return input.startsWith(PREFIX_CUSTOM_SEPARATOR);
    }

    private String extractCustomSeparator(String input) {
        return removePrefix(splitBySuffix(input)[0]);
    }

    private String extractValue(String input) {
        String[] values = splitBySuffix(input);

        if (values.length == 1) {
            return "";
        }

        return values[values.length - 1];
    }

    private String removePrefix(String separator) {
        return separator.substring(PREFIX_CUSTOM_SEPARATOR.length());
    }

    private String[] splitBySuffix(String input) {
        return input.split(SUFFIX_CUSTOM_SEPARATOR);
    }
}
