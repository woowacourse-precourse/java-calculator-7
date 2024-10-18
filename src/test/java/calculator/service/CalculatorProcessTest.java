package calculator.service;

import calculator.constant.ErrorMessage;
import calculator.number.domain.Number;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class CalculatorProcessTest {
    @Test
    void sumTest() {
        Number sumTest = new NumberTest(List.of(1L,2L,3L,4L,5L));
        Number maxValueTest = new NumberTest(List.of(Long.MAX_VALUE, Long.MAX_VALUE));
        long ret = CalculatorProcess.sum(sumTest);
        assertThat(ret).isEqualTo(15L);
        assertThatThrownBy(() -> CalculatorProcess.sum(maxValueTest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MAX_VALUE_ERROR);

    }
}
class NumberTest implements Number {
    private final List<Long> numbers;
    public NumberTest(List<Long> numbers) {
        this.numbers = numbers;
    }
    @Override
    public List<Long> getNumbers() {
        return numbers;
    }
}
