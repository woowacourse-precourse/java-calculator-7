package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @DisplayName("숫자들을 입력하면 그 합을 반환한다")
    @Test
    void sum() {

        // given
        Calculator calculator = new Calculator();
        String[] inputs = new String[]{"1", "2", "3"};

        // when
        double sum = calculator.sum(inputs);

        // then
        assertThat(sum).isEqualTo(6);
    }


    @DisplayName("큰 수를 입력해도 된다")
    @Test
    void sumLargeNumber() {

        // given
        Calculator calculator = new Calculator();
        String[] inputs = new String[]{"121334123423452233.", "2", "3"};

        // when
        double sum = calculator.sum(inputs);

        // then
        assertThat(sum).isEqualTo(121334123423452233. + 5);
    }


    @DisplayName("실수 자료형에도 잘 동작한다")
    @Test
    void sumDoubleData() {

        // given
        Calculator calculator = new Calculator();
        String[] inputs = new String[]{"1.4", "2", "3"};

        // when
        double sum = calculator.sum(inputs);

        // then
        assertThat(sum).isEqualTo(6.4);
    }

    @Test
    @DisplayName("사용자가 음수를 입력하면 애플리케이션을 종료한다")
    void calculateWithNegativeInput() {
        // given
        Calculator calculator = new Calculator();
        String[] inputs = new String[]{"-1", "2", "3"};

        // when

        // then
        assertThatThrownBy(() -> calculator.sum(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수를 포함할 수 없습니다. 애플리케이션을 종료합니다.");
    }


}