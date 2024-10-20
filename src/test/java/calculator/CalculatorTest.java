package calculator;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void calculateSum_숫자의_합을_정상적으로_반환() {
        // 준비
        Calculator calculator = new Calculator();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // 실행
        int result = calculator.calculateSum(numbers);

        // 검증
        assertThat(result).isEqualTo(6);  // 1 + 2 + 3 = 6
    }

    @Test
    void calculateSum_빈_리스트일_때_0을_반환() {
        // 준비
        Calculator calculator = new Calculator();
        ArrayList<Integer> numbers = new ArrayList<>();

        // 실행
        int result = calculator.calculateSum(numbers);

        // 검증
        assertThat(result).isEqualTo(0);  // 빈 리스트이므로 합계는 0
    }
}