package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringParserTest {

    @Test
    void 문자열에서_연산식을_추출한다() {
        String customInput = "//;\n1";
        String basicInput = "1,2:3";

        String operationFormulaInCustom = StringParser.parseOperationFormula(customInput);
        String operationFormulaInBasic = StringParser.parseOperationFormula(basicInput);

        assertEquals("1", operationFormulaInCustom);
        assertEquals("1,2:3", operationFormulaInBasic);
    }

    @Test
    void 입력값의_개행문자를_줄바꿈으로_치환한다() {
        String input = "//;\\n1";
        String parsedInput = StringParser.parseBr(input);

        assertEquals(2, parsedInput.split("\n").length);
    }
}
