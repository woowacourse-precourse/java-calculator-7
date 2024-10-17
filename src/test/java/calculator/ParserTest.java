package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

/**
 * ParserTest
 */
public class ParserTest {

    private Parser parser = new Parser();

    @Test
    void parse_normal_strings() {
        String comma = "1,2,3";
        String colon = "3:4:5";
        String composite = "5,6:7";

        int[] commaNumbers = parser.parse(comma);
        int[] colonNumbers = parser.parse(colon);
        int[] compositeNumbers = parser.parse(composite);

        assertThat(commaNumbers).contains(1, 2, 3);
        assertThat(colonNumbers).contains(3, 4, 5);
        assertThat(compositeNumbers).contains(5, 6, 7);
    }

    @Test
    void parse_string_with_custom_delimiter() {
        String custom = "//;\\n1;2;3";

        int[] customNumbers = parser.parse(custom);

        assertThat(customNumbers).contains(1, 2, 3);
    }

    @Test
    void throw_on_invalid_strings() {
        String wrongDelimiter = "1;2;3";
        String floatNumber = "1.2,3.5";
        String invalidDelimiter = "//;\\n1;2,3";
        String negativeNumber = "-1,-2";

        Throwable wrongDelimiterException = catchThrowable(() -> { parser.parse(wrongDelimiter); });
        Throwable floatNumberException = catchThrowable(() -> { parser.parse(floatNumber); });
        Throwable invalidDelimiterException = catchThrowable(() -> { parser.parse(invalidDelimiter); });
        Throwable negativeNumberException = catchThrowable(() -> { parser.parse(negativeNumber); });

        assertThat(wrongDelimiterException).isInstanceOf(IllegalArgumentException.class);
        assertThat(floatNumberException).isInstanceOf(IllegalArgumentException.class);
        assertThat(invalidDelimiterException).isInstanceOf(IllegalArgumentException.class);
        assertThat(negativeNumberException).isInstanceOf(IllegalArgumentException.class);
    }

}
