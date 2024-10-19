package calculator.service;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    CalculatorService calculatorService = new CalculatorService();

    @Test
    void 기본_구분자로_분리() {
        String inputString = "1,2:3";
        String delimiter = ",:";

        List<String> expected = List.of("1", "2", "3");

        Assertions.assertEquals(calculatorService.splitInputWithDelimiter(inputString, delimiter), expected);
    }

    @Test
    void 잘못된_구분자로_분리() {
        String inputString = "1,2;3";
        String delimiter = ",:";

        List<String> expected = List.of("1", "2;3");

        Assertions.assertEquals(calculatorService.splitInputWithDelimiter(inputString, delimiter), expected);
    }

    @Test
    void 문자열에서_커스텀_구분자_제외() {
        String inputString = "//;\\n1,2;3:4";
        String delimiter = ",:";
        if (calculatorService.haveCustomDelimiter(inputString)) {
            delimiter = calculatorService.addCustomDelimiter(inputString, delimiter);
            inputString = calculatorService.extractInput(inputString, delimiter);
        }

        String expected = "1,2;3:4";

        Assertions.assertEquals(inputString, expected);
    }

    @Test
    void 커스텀_기본_구분자로_분리() {
        String inputString = "//;\\n1,2;3:4";
        String delimiter = ",:";
        if (calculatorService.haveCustomDelimiter(inputString)) {
            delimiter = calculatorService.addCustomDelimiter(inputString, delimiter);
            inputString = calculatorService.extractInput(inputString, delimiter);
        }

        List<String> expected = List.of("1", "2", "3", "4");

        Assertions.assertEquals(calculatorService.splitInputWithDelimiter(inputString, delimiter), expected);
    }

    @Test
    void 공백_커스텀_구분자로_분리() {
        String inputString = "// \\n1 2 3 4";
        String delimiter = ",:";
        if (calculatorService.haveCustomDelimiter(inputString)) {
            delimiter = calculatorService.addCustomDelimiter(inputString, delimiter);
            inputString = calculatorService.extractInput(inputString, delimiter);
        }

        List<String> expected = List.of("1", "2", "3", "4");

        Assertions.assertEquals(calculatorService.splitInputWithDelimiter(inputString, delimiter), expected);
    }

    @Test
    void 커스텀_구분자_중복_입력() {
        String inputString = "//;\\n1//'\\n,2;3:4";
        String delimiter = ",:";
        if (calculatorService.haveCustomDelimiter(inputString)) {
            delimiter = calculatorService.addCustomDelimiter(inputString, delimiter);
            inputString = calculatorService.extractInput(inputString, delimiter);
        }

        List<String> expected = List.of("1//'\\n", "2", "3", "4");

        Assertions.assertEquals(calculatorService.splitInputWithDelimiter(inputString, delimiter), expected);
    }

    @Test
    void 빈_문자열_구분() {
        String inputString = "";
        String delimiter = ",:";

        List<String> expected = List.of();

        Assertions.assertEquals(calculatorService.splitInputWithDelimiter(inputString, delimiter), expected);
    }

    @Test
    void 중간_빈_문자열_구분() {
        String inputString = "1,,2:3";
        String delimiter = ",:";

        List<String> expected = List.of("1", "2", "3");

        Assertions.assertEquals(calculatorService.splitInputWithDelimiter(inputString, delimiter), expected);
    }

    @Test
    void 공백_문자열_구분() {
        String inputString = " ";
        String delimiter = ",:";

        List<String> expected = List.of(" ");

        Assertions.assertEquals(calculatorService.splitInputWithDelimiter(inputString, delimiter), expected);
    }

    @Test
    void 중간_공백_문자열_구분1() {
        String inputString = "1, ,2:3";
        String delimiter = ",:";

        List<String> expected = List.of("1", " ", "2", "3");

        Assertions.assertEquals(calculatorService.splitInputWithDelimiter(inputString, delimiter), expected);
    }

    @Test
    void 중간_공백_문자열_구분2() {
        String inputString = "1, 2:3";
        String delimiter = ",:";

        List<String> expected = List.of("1", " 2", "3");

        Assertions.assertEquals(calculatorService.splitInputWithDelimiter(inputString, delimiter), expected);
    }

    @Test
    void 구분된_문자열_더하기() {
        List<String> inputTokens = List.of("1","2","3");
        String expected = "6";

        Assertions.assertEquals(calculatorService.sumAllTokens(inputTokens), expected);
    }

    @Test
    void 구분된_긴_문자열_더하기() {
        List<String> inputTokens = List.of("10000000000000000000000000","10000000000000000000000000","10000000000000000000000000");
        String expected = "30000000000000000000000000";

        Assertions.assertEquals(calculatorService.sumAllTokens(inputTokens), expected);
    }

    @Test
    void 구분된_빈_문자열_더하기() {
        List<String> inputTokens = List.of("","1","2");
        String expected = "3";

        Assertions.assertEquals(calculatorService.sumAllTokens(inputTokens), expected);
    }

}
