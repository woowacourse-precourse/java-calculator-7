package calculator.domain.value;

import calculator.domain.model.value.PositiveNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveNumberTest {


    @DisplayName("사용자가 입력한 숫자가 0 이하인 경우 예외를 발생시킨다")
    @Test
    void positiveNumberTest() {

        Assertions.assertThatThrownBy(() -> new PositiveNumber(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
