package calculator.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void 빈_문자열_예외처리() {
        String input = "";
        Assertions.assertThatThrownBy(() -> Validator.isEmpty(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
