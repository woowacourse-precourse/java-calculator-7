package calculator;

import calculator.exception.InvalidDelimiterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class CalculatorParserTest {
    private List<String> delimiters;

    @BeforeEach
    void setDelimiters() {
        delimiters = DefaultDelimiter.get();
    }

    @Test
    void 잘못된_구분자() {
        assertSimpleTest(() -> {
            // given
            delimiters.add(";");
            final String regex = String.join("|", delimiters);
            final String content = "1!2;3,4";

            // when, then
            assertThatThrownBy(() -> {
                CalculatorParser.parseInteger(regex, content);
            }).isInstanceOf(InvalidDelimiterException.class);
        });
    }

    @Test
    void 커스텀_구분자_미포함() {
        assertSimpleTest(() -> {
            // given
            final String regex = String.join("|", delimiters);
            final String content = "1:2,3";

            // when
            final List<Integer> parsed = CalculatorParser.parseInteger(regex, content);

            // then
            assertThat(parsed).containsSequence(1, 2, 3);
        });
    }

    @Test
    void 공백_문자_처리() {
        assertSimpleTest(() -> {
            // given
            final String regex = String.join("|", delimiters);
            final String input = "";

            // when
            final List<Integer> parsed = CalculatorParser.parseInteger(regex, input);

            // then
            assertThat(parsed).isEmpty();
        });
    }

    @Test
    void 공백_문자열_처리() {
        assertSimpleTest(() -> {
            // given
            final String regex = String.join("|", delimiters);
            final String input = ",1,,2,3";

            // when
            final List<Integer> parsed = CalculatorParser.parseInteger(regex, input);

            // then
            assertThat(parsed).containsSequence(1, 2, 3);
        });
    }

    @Test
    void 커스텀_구분자_기본_구분자_동시_사용() {
        assertSimpleTest(() -> {
            // given
            delimiters.add(";");
            final String regex = String.join("|", delimiters);
            final String input = "1;2,3:4";

            // when
            final List<Integer> parsed = CalculatorParser.parseInteger(regex, input);

            // then
            assertThat(parsed).containsSequence(1, 2, 3, 4);
        });
    }

    @Test
    void 영으로_시작하는_문자열은_사용할_수_있다() {
        assertSimpleTest(() -> {
            // given
            final String regex = String.join("|", delimiters);
            final String input = "01,0002,3,,";

            // when
            final List<Integer> parsed = CalculatorParser.parseInteger(regex, input);

            // then
            assertThat(parsed).containsSequence(1, 2, 3);
        });
    }

    @Test
    void 소수는_사용할_수_없다() {
        assertSimpleTest(() -> {
            // given
            final String regex = String.join("|", delimiters);
            final String input = "1,2,1.23";

            // when, then
            assertThatThrownBy(() -> {
                CalculatorParser.parseInteger(regex, input);
            }).isInstanceOf(InvalidDelimiterException.class);
        });
    }

    @Test
    void 공백문자도_구분자로_사용할_수_있다() {
        assertSimpleTest(() -> {
            // given
            delimiters.add(" ");
            final String regex = String.join("|", delimiters);
            final String input = "1 2 3";

            // when
            final List<Integer> parsed = CalculatorParser.parseInteger(regex, input);

            // then
            assertThat(parsed).containsSequence(1, 2, 3);
        });
    }
}