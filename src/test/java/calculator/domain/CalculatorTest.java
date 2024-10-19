package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CalculatorTest {

    @Test
    @DisplayName("계산기는 숫자들을 가진다")
    void 계산기_숫자_가짐_TEST(){
        List<Double> numbers = new ArrayList<>(Arrays.asList(1.0, 1.1, 2.0));

        Calculator calculator = new Calculator(numbers);

        Assertions.assertThat(calculator.getNumbers()).isEqualTo(numbers);
    }
}