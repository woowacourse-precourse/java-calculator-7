package calculator.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.dto.CalculatorRequest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NumberParserTest {

    @Test
    void 구분자로_문자열_분리() {
        assertSimpleTest(() -> {
            CalculatorRequest request = CalculatorRequest.of("[,:]", "1,2:3");
            List<Integer> result = NumberParser.parseByDelimiters(request);

            assertThat(result).hasSize(3)
                    .containsExactly(1, 2, 3);
        });
    }

    @Test
    void 구분자로_끝날_시_예외_발생() {
        assertSimpleTest(() -> {
            CalculatorRequest request = CalculatorRequest.of(";,", "1;,2;,3;,");

            assertThatThrownBy(() -> NumberParser.parseByDelimiters(request))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 빈문자열_0_반환() {
        assertSimpleTest(() -> {
            CalculatorRequest request = CalculatorRequest.of("[,:]", "");
            List<Integer> result = NumberParser.parseByDelimiters(request);

            assertThat(result).hasSize(1)
                    .containsExactly(0);
        });
    }

    @Test
    void 음수_입력_시_예외_발생() {
        assertSimpleTest(() -> {
            CalculatorRequest request = CalculatorRequest.of(";", "1;-2;3");

            assertThatThrownBy(() -> NumberParser.parseByDelimiters(request))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 구분자_외의_문자_입력() {
        assertSimpleTest(() -> {
            CalculatorRequest request = CalculatorRequest.of(";", "1;2;,3");

            assertThatThrownBy(() -> NumberParser.parseByDelimiters(request))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
}
