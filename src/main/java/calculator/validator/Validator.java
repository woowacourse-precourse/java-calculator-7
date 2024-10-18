package calculator.validator;

public class Validator {


    public static void validate(int number) {

        if (number <= 0) {
            throw new IllegalArgumentException();
        }

    }


}
