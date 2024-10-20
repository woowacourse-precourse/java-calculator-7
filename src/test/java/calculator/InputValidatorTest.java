package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator(new DelimiterManager());

    @Test
    void 빈_문자열_입력_처리_테스트() {
        String input = "";
        assertThat(inputValidator.isEmptyInput(input)).isTrue();
    }

    @Test
    void 등록되지_않은_구분자_검증_테스트() {
        List<String> delimiters = List.of(";",":",",");

        assertThatThrownBy(() -> inputValidator.validateUnregisteredDelimiter(delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("등록되지 않은 구분자가 포함되어 있습니다.");
    }

    @Test
    void 기본_구분자_형식_검증_테스트_숫자_형식() {
        String input = "1:2;123b";

        assertThatThrownBy(() -> inputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 형식의 입력입니다.");
    }

    @Test
    void 기본_구분자_형식_검증_테스트_숫자_누락() {
        String input = "1:;123";

        assertThatThrownBy(() -> inputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 형식의 입력입니다.");
    }

    @Test
    void 커스텀_구분자_형식_검증_테스트() {
        String input = "//;\n1:2;3";

        assertThatThrownBy(() -> inputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 커스텀 구분자 형식입니다.");
    }

}