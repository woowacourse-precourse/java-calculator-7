package calculator.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IntegerValidatorTest {
    private final IntegerValidator validator = new IntegerValidator();

    @Test
    void 음수_검증_테스트() {
        assertThatThrownBy(() -> validator.validate(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 허용되지 않습니다");
    }


}
