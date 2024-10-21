package calculator.model.vo;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void 수는_반드시_양수여야_한다() {
        String negative = "-1";

        assertThatIllegalArgumentException().isThrownBy(() -> Number.of(negative));
    }

    @Test
    void 빈문자열_입력되면_0을_반환한다() {
        String empty = "";

        Number test = Number.of(empty);

        assertEquals("0", test.toString());
    }

    @Test
    void Number는_동등성을_보장한다() {
        Number one = Number.of("10");
        Number another = Number.of("10");

        assertTrue(one.equals(another));
    }

}
