package calculator.validation;

public class Validator {
    private final static String EXCEOPTION_MESSAGE = "잘못된 입력입니다.";

    public static void validateSeparator(String separator){
        for (int i = 0; i < separator.length(); i++) {
            if(Character.isDigit(separator.charAt(i)))
                throw new IllegalArgumentException(EXCEOPTION_MESSAGE);
        }
    }

    public static void validateNumbers(String numbers){
        for (int i = 0; i < numbers.length(); i++) {
            if(!Character.isDigit(numbers.charAt(i)))
                throw new IllegalArgumentException(EXCEOPTION_MESSAGE);
        }
    }
}
