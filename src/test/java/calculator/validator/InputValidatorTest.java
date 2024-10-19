package calculator.validator;

import calculator.model.dto.DelimiterInputData;
import calculator.model.validator.InputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    void validate_유효한입력_커스텀구분자() {
        // given
        String userInput = "//;\\n1;2;3";

        // when
        InputValidator validator = new InputValidator(userInput);

        // then
        DelimiterInputData result = validator.validatedData();
        System.out.println(result);
        Assertions.assertEquals(';', result.getcustomedDelimiter());
        Assertions.assertEquals("1;2;3", result.getInput(), "입력 본문이 잘못되었습니다.");
    }

    @Test
    void validate_유효한입력_기본구분자() {
        // given
        String userInput = "1,2,3";

        // when
        InputValidator validator = new InputValidator(userInput);

        // then
        DelimiterInputData result = validator.validatedData();
        Assertions.assertNull(result.getcustomedDelimiter(), "커스텀 구분자가 있어서는 안 됩니다.");
        Assertions.assertEquals("1,2,3", result.getInput(), "입력 본문이 잘못되었습니다.");
    }

    @Test
    void validate_잘못된구분자_기본구분자사용() {
        // given
        String userInput = "//,\\n1,2,3"; // 기본 구분자인 ','를 커스텀 구분자로 사용할 경우

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new InputValidator(userInput),
                "기본 구분자는 커스텀 구분자로 사용할 수 없습니다.");
    }

    @Test
    void validate_잘못된구분자_숫자사용() {
        // given
        String userInput = "//1\\n1;2;3"; // 구분자로 숫자를 사용할 경우

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new InputValidator(userInput),
                "구분자의 문자는 숫자가 될 수 없습니다.: 1");
    }

    @Test
    void validate_잘못된입력형식_유효하지않은문자() {
        // given
        String userInput = "1;2;a"; // 유효하지 않은 문자가 포함된 경우

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new InputValidator(userInput),
                "구분자와 숫자 이외의 문자가 포함된 잘못 된 입력입니다.: a");
    }

    @Test
    void validate_빈입력() {
        // given
        String userInput = "";

        // when
        InputValidator validator = new InputValidator(userInput);

        // then
        Assertions.assertNull(validator.validatedData().getcustomedDelimiter(), "빈 입력일 경우 커스텀 구분자는 null이어야 합니다.");
        Assertions.assertEquals("", validator.validatedData().getInput(), "빈 입력일 경우 입력 본문은 빈 문자열이어야 합니다.");
    }
}
