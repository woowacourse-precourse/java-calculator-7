package calculator.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.parser.FactorParser;
import calculator.validator.FactorValidator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FactorParserTest {

    @Test
    @DisplayName("정상 입력 값 테스트")
    void parseFactorsTest() {
        String[] factors = {"1", "2", "3"};

        List<Integer> result = FactorParser.parseFactors(factors);

        assertEquals(3, result.size());
        assertEquals(1, result.get(0));
        assertEquals(2, result.get(1));
        assertEquals(3, result.get(2));
    }

    @Test
    @DisplayName("빈 문자열 입력 시 예외 발생 테스트")
    void parseFactorsEmptyStringTest() {
        String[] factors = {"1", "2", "3", ""};

        assertThrows(IllegalArgumentException.class, () -> {
            FactorParser.parseFactors(factors);
        });
    }

    @Test
    @DisplayName("입력 값에 숫자가 아닌 문자가 포함되어 있는 경우 테스트")
    void parseFactorsContainCharTest() {
        String[] factors = {"1t", "2", "3", ""};

        assertThrows(IllegalArgumentException.class, () -> {
            FactorParser.parseFactors(factors);
        });
    }

    @Test
    @DisplayName("입력 값에 숫자가 아닌 특수가 포함되어 있는 경우 테스트")
    void parseFactorsContainSpecialCharTest() {
        String[] factors = {"1*", "2", "3", ""};

        assertThrows(IllegalArgumentException.class, () -> {
            FactorParser.parseFactors(factors);
        });
    }

    @Test
    @DisplayName("입력 값 음수 테스트")
    void minusFactorTest() {
        String[] factors = {"-1", "2", "3"};

        assertThrows(IllegalArgumentException.class, () -> {
            FactorParser.parseFactors(factors);
        });
    }

    @Test
    @DisplayName("int 범위를 초과하는 숫자 입력 시 에러 발생 테스트")
    void validateFactorTest_Overflow() {
        String factor = "2147483648"; // int 최대값(2147483647)을 초과하는 값

        assertThrows(IllegalArgumentException.class, () -> {
            FactorValidator.validateFactor(factor);
        });
    }

}
