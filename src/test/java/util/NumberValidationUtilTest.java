package util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.util.NumberValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidationUtilTest {

    @Test
    @DisplayName("구분자가 아닌 문자 사용")
    public void testValidateNumberStringFormatWithInvalidSeparator() {
        assertThrows(IllegalArgumentException.class, () ->
                NumberValidationUtil.validateNumbers("10000000000000,2/3", ";")
        );
    }

    @Test
    @DisplayName("구분자 다음에 숫자가 오지않음")
    public void testValidateNumberAfterSeparator() {
        assertThrows(IllegalArgumentException.class, () ->
                NumberValidationUtil.validateNumbers("1,2,,", ";")
        );
    }

    @Test
    @DisplayName("숫자가 양수가 아님")
    public void testValidatePositiveNumbers() {
        assertThrows(IllegalArgumentException.class, () ->
                NumberValidationUtil.validateNumbers("1,0,3", ";")
        );
    }

    @Test
    @DisplayName("숫자가 없음")
    public void testValidateWithoutNumbers() {
        assertThrows(IllegalArgumentException.class, () ->
                NumberValidationUtil.validateNumbers(",", ";")
        );
    }

    @Test
    @DisplayName("올바른 숫자 문자열")
    public void testValidNumberString() {
        NumberValidationUtil.validateNumbers("1;2;3", ";");
        NumberValidationUtil.validateNumbers("1 2 3", " ");
        NumberValidationUtil.validateNumbers("1a2a3", "a");
    }
}
