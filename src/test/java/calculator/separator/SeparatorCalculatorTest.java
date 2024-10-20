package calculator.separator;

import static org.assertj.core.api.Assertions.assertThat;

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
        SeparatorCalculator calculator = SeparatorCalculator.positiveCalculator(str, separators);

        //when
        NumericString numericString = calculator.sum();

        //then
        assertThat(numericString.toString()).isEqualTo(String.valueOf(1 + 2 + 3 + 4 + 5 + 6 + 7 + 8));
    }

    @DisplayName("구분자가 연속으로 있는 문자열의 합을 계산할 수 있다.")
    @Test
    void sumWithConsecutiveSeparator() {
        //given
        SeparatorCalculator calculator = SeparatorCalculator.positiveCalculator(",,1,,,,2,3::4::",
                Separators.withDefault());

        //when
        NumericString numericString = calculator.sum();

        // then
        assertThat(numericString.toString()).isEqualTo(String.valueOf(1 + 2 + 3 + 4));
    }

    @DisplayName("빈 입력값의 합을 계산하는 경우 0을 반환한다.")
    @Test
    void sumWithEmptyInput() {
        //given
        SeparatorCalculator calculator = SeparatorCalculator.positiveCalculator("", Separators.empty());

        //when
        NumericString result = calculator.sum();

        //then
        assertThat(result.toString()).isEqualTo("0");
    }

    @DisplayName("구분자로만 이루어진 문자열의 합을 계산하는 경우 0을 반환한다.")
    @Test
    void sumWithOnlySeparators() {
        //given
        SeparatorCalculator calculator = SeparatorCalculator.positiveCalculator(",,,,::::", Separators.withDefault());

        //when
        NumericString result = calculator.sum();

        // then
        assertThat(result.toString()).isEqualTo("0");
    }
}