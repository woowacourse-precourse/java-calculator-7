package calculator.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.model.domain.CustomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @DisplayName("구분자 사이에 문자를 넣으면 예외를 발생시킨다.")
    @Test
    void validateNumberFormat() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                CustomNumber.fromString("1,ss,2");
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }
}
