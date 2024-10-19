package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorServiceImplTest {
    CalculatorServiceImpl calculatorService;

    @BeforeEach
    void create() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    void 정수리스트_덧셈() {
        //given
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));

        //when
        Integer result = calculatorService.sum(integers);

        //then
        Assertions.assertThat(result)
                .isEqualTo(6);
    }

    @Test
    void 빈_정수리스트_덧셈() {
        //given
        List<Integer> integers = new ArrayList<>();

        //when
        Integer result = calculatorService.sum(integers);

        //then
        Assertions.assertThat(result)
                .isEqualTo(0);
    }

}