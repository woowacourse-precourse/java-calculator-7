package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringAddCalculatorTest {
    @Test
    void 빈문자열_또는_null_입력시_0을_반환한다() {
        assertEquals(0, StringAddCalculator.splitAndSum(null));
        assertEquals(0, StringAddCalculator.splitAndSum(""));
    }

    @Test
    void 숫자하나를_입력할_경우_해당_숫자를_반환한다() {
        assertEquals(3, StringAddCalculator.splitAndSum("3"));
    }

    @Test
    void 쉼표구분자로_숫자를_구분한다() {
        assertEquals(6, StringAddCalculator.splitAndSum("1,2,3"));
    }

    @Test
    void 콜론구분자로_숫자를_구분한다() {
        assertEquals(6, StringAddCalculator.splitAndSum("1:2:3"));
    }

    @Test
    void 커스텀구분자를_사용한다() {
        assertEquals(6, StringAddCalculator.splitAndSum("//;\n1;2;3"));
    }

    @Test
    void 음수를_입력하면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringAddCalculator.splitAndSum("-1,2,3");
        });
    }

    @Test
    void 숫자가_아닌_값을_입력하면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringAddCalculator.splitAndSum("a,2,3");
        });
    }
}