package calculator;

import calculator.exception.InvalidDelimiterException;
import calculator.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorInputParserTest {
    private final CalculatorInputParser calculatorInputParser = new CalculatorInputParser();

    @Test
    void 커스텀_구분자는_맨_앞에_위치한다() {
        assertSimpleTest(() -> {
            // given
            String input = "1;2;3//;\\n";

            assertThatThrownBy(() -> {
                // when
                calculatorInputParser.parse(input);
                // then
            }).isInstanceOf(InvalidInputException.class);
        });
    }

    @Test
    void 커스텀_구분자의_개행_미포함() {
        assertSimpleTest(() -> {
            // given
            String input = "//;1;2;3";

            assertThatThrownBy(() -> {
                // when
                calculatorInputParser.parse(input);
                // then
            }).isInstanceOf(InvalidInputException.class);
        });
    }

    @Test
    void 커스텀_구분자의_슬래시_미포함() {
        assertSimpleTest(() -> {
            // given
            String input = ";\\n1;2;3";

            assertThatThrownBy(() -> {
                // when
                calculatorInputParser.parse(input);
                // then
            }).isInstanceOf(InvalidInputException.class);
        });
    }

    @Test
    void 올바른_커스텀_구분자() {
        assertSimpleTest(() -> {
            // given
            String input = "//;\\n1;2;3";

            // when
            List<Integer> parsed = calculatorInputParser.parse(input);

            // then
            assertThat(parsed).containsSequence(1, 2, 3);
        });
    }

    @Test
    void 잘못된_구분자() {
        assertSimpleTest(() -> {
            // given
            String input = "//;\\n1!2;3,4";

            // when, then
            assertThatThrownBy(() -> {
                calculatorInputParser.parse(input);
            }).isInstanceOf(InvalidDelimiterException.class);
        });
    }

    @Test
    void 커스텀_구분자_미포함() {
        assertSimpleTest(() -> {
            // given
            String input = "1:2,3";

            // when
            List<Integer> parsed = calculatorInputParser.parse(input);

            // then
            assertThat(parsed).containsSequence(1, 2, 3);
        });
    }

    @Test
    void 공백_문자_처리() {
        assertSimpleTest(() -> {
            // given
            String input = "";

            // when
            List<Integer> parsed = calculatorInputParser.parse(input);

            // then
            assertThat(parsed).isEmpty();
        });
    }

    @Test
    void 공백_문자열_처리() {
        assertSimpleTest(() -> {
            // given
            String input = ",1,,2,3";

            // when
            List<Integer> parsed = calculatorInputParser.parse(input);

            // then
            assertThat(parsed).containsSequence(1, 2, 3);
        });
    }

    @Test
    void 커스텀_구분자_기본_구분자_동시_사용() {
        assertSimpleTest(() -> {
            // given
            String input = "//;\\n1;2,3:4";
            // when
            List<Integer> parsed = calculatorInputParser.parse(input);
            // then
            assertThat(parsed).containsSequence(1, 2, 3, 4);
        });
    }

    @Test
    void 영으로_시작하는_문자열은_사용할_수_있다() {
        assertSimpleTest(() -> {
            // given
            String input = "01,0002,3,,";

            // when
            List<Integer> parsed = calculatorInputParser.parse(input);

            // then
            assertThat(parsed).containsSequence(1, 2, 3);
        });
    }

    @Test
    void 소수는_사용할_수_없다() {
        assertSimpleTest(() -> {
            // given
            String input = "1,2,1.23";

            // when, then
            assertThatThrownBy(() -> {
                calculatorInputParser.parse(input);
            }).isInstanceOf(InvalidDelimiterException.class);
        });
    }
}