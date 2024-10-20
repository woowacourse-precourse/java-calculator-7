package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputStringTest {

    @Test
    @DisplayName("InputString은_커스텀_구분자가_존재하는_경우_커스텀_구분자를_추출할_수_있다")
    public void extractCustomDelimiter() {
        //given
        InputString inputString = new InputString("//;\\n34");

        //when
        CustomDelimiter result = inputString.extractCustomDelimiter();

        //then
        assertThat(result.getValue())
                .isEqualTo(";");
    }

    @Test
    @DisplayName("InputString은_커스텀_구분자가_존재하지_않으면_null을_반환한다")
    public void extractCustomDelimiterReturnNull() {
        //given
        InputString inputString = new InputString("34");

        //when
        CustomDelimiter result = inputString.extractCustomDelimiter();

        //then
        assertThat(result).isNull();
    }

    @Test
    @DisplayName("InputString은_계산_문자열을_추출할_수_있다")
    public void extractCalculationString() {
        //given
        InputString inputString = new InputString("//;\\n34");

        //when
        CalculationString result = inputString.extractCalculationString();

        //then
        assertThat(result.equals("34"))
                .isTrue();
    }
}