package calculator.separator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeparatorCalculatorTest {

    @DisplayName("구분자로 이루어진 문자열의 합을 계산한다.")
    @Test
    void sum() {
        //given
        String str = "1*2,3 4:5,6 7?8";
        Separators separators = new Separators(Set.of(
                new Separator('*'),
                new Separator(','),
                new Separator(':'),
                new Separator(' '),
                new Separator('?')
        ));

        //when
        NumericString numericString = SeparatorCalculator.sum(str, separators);

        //then
        assertThat(numericString.toString()).isEqualTo(String.valueOf(1 + 2 + 3 + 4 + 5 + 6 + 7 + 8));
    }

    @DisplayName("구분자가 연속으로 있는 문자열의 합을 계산할 수 있다.")
    @Test
    void sumWithConsecutiveSeparator() {
        //when
        NumericString numericString = SeparatorCalculator.sum(",,1,,,,2,3::4::", Separators.withDefault());

        // then
        assertThat(numericString.toString()).isEqualTo(String.valueOf(1 + 2 + 3 + 4));
    }

    @DisplayName("빈 입력값의 합을 계산하는 경우 예외가 발생한다.")
    @Test
    void sumWithEmptyInput() {
        //when //then
        assertThatThrownBy(() -> SeparatorCalculator.sum("", Separators.empty()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("계산할 숫자를 입력하세요");
    }

    @DisplayName("구분자로만 이루어진 문자열의 합을 계산하는 경우 예외가 발생한다.")
    @Test
    void sumWithOnlySeparators() {
        //when //then
        assertThatThrownBy(() -> SeparatorCalculator.sum(",,,,::::", Separators.withDefault()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("계산할 숫자를 입력하세요");
    }
}