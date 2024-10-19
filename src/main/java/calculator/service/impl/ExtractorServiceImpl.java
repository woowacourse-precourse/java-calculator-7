package calculator.service.impl;

import static calculator.constant.DelimiterConstant.*;

import calculator.model.Operand;
import calculator.service.ExtractorService;
import java.util.regex.Pattern;

public class ExtractorServiceImpl implements ExtractorService {

    @Override
    public Operand extract(String input) throws IllegalArgumentException {
        if (input == null || input.isEmpty()) {
            return Operand.create(DEFAULT_DELIMITERS, "");
        }

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterEndIndex = input.lastIndexOf(CUSTOM_DELIMITER_SUFFIX);
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("Invalid input format");
            }

            String customDelimiter = input.substring(2, delimiterEndIndex);
            if (customDelimiter.isEmpty()) {
                return Operand.create(DEFAULT_DELIMITERS, input.substring(delimiterEndIndex + 2));
            }

            String[] delimitersArray = customDelimiter.split("");

            StringBuilder delimiterPattern = new StringBuilder();
            for (String delimiter : delimitersArray) {
                if (isNumeric(delimiter)) {
                    throw new IllegalArgumentException("Custom delimiter cannot be a number: " + delimiter);
                }
                delimiterPattern.append(Pattern.quote(delimiter)).append("|");
            }

            delimiterPattern.append(DEFAULT_DELIMITERS);

            return Operand.create(delimiterPattern.toString(), input.substring(delimiterEndIndex + 2));
        }

        return Operand.create(DEFAULT_DELIMITERS, input);
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
