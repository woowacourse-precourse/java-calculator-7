package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        String custom = "//;\n1;2;3";

        int[] customNumbers = parser.parse(custom);

        assertThat(customNumbers).contains(1, 2, 3);
    }

    @Test
    void throw_on_invalid_strings() {
        String wrongDelimiter = "1;2;3";
        String floatNumber = "1.2,3.5";
        String invalidDelimiter = "//;1;2,3";

        assertThatThrownBy(() -> {
            parser.parse(wrongDelimiter);
        }).hasCause(new IllegalArgumentException());

        assertThatThrownBy(() -> {
            parser.parse(floatNumber);
        }).hasCause(new IllegalArgumentException());

        assertThatThrownBy(() -> {
            parser.parse(invalidDelimiter);
        }).hasCause(new IllegalArgumentException());
    }

}
