package calculator.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    public void create() {
        calculatorService = new CalculatorService(new InputParser(), new SumCalculator());
    }

    @Test
    @DisplayName("빈 문자열 입력 테스트")
    public void emptyInputTest() {
        //given
        String empty = "";

        //when
        List<Integer> list = calculatorService.checkAndParseInput(empty);

        //then
        assertThat(list).isEqualTo(List.of(0, 0));
    }

    @Test
    @DisplayName("calculate 테스트")
    public void calculateTest() {
        //given
        List<Integer> list = List.of(1, 2, 3);

        //when
        int result = calculatorService.calculate(list);

        //then
        assertThat(result).isEqualTo(6);
    }
}
