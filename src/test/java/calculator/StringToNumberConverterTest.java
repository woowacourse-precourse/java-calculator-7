package calculator;

import static calculator.StringToNumberConverter.convert;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class StringToNumberConverterTest {
    @Test
    void 문자열을_십진수로_변환() {
        List<String> list = List.of("100", "0", "10000", "92", "7", "-1", "1999999999");
        List<Integer> expected = List.of(100, 0, 10000, 92, 7, -1, 1999999999);

        List<Integer> actual = convert(list);

        assertThat(actual).isEqualTo(expected);
    }
}