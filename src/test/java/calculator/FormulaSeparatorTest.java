package calculator;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FormulaSeparatorTest {

    private final FormulaSeparator formulaSeparator = new FormulaSeparator();

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1,2,3", "1:2:3"})
    void 기본_구분자_수식의_숫자_리스트를_반환한다(String formula) {
        //given & when
        List<Integer> numbers = formulaSeparator.getNumbers(formula);

        //then
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n10,20;30", "//;\\n10;20;30", "//;\\n10,20:30"})
    void 커스텀_구분자_수식의_숫자_리스트를_반환한다(String formula) {
        //given & when
        List<Integer> numbers = formulaSeparator.getNumbers(formula);

        //then
        assertThat(numbers).containsExactly(10, 20, 30);
    }

    @Test
    void 기본_구분자_수식에서_구분자가_없을_경우_숫자만_반환한다() {
        //given & when
        List<Integer> numbers = formulaSeparator.getNumbers("100");

        //then
        assertThat(numbers).containsExactly(100);
    }

    @Test
    void 커스텀_구분자_수식에서_구분자가_없을_경우_숫자만_반환한다() {
        //given & when
        List<Integer> numbers = formulaSeparator.getNumbers("//;\\n100");

        //then
        assertThat(numbers).containsExactly(100);
    }


    @Test
    void 수식이_비어있으면_빈_리스트를_반환한다() {
        //given & when
        List<Integer> numbers = formulaSeparator.getNumbers("");

        //then
        assertThat(numbers.isEmpty()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1'2'3", "1&2,3", "1^2^3", "//***\n12,3"})
    void 잘못된_수식_형식은_예와가_발생한다(String formula) {
        assertThatThrownBy(() -> formulaSeparator.getNumbers(formula))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
