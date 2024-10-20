package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DelimitersTest {

    @ParameterizedTest
    @DisplayName("Delimiters는_커스텀_구분자를_유무를_고려하여_정규표현식을_반환할_수_있다")
    @CsvSource(value = {"//:|,", "t//:|,|t", "1//:|,|1", "+//:|,|\\+"}, delimiterString = "//")
    public void convertToRegex(String input, String expected) {
        //given
        CustomDelimiter customDelimiter = new CustomDelimiter(input);

        //when
        String result = new Delimiters(customDelimiter).convertToRegex();

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Delimiters는_공백문자인_커스텀_구분자를_고려하여_정규표현식을_반환할_수_있다")
    public void convertToRegex_CanConsiderBlankDelimiter() {
        //given
        CustomDelimiter customDelimiter = new CustomDelimiter(" ");

        //when
        String result = new Delimiters(customDelimiter).convertToRegex();

        //then
        assertThat(result).isEqualTo(":|,| ");
    }
}