package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    @Test
    void toStringArrTest() {
        // given
        final Converter converter = new Converter();
        final String input = "//.\\n1.47.1.33.1.3";
        // when
        String[] stringArr = converter.toStringArr(input); // {1,2,3,4,5}
        // then
        assertThat(stringArr).containsExactly("1", "47", "1", "33", "1", "3");
    }
}
