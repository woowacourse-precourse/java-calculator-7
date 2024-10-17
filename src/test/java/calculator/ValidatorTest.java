package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.IllformedLocaleException;

public class ValidatorTest {

    Validator validator = new Validator();

    @DisplayName("예외 처리 하기")
    @Test
    void checkValidateTest() {
        String[] numbers = {"k","1","2"};
        Assertions.assertThatThrownBy(() -> {
            validator.validate(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
