package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
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
    public void checkAndParseInputEmptyInputTest() {
        //given
        String empty = "";

        //when
        List<Integer> list = calculatorService.checkAndParseInput(empty);

        //then
        assertThat(list).isEqualTo(List.of(0, 0));
    }

    @Test
    @DisplayName("커스텀 구분자 양수 검사 예외발생 테스트")
    public void checkAndParseInputPositiveNumberExceptionTest() {
        //given
        String input1 = "//*\\n1*0*3";
        String input2 = "//*\\n-1*2*3";

        //then
        assertThrows(IllegalArgumentException.class,
            () -> calculatorService.checkAndParseInput(input1));
        assertThrows(IllegalArgumentException.class,
            () -> calculatorService.checkAndParseInput(input2));
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
