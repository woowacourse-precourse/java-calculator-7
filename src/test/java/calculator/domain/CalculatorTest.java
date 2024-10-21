package calculator.domain;

import calculator.domain.model.value.PositiveNumber;
import calculator.domain.service.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CalculatorTest {


    @DisplayName("1, 2, 3 을 입력하면 총 합 6을 반환한다")
    @Test
    void addOperations() {

        // given
        Calculator calculator = new Calculator();

        List<PositiveNumber> numbers = List.of(
                new PositiveNumber(1),
                new PositiveNumber(2),
                new PositiveNumber(3)
        );


        // when
        Long result = calculator.getSum(numbers);

        // then
        Assertions.assertThat(result).isEqualTo(6L);
    }
}
