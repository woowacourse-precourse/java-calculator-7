package calculator.view;

public class InputValidator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    public static void validateInput(String inputValue) {
        String delimiter = extractDelimiter(inputValue);
    }

    public static String extractDelimiter(String inputValue) {
        if (inputValue.startsWith(CUSTOM_DELIMITER_START)) {
            int separatorIdx = inputValue.indexOf(CUSTOM_DELIMITER_END);
            if (separatorIdx > 0) {
                String customDelimiter = inputValue.substring(2, separatorIdx).trim();
                return customDelimiter;
            }
        }
        return DEFAULT_DELIMITER;
    }
    
    public static String validateNumbers(String inputValue, String delimiter) {
        String numbersPart;

        if (inputValue.startsWith(CUSTOM_DELIMITER_START)) {
            int newLineIndex = inputValue.indexOf(CUSTOM_DELIMITER_END);
            numbersPart = inputValue.substring(newLineIndex + 2);
        } else {
            numbersPart = inputValue;
        }

        for (String numStr : numbersPart.split(delimiter)) {
            try {
                int num = Integer.parseInt(numStr.trim());
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않는 숫자 형식입니다.");
            }
        }
        return numbersPart;
    }
}
