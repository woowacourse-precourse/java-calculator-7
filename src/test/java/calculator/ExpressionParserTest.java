package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ExpressionParserTest {

    @Test
    void 구분자의_길이가_1이_아닌_경우_예외를_발생한다() {
        List<String> delimiters = List.of("::");
        assertThatThrownBy(() -> new ExpressionParser(delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자는 1 글자여야 합니다.");
    }

    @Test
    void 구분자를_기준으로_나누어_문자열을_변환한다() {
        List<String> delimiters = List.of(",", ":");
        ExpressionParser expressionParser = new ExpressionParser(delimiters);
        List<Integer> numbers = expressionParser.parse("1,2:3");
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    void 숫자가_아닌_값이_포함된_경우_예외를_발생한다() {
        ExpressionParser expressionParser = new ExpressionParser(List.of(",", ":"));
        assertThatThrownBy(() -> expressionParser.parse("1,2:a:b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다");
    }

    @Test
    void 구분자가_이스케이프_문자로_시작하는_경우_구분자에_이스케이프_문자를_추가한다() {
        List<String> delimiters = List.of("\\");
        ExpressionParser expressionParser = new ExpressionParser(delimiters);
        List<Integer> numbers = expressionParser.parse("1\\2\\3");
        assertThat(numbers).containsExactly(1, 2, 3);
    }
}
