package calculator.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorServiceImplTest {

    private CalculatorService calculatorService = new CalculatorServiceImpl();

    @Test
    @DisplayName("1,2:3 이 주어졌을 때, 3개로 나뉘어지는지 검증한다.")
    void given_string_then_split_3() {
        String inputString = "1,2:3";
        List<String> validNumber = calculatorService.findValidNumber(inputString);
        List<String> testNumber = List.of("1", "2", "3");
        assertThat(validNumber).containsAll(testNumber);
    }
}
