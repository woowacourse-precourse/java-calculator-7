package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


class DelimiterValidatorTest {

    @Test
    @DisplayName("커스텀 구분자에 대한 검증 - 성공")
    void validateCustomDelimiterSuccess() {
        // given
        String includeCustomDelimiter = "//[\n1,2:3[4";
        DelimiterValidator validator = new DelimiterValidator(includeCustomDelimiter);

        // when
        boolean validated = validator.validateCustomDelimiter();

        // then
        Assertions.assertTrue(validated);
    }

    @Test
    @DisplayName("커스텀 구분자의 조건 확인 - 실패")
    void validateCustomDelimiterConditionFail() {
        // given
        String wrongCustomDelimiter = "//[\123";
        DelimiterValidator validator = new DelimiterValidator(wrongCustomDelimiter);

        // when
        boolean validated = validator.validateCustomDelimiter();

        // then
        Assertions.assertFalse(validated);
    }

    @Test
    @DisplayName("커스텀 구분자 입력을 하지 않았을 경우 - 실패")
    void validateCustomDelimiterFail() {
        // given
        String wrongCustomDelimiter = "//\n12";
        DelimiterValidator validator = new DelimiterValidator(wrongCustomDelimiter);

        // expected
        Assertions.assertThrows(IllegalArgumentException.class, validator::validateCustomDelimiter);
    }

    @Test
    @DisplayName("커스텀 구분자가 올바른 범위내에 존재하는지 - 실패")
    void validateCustomRangeFail() {
        // given
        String wrongCustomDelimiter = "\n//12";
        DelimiterValidator validator = new DelimiterValidator(wrongCustomDelimiter);

        // expected
        Assertions.assertFalse(validator::validateCustomDelimiter);
    }
}