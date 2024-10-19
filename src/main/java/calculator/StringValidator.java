package calculator;

public class StringValidator {
    
    public static String customDelimiterValidator(String userInput) throws IllegalArgumentException {
        for (Delimiter delimiter : Delimiter.values()) {
            if (userInput.contains(delimiter.getDelimiter())) {
                return delimiter.getDelimiter();
            }
        }
        throw new IllegalArgumentException();
    }

}
