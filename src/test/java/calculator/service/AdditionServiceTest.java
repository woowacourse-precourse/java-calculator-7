package calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import calculator.CalculatorConfig;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdditionServiceTest {

    @Test
    void calculate() {
        // given
        CalculatorConfig calculatorConfig = new CalculatorConfig();
        CalculatorService calculatorService = calculatorConfig.calculatorService();
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // when
        Integer result = calculatorService.calculate(numbers);

        // then
        Assertions.assertEquals(6, result);
    }
}