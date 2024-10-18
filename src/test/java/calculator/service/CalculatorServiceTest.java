package calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorServiceTest {
    public CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource(value = {
            "1:3,2 | 6",
            " '' | 0",
            ":,: | 0",
            "1,2, | 3",
            "10:300:1 | 311",
            "100,100, | 200",
            ":30, | 30",
            "//a\\na10a20a30a | 60",
            "// \\n  1  3 2 | 6",
            "//-\\n--- | 0",
            "//+\\n1+10+100 | 111",
            "//ab\\nab100ab10ab1ab | 111"},
            delimiter = '|'
    )
    @DisplayName("입력 받은 문자열로 계산한 결과 정상 return")
    void calculate(String input, int expected) {
        int result = calculatorService.calculate(input);
        assertEquals(expected, result);
    }
}