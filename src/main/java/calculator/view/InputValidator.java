package calculator.view;

public class InputValidator {

    private static final String DEFAULT_DELIMITER = ",|:"; 
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    public static void validateInput(String inputValue) {
        validateEmpty(inputValue);
        String delimiter = extractDelimiter(inputValue);
        validateNumbers(inputValue, delimiter);
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

    private static void validateEmpty(String inputValue) {
        if (inputValue.isEmpty()) {
            throw new IllegalArgumentException("빈 값을 입력하였습니다.");
        }
    }

    private static void validateNumbers(String inputValue, String delimiter) {
        String numbersPart;

        if (inputValue.startsWith(CUSTOM_DELIMITER_START)) {
            int newLineIndex = inputValue.indexOf(CUSTOM_DELIMITER_END);
            numbersPart = inputValue.substring(newLineIndex + 2); 
        } else {
            numbersPart = inputValue;
        }

        // 구분자를 사용하여 숫자 부분을 분리
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
    }
}
