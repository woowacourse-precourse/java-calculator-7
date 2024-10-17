package calculator;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorNumberListTest {
    private final CalculatorNumberList calculatorNumberList = new CalculatorNumberList();
    @Test
    void 기본_구분자_콤마만_사용() {
        assertSimpleTest(() -> {
            // given
            String input = "1,2,3";
            // when
            int result = calculatorNumberList.sum(input);
            // then
            assertThat(result).isEqualTo(1+2+3);
        });
    }

    @Test
    void 기본_구분자_콜론만_사용() {
        assertSimpleTest(() -> {
            // given
            String input = "1:2:3";
            // when
            int result = calculatorNumberList.sum(input);
            // then
            assertThat(result).isEqualTo(1+2+3);
        });
    }

    @Test
    void 기본_구분자_섞어서_사용() {
        assertSimpleTest(() -> {
            // given
            String input = "1:2,3";
            // when
            int result = calculatorNumberList.sum(input);
            // then
            assertThat(result).isEqualTo(1+2+3);
        });
    }

    @Test
    void 공백_문자열_처리() {
        assertSimpleTest(() -> {
            // given
            String input = ",1,,2,3";
            // when
            int result = calculatorNumberList.sum(input);
            // then
            assertThat(result).isEqualTo(1+2+3);
        });
    }

    @Test
    void 커스텀_구분자_기본_구분자_동시_사용() {
        assertSimpleTest(() -> {
            // given
            String input = "//;\\n1;2,3:4";
            // when
            int result = calculatorNumberList.sum(input);
            // then
            assertThat(result).isEqualTo(1+2+3+4);
        });
    }

    @Test
    void 소수는_사용할_수_없다() {
        assertSimpleTest(() -> {
            // given
            String input = "1,2,1.23";

            // when
            assertThatThrownBy(() -> {
                calculatorNumberList.sum(input);
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }
}