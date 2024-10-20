package calculator.validation;

public class ZeroIsNotPositiveValidation {
    private ZeroIsNotPositiveValidation() {
    }

    public static void validate(String numberStore) {
        if (!numberStore.isEmpty()&&Integer.parseInt(numberStore)==0) {
            throw new IllegalArgumentException(ErrorMesaage.ZERO_IS_NOT_POSITIVE.getMessage());
        }
    }
}
