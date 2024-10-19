package calculator;

public class NumberValidator {
    private static final String NEGATIVE_NUMBER_ERROR = "음수는 허용되지 않습니다: %d";

    public static void validate(int number) {
        if(number < 0){
            throw new IllegalArgumentException(String.format(NEGATIVE_NUMBER_ERROR, number));
        }
    }
}
