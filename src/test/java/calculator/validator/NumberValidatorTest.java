package calculator.validator;

import calculator.view.input.validator.NumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("NumberValidator 검증 테스트")
public class NumberValidatorTest {
    private final NumberValidator numberValidator = new NumberValidator();

    @DisplayName("구분자가 제거된 문자열에 음수가 포함되어 있으면 예외가 발생한다.")
    @Test
    void fail1() {
        String input = "-1 2 3";
        Assertions.assertThrows(IllegalArgumentException.class, () -> numberValidator.validate(input));
    }

    @DisplayName("구분자가 제거된 문자열에 잘못된 값이 포함되어 있으면 예외가 발생한다.")
    @Test
    void fail2() {
        String input = "a b";
        Assertions.assertThrows(IllegalArgumentException.class, () -> numberValidator.validate(input));
    }

}
