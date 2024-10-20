package calculator.number.util;

import calculator.validator.constant.ErrorMessage;
import calculator.number.util.impl.DoubleConvertor;
import calculator.number.util.impl.LongConvertor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class NumberConvertorTest {
    @Test
    void stringToLongBlankIsZeroTest() {
        String s = "1213";
        NumberConvertorService longConvertor = new LongConvertor();
        assertThat(longConvertor.stringToNumberBlankIsZero(s))
                .isEqualTo(1213L);
        String blank = "";
        assertThat(longConvertor.stringToNumberBlankIsZero(blank))
                .isEqualTo(0L);
    }
    @Test
    void stringToLongMaxValueTest() {
        String s = "121321312312312312312";
        NumberConvertorService longConvertor = new LongConvertor();
        assertThatThrownBy(() -> longConvertor.stringToNumberBlankIsZero(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MAX_VALUE_ERROR);
    }

    @Test
    void stringToDoubleBlankIsZeroTest() {
        String s = "12.13";
        NumberConvertorService doubleConvertor = new DoubleConvertor();
        assertThat(doubleConvertor.stringToNumberBlankIsZero(s))
                .isEqualTo(12.13);
    }
}
