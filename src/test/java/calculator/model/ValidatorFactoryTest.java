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
}