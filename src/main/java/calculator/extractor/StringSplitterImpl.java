package calculator.extractor;

import calculator.exception.ExceptionMessage;

public class StringSplitterImpl implements StringSplitter {

    @Override
    public String[] split(String input) {
        if (input == null || input.isEmpty() || input.equals("\"\"")) {
            return new String[]{""};
        }
        if (input.startsWith("//")) {
            return CustomDelimiter(input);
        }
        return DefaultDelimiter(input);
    }

    private String[] DefaultDelimiter(String input) {
        validateDelimiter(input);

        String[] result = input.split("[,:]");
        for (int i = 0; i < result.length; i++) {
            if (result[i] == null || result[i].isEmpty()) {
                result[i] = "";
            }
        }
        return result;
    }

    private String[] CustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DELIMITER_FORMAT.getMessage());
        }

        String customDelimiter = input.substring(2, delimiterEndIndex);
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_DELIMITER.getMessage());
        }
        return input.substring(delimiterEndIndex + 2).split(customDelimiter);
    }

    private void validateDelimiter(String input) {
        boolean containsInvalidDelimiter =
                input.matches(".*[\\|\\\\\\n\\t\\r\\f\\s].*") || input.matches(".*[^0-9a-zA-Z,:-].*");

        if (containsInvalidDelimiter) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DELIMITER_FORMAT.getMessage());
        }
    }
}
