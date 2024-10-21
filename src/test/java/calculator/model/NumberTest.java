package calculator.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.model.vo.Number;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void 수는_반드시_양수여야_한다() {
        String negative = "-1";

        assertThatIllegalArgumentException().isThrownBy(() -> Number.of(negative));
    }

}
