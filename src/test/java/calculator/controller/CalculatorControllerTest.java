package calculator.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest {

    @Test
    void 계산기_실행() {
        CalculatorController calculatorController = new CalculatorController();

        int result = calculatorController.run("//a\n1,2a3:4");

        Assertions.assertThat(result).isEqualTo(10);
    }
}