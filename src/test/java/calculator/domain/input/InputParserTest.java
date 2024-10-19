package calculator.domain.input;

import calculator.domain.delimiter.Delimiters;
import calculator.exception.BusinessException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputParserTest {

    private final InputParser inputParser = new InputParser(new Delimiters());

    @Test
    void 받아온_구분자_리스트로_input을_가공하여_정수형_리스트로_반환() {
        // given
        String input = "1,2,3";

        // when
        List<Integer> numbers = inputParser.extractNumbersFromInput(input);

        // then
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    void 받아온_구분자_리스트에_커스텀_구분자가_존재하고_구분자를_바탕으로_input을_가공하여_정수형_리스트로_반환() {
        // given
        String input = "//'\n1'2'3";

        // when
        List<Integer> numbers = inputParser.extractNumbersFromInput(input);

        // then
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    void 숫자가_아닌_잘못된_값이_입력된_경우_BusinessException() {
        // given
        String input = "t'2'3";

        // when & then
        assertThatThrownBy(() -> {
            inputParser.extractNumbersFromInput(input);
        }).isInstanceOf(BusinessException.class);
    }

    @Test
    void 숫자중_음수가존재하면_BusinessException() {
        // given
        String input = "//=\n-1=2=3";

        // when & then
        assertThatThrownBy(() -> {
            inputParser.extractNumbersFromInput(input);
        }).isInstanceOf(BusinessException.class);
    }
}
