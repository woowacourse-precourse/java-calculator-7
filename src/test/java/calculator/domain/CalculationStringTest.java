package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculationStringTest {

    @Test
    @DisplayName("CalculationString은_구분자를_기준으로_value를_분리하고_SumValues를_반환한다")
    public void getSumValues() {
        //given
        Delimiters delimiters = new Delimiters(new CustomDelimiter(";"));
        CalculationString calculationString = new CalculationString("5:3,6;6");

        //when
        SumValues result = calculationString.getSumValues(delimiters);

        //then
        assertThat(result.sumAll()).isEqualTo(20);
    }

    @Test
    @DisplayName("CalculationString은_분리_시_구분자와_정수_외_다른_문자가_있으면_예외를_던진다")
    public void stringToIntegerNumberFormatException() {
        //given
        Delimiters delimiters = new Delimiters(new CustomDelimiter(";"));
        CalculationString calculationString = new CalculationString("5:3,6;6k");

        //when
        //then
        assertThatThrownBy(() -> calculationString.getSumValues(delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("구분자와 정수 이외 다른 문자는 입력x");
    }

}