package calculator.service;

import calculator.service.calculator.CalculatorService;
import calculator.validator.constant.ErrorMessage;
import calculator.number.domain.NumberService;
import calculator.service.calculator.impl.DoubleCalculatorProcess;
import calculator.service.calculator.impl.LongCalculatorProcess;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class CalculatorProcessTest {
    @Test
    void sumTest() {
        NumberService sumTest = new NumberTest(List.of(1L,2L,3L,4L,5L));
        NumberService maxValueTest = new NumberTest(List.of(Long.MAX_VALUE, Long.MAX_VALUE));
        CalculatorService calculatorProcess = new LongCalculatorProcess();
        Number ret = calculatorProcess.sum(sumTest);
        assertThat(ret).isEqualTo(15L);


        assertThatThrownBy(() -> calculatorProcess.sum(maxValueTest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MAX_VALUE_ERROR);


        NumberService doubleNumberTest = new DoubleNumberTest(List.of(0.1,0.2,0.3,0.4,0.05));
        CalculatorService doubleCalculatorProcess = new DoubleCalculatorProcess();
        Number ret2 = doubleCalculatorProcess.sum(doubleNumberTest);
        assertThat(ret2).isEqualTo(1.05);
    }
}
class NumberTest implements NumberService {
    private final List<Number> numbers;
    public NumberTest(List<Number> numbers) {
        this.numbers = numbers;
    }
    @Override
    public List<Number> getNumbers() {
        return numbers;
    }
}

class DoubleNumberTest implements NumberService {
    private final List<Number> numbers;
    public DoubleNumberTest(List<Number> numbers) {
        this.numbers = numbers;
    }
    @Override
    public List<Number> getNumbers() {
        return numbers;
    }
}
