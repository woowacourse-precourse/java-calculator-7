package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SumCalculatorTest {
    private SumCalculator sumCalculator;

    @BeforeEach
    void setup() {
        sumCalculator = new SumCalculator();
    }

    @Test
    @DisplayName("빈문자를 입력했을 때 0을 반환하는지 테스트")
    void sum_isEmpty() {
        String input = "";

        int result = sumCalculator.sum(input);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자를 하나만 입력했을 경우")
    void sum_One_number() {
        String input = "1";

        int result = sumCalculator.sum(input);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용하면서 숫자를 하나만 입력했을 경우")
    void sumByCustomDelimiter_One_number() {
        String input = "//;\\n1";

        int result = sumCalculator.sum(input);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자 작동 여부 테스트")
    void sumByDefaultDelimiter_쉼표() {
        String input = "1,2,3";

        int result = sumCalculator.sum(input);

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("세미콜론 구분자 작동 여부 테스트")
    void sumByDefaultDelimiter_세미콜론() {
        String input = "1;2;3";

        int result = sumCalculator.sum(input);

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표 구분자와 세미콜론 구분자 동시 사용 테스트")
    void sumByDefaultDelimiter() {
        String input = "1,2;3";

        int result = sumCalculator.sum(input);

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void sumByCustomDelimiter() {
        String input = "//;\\n1;2;3";

        int result = sumCalculator.sum(input);

        assertThat(result).isEqualTo(6);
    }
}