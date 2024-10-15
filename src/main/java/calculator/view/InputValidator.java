package calculator.view;

public class InputValidator {
    
    private static final String DEFAULT_DELIMITER = "[,:]"; 

    public static void validateInput(String inputValue) {
        validateEmpty(inputValue); 
        String delimiter = extractDelimiter(inputValue); 
        validateNumbers(inputValue, delimiter); 
    }

    private static String extractDelimiter(String inputValue) {
        if (inputValue.startsWith("//")) { 
            int newLineIndex = inputValue.indexOf('\n'); 
            if (newLineIndex > 0) {
                String customDelimiter = inputValue.substring(2, newLineIndex).trim(); 
                return "[,:" + escapeDelimiter(customDelimiter) + "]"; 
            }
        }
        return DEFAULT_DELIMITER; 
    }

    private static String escapeDelimiter(String customDelimiter) {
        return customDelimiter.replaceAll("([.*+?^=!:${}()|\\[\\]\\/])", "\\\\$1");
    }

    private static void validateEmpty(String inputValue) {
        if (inputValue.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값을 입력하였습니다.");
        }
    }

    private static void validateNumbers(String inputValue, String delimiter) {
        for (String numStr : inputValue.split(delimiter)) { 
            try {
                int num = Integer.parseInt(numStr.trim()); 
                if (num < 0) {
                    throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다."); 
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요."); 
            }
        }
    }
}
