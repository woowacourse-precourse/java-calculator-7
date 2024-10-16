package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class UtilsTest {

    @Test
    @DisplayName("숫자와 문자를 구분할 수 있다")
    public void checkNumber() {
        assertSoftly(softly -> {
            softly.assertThat(Utils.isNumeric("12")).isTrue();
            softly.assertThat(Utils.isNumeric("ab")).isFalse();
            softly.assertThat(Utils.isNumeric("@")).isFalse();
        });
    }
}
