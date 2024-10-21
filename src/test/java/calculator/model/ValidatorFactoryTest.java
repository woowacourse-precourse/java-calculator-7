package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorFactoryTest {

    @Test
    @DisplayName("커스텀 구분자 문자열 입력시 CustomValidator를 생성한다")
    void 커스텀_구분자_Validator_생성() {
        // given
        String customDelimiterInput = "//*\\n1*2*3";

        // when
        Validator validator = ValidatorFactory.createValidator(customDelimiterInput);

        // then
        assertInstanceOf(CustomValidator.class, validator);
    }

    @Test
    @DisplayName("기본 구분자 문자열 입력시 DefaultValidator를 생성한다.")
    void 기본_구분자_Validator_생성() {
        String defaultDelimiterInput = "1,2,3";

        Validator validator = ValidatorFactory.createValidator(defaultDelimiterInput);

        assertInstanceOf(DefaultValidator.class, validator);
    }

    @Test
    @DisplayName("커스텀 구분자 문자열 정규표현식을 만족하지 않는 경우 DefaultValidator를 생성한다.")
    void 커스텀_구분자_이외의_입력_Validator_생성() {
        String notCustomDelimiterInput = "//*n1*2*3";

        Validator validator = ValidatorFactory.createValidator(notCustomDelimiterInput);

        assertInstanceOf(DefaultValidator.class, validator);
    }
}