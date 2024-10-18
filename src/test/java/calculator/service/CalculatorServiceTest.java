package calculator.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    @DisplayName("주어진 숫자 리스트의 총합을 계산")
    @Test
    void calculateSum() {
        List<Integer> values = List.of(1, 2, 4, 10);

        CalculatorService service = new CalculatorService();
        int calculateSum = service.calculateSum(values);

        Assertions.assertThat(calculateSum).isEqualTo(17);
        Assertions.assertThat(calculateSum).isNotEqualTo(20);
    }

    @DisplayName("올바른 문자열을 숫자로 변환하여 숫자 리스트로 반환")
    @Test
    void convertToNumbers() {
        String[] parts = {"1", "2", "4", "10"};

        CalculatorService service = new CalculatorService();
        List<Integer> values = service.convertToNumbers(parts);

        Assertions.assertThat(values).containsAll(List.of(1, 2, 4, 10));
        Assertions.assertThat(values).doesNotContainSequence(List.of(15, 42, 4, 10));
    }

    @DisplayName("빈 문자열 입력 시 0으로 변환")
    @Test
    void convertToNumbersContainsEmpty() {
        String[] parts = {"", "2", "", "10"};
        CalculatorService service = new CalculatorService();
        List<Integer> values = service.convertToNumbers(parts);

        Assertions.assertThat(values).containsAll(List.of(0, 2, 0, 10));
        Assertions.assertThat(values).doesNotContainSequence(List.of(2, 10));
    }

    @DisplayName("올바르지 않은 문자열 입력 시 IllegalArgumentException 발생")
    @Test
    void convertToNumbersContainsInvalidStringThrowByIllegalArgumentException() {
        String[] parts = {"1a", "2b", "4", "10"};

        CalculatorService service = new CalculatorService();

        Assertions.assertThatThrownBy(() -> service.convertToNumbers(parts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값이 입력되었습니다.");
    }

    @DisplayName("음수가 포함된 문자열 입력 시 IllegalArgumentException 발생")
    @Test
    void convertToNumbersContainsNegativeValueThrowByIllegalArgumentException() {
        String[] parts = {"-1", "20", "4", "10"};

        CalculatorService service = new CalculatorService();

        Assertions.assertThatThrownBy(() -> service.convertToNumbers(parts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값이 입력되었습니다.");
    }
}