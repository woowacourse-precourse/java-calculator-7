package calculator.validation;

public class SeparatorBetweenNumberValidation {
    private SeparatorBetweenNumberValidation() {}


    public static void validate(String numberStore) {
        if (numberStore.isEmpty()) {
            throw new IllegalArgumentException(ErrorMesaage.SEPARATOR_BETWEEN_NUMBER.getMessage());
        }
    }
}
