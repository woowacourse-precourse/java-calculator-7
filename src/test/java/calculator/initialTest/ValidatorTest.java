package calculator.initialTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {


    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    void 검증_숫자는양수만가능(String input) {
        Validator.validatePositiveNumber(Integer.parseInt(input));

    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "0", "-1"})
    void 검증_숫자가양수가아닐경우(String input) {

        int number = Integer.parseInt(input);
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validator.validatePositiveNumber(number));

    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "", "2", "3"})
    void 검증_숫자가없을경우(String input) {

        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {

        }

    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n"})
    void 검증_n다음_내용이없을케이스(String input) {
        System.out.println(input);
        Assertions.assertFalse(Validator.isInputHaveNextToken(input));
    }


}


class Validator {

    public static void validatePositiveNumber(int number) {

        if (number <= 0) {
            throw new IllegalArgumentException();
        }

    }

    public static boolean isInputHaveNextToken(String input) {

        if (input.split("\\\\n").length == 1) {
            return false;
        }

        return true;

    }
}
