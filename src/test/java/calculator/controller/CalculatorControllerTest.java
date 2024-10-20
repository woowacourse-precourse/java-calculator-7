package calculator.controller;

import calculator.model.CalculatorServiceImpl;
import calculator.model.StringServiceImpl;
import calculator.view.CalculatorInput;
import calculator.view.CalculatorOutput;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest {
    CalculatorController calculatorController;
    OutputStream out;


    @BeforeEach
    void setUp() {
        calculatorController = new CalculatorController(
                new CalculatorInput(),
                new CalculatorOutput(),
                new CalculatorServiceImpl(),
                new StringServiceImpl()
        );
        out = new ByteArrayOutputStream();
    }

    @Test
    void calculate() {
        //given
        System.setIn(createUserInput("1:2:4"));
        System.setOut(new PrintStream(out));

        //when
        calculatorController.calculate();

        //then
        Assertions.assertThat(out.toString())
                .contains("결과 : 7");
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}