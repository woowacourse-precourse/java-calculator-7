package calculator.util.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputStringParserTest {


    @Test
    @DisplayName("구분자를 추출한다.")
    void extractDelimiterTest() throws Exception {
        //given
        final String format = "//%s\\n";
        final String customDelimiter1 = ".";
        final String customDelimiter2 = "a";
        final String customDelimiter3 = ";";
        final String customDelimiter4 = "9";
        final StringParser inputStringParser = new InputStringParser();
        //when
        final String extractedCustomDelimiter1 = inputStringParser.extractCustomDelimiter(
                String.format(format, customDelimiter1));
        final String extractedCustomDelimiter2 = inputStringParser.extractCustomDelimiter(
                String.format(format, customDelimiter2));
        final String extractedCustomDelimiter3 = inputStringParser.extractCustomDelimiter(
                String.format(format, customDelimiter3));
        final String extractedCustomDelimiter4 = inputStringParser.extractCustomDelimiter(
                String.format(format, customDelimiter4));

        //then
        assertAll(
                () -> assertThat(extractedCustomDelimiter1).isEqualTo(customDelimiter1),
                () -> assertThat(extractedCustomDelimiter2).isEqualTo(customDelimiter2),
                () -> assertThat(extractedCustomDelimiter3).isEqualTo(customDelimiter3),
                () -> assertThat(extractedCustomDelimiter4).isEqualTo(customDelimiter4)
        );

    }

}