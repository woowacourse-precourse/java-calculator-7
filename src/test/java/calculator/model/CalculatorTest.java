package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    void 누적합_구하기_리스트_내부O() {
        //given
        List<Integer> integers = Arrays.asList(1, 2, 3);

        //when
        int result = calculator.addAll(integers);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 누적합_구하기_리스트_내부X() {
        //given
        List<Integer> integers = new ArrayList<>();

        //when
        int result = calculator.addAll(integers);

        //then
        assertThat(result).isEqualTo(0);
    }

}