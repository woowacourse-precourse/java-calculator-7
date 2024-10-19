package calculator.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorInputTest {
    CalculatorInput calculatorInput;

    @BeforeEach
    void setUp() {
        calculatorInput = new CalculatorInput();
    }

    @Test
    void 문자열_입력_테스트() {
        //given
        System.setIn(createUserInput("1:2:3"));

        //when
        String input = calculatorInput.input();

        //then
        Assertions.assertThat(input)
                .isEqualTo("1:2:3");
    }

    @Test
    void 빈_문자열_입력_테스트() {
        //given
        System.setIn(createUserInput("\n"));

        //when
        String input = calculatorInput.input();

        //then
        Assertions.assertThat(input)
                .isEqualTo("");
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}