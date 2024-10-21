package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class StringToNumberConverterTest {
    @Test
    void 문자열을_십진수로_변환() {
        List<String> givenNumbers = List.of("100", "1", "123456", "78", "9", "-1", "1999999999", "-1999999999", "");
        List<Integer> expected = List.of(100, 1, 123456, 78, 9, -1, 1999999999, -1999999999, 0);

        List<Integer> actual = new StringToNumberConverter().convert(givenNumbers);

        assertThat(actual).isEqualTo(expected);
    }
}