package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {

    @DisplayName("숫자 생성자를 확인한다.")
    @Test
    void createNumber() {
        Number number = new Number(1);

        assertThat(number).extracting(Number::getValue)
            .isEqualTo(1);
    }

    @DisplayName("숫자는 음수 일 수 없다.")
    @Test
    void numberIsNotNegative() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(-1))
            .withMessage("음수는 입력할 수 없습니다.");
    }

}