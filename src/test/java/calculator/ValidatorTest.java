package calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    Validator validator = new Validator();

    @Test
    void 커스텀_구분자_목록에_숫자_포함_테스트() {
        String optionField = "//;-1)[]\n";
        boolean expected = false;
        boolean result = validator.isValidOptionField(optionField);
        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자_목록에_숫자_미포함_테스트() {
        String optionField = "//;-)[]\n";
        boolean expected = true;
        boolean result = validator.isValidOptionField(optionField);
        assertEquals(expected, result);
    }

    @Test
    void 숫자를_추출할_문자열의_잘못된_구분자_포함_테스트() {
        String targetField = "1*2-3,5:7;9";
        String customSeparators = "*;"; // '-' 미포함
        boolean expected = false;
        boolean result = validator.isValidTargetField(targetField, customSeparators);
        assertEquals(expected, result);
    }

    @Test
    void 숫자를_추출할_문자열의_올바른_구분자_포함_테스트() {
        String targetField = "1*2-3,5:7;9";
        String customSeparators = "*-;"; // '-' 포함
        boolean expected = true;
        boolean result = validator.isValidTargetField(targetField, customSeparators);
        assertEquals(expected, result);
    }
}
