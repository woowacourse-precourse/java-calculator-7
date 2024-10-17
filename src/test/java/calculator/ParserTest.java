package calculator;

import static org.assertj.core.api.Assertions.assertThat;

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
}
