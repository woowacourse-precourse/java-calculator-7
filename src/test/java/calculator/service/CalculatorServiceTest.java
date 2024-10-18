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

}