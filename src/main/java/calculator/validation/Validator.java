package calculator.validation;

public class Validator {
    private final static String EXCEPTION_MESSAGE = "잘못된 입력입니다.";


    public static void validateSeparator(String separator){
        for (int i = 0; i < separator.length(); i++) {
            if(Character.isDigit(separator.charAt(i)))
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public static void validateDigit(String numbers){
        for (int i = 0; i < numbers.length(); i++) {
            if(!Character.isDigit(numbers.charAt(i)))
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public static void validateNull(String input){
        if(input.isEmpty())
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }
}
