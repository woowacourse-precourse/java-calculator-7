package calculator.inputStringTest;

import calculator.domain.Delimiters;
import calculator.domain.Numbers;
import calculator.exception.InputStringException;
import calculator.service.CalculateService;
import calculator.util.OutputUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputStringTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @DisplayName("입력값이 null일 때")
    @Test
    void inputStringIsNullTest() {
        Numbers numbers = new Numbers();
        Delimiters delimiters = new Delimiters();
        OutputUtil outputUtil = new OutputUtil();
        CalculateService calculateService = new CalculateService();
        String testString = null;
        InputStringException inputStringException = new InputStringException();
        numbers = inputStringException.validateInputPattern(testString, numbers, delimiters);
        outputUtil.printResultPhrase();
        outputUtil.printResult(calculateService.calculateSum(numbers));

        assertThat(outContent.toString().trim()).isEqualTo("결과 : 0");
    }

    @DisplayName("입력값이 빈 문자열일 때")
    @Test
    void inputStringIsEmptyTest() {
        Numbers numbers = new Numbers();
        Delimiters delimiters = new Delimiters();
        OutputUtil outputUtil = new OutputUtil();
        CalculateService calculateService = new CalculateService();
        String testString = "";
        InputStringException inputStringException = new InputStringException();
        numbers = inputStringException.validateInputPattern(testString, numbers, delimiters);
        outputUtil.printResultPhrase();
        outputUtil.printResult(calculateService.calculateSum(numbers));

        assertThat(outContent.toString().trim()).isEqualTo("결과 : 0");
    }
}
