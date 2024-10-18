package calculator.number.util;

import calculator.constant.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class NumberConvertorTest {
    @Test
    void stringToLongBlankIsZeroTest() {
        String s = "1213";
        assertThat(NumberConvertor.stringToLongBlankIsZero(s))
                .isEqualTo(1213L);
        String blank = "";
        assertThat(NumberConvertor.stringToLongBlankIsZero(blank))
                .isEqualTo(0);
    }
    @Test
    void stringToLongMaxValueTest() {
        String s = "1213s";
        assertThatThrownBy(() -> NumberConvertor.stringToLongBlankIsZero(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
        String blank = "";
        assertThat(NumberConvertor.stringToLongBlankIsZero(blank))
                .isEqualTo(0);
    }

}
