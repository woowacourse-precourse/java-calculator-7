package calculator.stringcalculator;

import calculator.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorServiceImplTest {

    StringCalculatorService stringCalculatorService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        stringCalculatorService = appConfig.stringCalculatorService();
    }

    @Test
    void validateInputFormTest1() {
        String input = "/?+\\n123";
        assertThrows(IllegalArgumentException.class,
                () -> stringCalculatorService.validateInputForm(input));
    }

    @Test
    void validateInputFormTest2() {
        String input = ":,12:,:3";
        assertDoesNotThrow(() -> stringCalculatorService.validateInputForm(input));
    }

    @Test
    void extractDelimiterTest1() {
        String input = "//;\\n12:34,56";
        System.out.println("input = " + input);

        String extractedDelimiter = stringCalculatorService.extractDelimiter(input);

        assertThat(extractedDelimiter).isEqualTo(";");
    }

    @Test
    void extractDelimiterTest2() {
        String input = "//\\n12:34,56";

        String extractedDelimiter = stringCalculatorService.extractDelimiter(input);

        assertThat(extractedDelimiter).isEqualTo("");
    }

    @Test
    void extractDelimiterTest3() {
        String input = "12:34,56";

        String extractedDelimiter = stringCalculatorService.extractDelimiter(input);

        assertThat(extractedDelimiter).isEqualTo("");
    }

    @Test
    void extractNumberTest1() {
        String input = "//;\\n12:34,56;78";
        String[] result = {"12", "34", "56", "78"};
        List<String> delimiters = new ArrayList<>(Arrays.asList(":", ","));
        delimiters.add(";");

        String[] testResult = stringCalculatorService.extractNumber(input, delimiters);

        assertArrayEquals(result, testResult);
    }

}