package calculator;


public class Delimiter {

    private static final String BASE_DELIMITER = ",|:";
    private final StringBuilder customDelimiters = new StringBuilder(BASE_DELIMITER);

    public Delimiter() {
    }

    public void addCustomDelimiter(String customDelimiter) {
        for (int i = 0; i < customDelimiter.length(); i++) {
            char target = customDelimiter.charAt(i);
            if (Character.isDigit(target)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_INPUT.getMessage());
            }
            customDelimiters.append("|").append(target);
        }
    }

    public String getRegex() {
        return customDelimiters.toString();
    }
}
