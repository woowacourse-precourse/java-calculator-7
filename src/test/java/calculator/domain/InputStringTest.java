package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputStringTest {

    @ParameterizedTest
    @DisplayName("InputString은_커스텀_구분자를_추출할_수_있다")
    @CsvSource(value = {"//a\\n123 : a", "//3\\n123 : 3", "//;\\n34 : ;"}, delimiterString = " : ")
    public void extractCustomDelimiter(String input, String expected) {
        //given
        InputString inputString = new InputString(input);

        //when
        CustomDelimiter result = inputString.extractCustomDelimiter();

        //then
        assertThat(result.getValue())
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("InputString은_커스텀_구분자가_존재하지_않을_경우_null을_가지는_CustomDelimiter를_반환한다")
    public void extractCustomDelimiter_notExists() {
        //given
        InputString inputString = new InputString("123");

        //when
        CustomDelimiter result = inputString.extractCustomDelimiter();

        //then
        assertThat(result.getValue())
                .isNull();
    }

    @ParameterizedTest
    @DisplayName("InputString은_계산_문자열을_추출할_수_있다")
    @CsvSource(value = {"12345 : 12345", "//;\\n34 : 34", "//a\\n3:4,5,6a : 3:4,5,6a"}, delimiterString = " : ")
    public void extractCalculationString(String input, String expected) {
        //given
        InputString inputString = new InputString(input);

        //when
        CalculationString result = inputString.extractCalculationString();

        //then
        assertThat(result.equals(expected))
                .isTrue();
    }
}