package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Fail.fail;


public class ValidatorTest {

    Validator validator = new Validator();

    @Test
    void 빈_문자열_테스트() {
        String[] input = {};
        try {
            validator.validation(input); // 예외가 발생하지 않아야 함
        } catch (Exception e) {
            fail("예외가 발생하지 않아야 합니다."); // 예외가 발생하면 테스트 실패
        }
    }

    @Test
    void 숫자가_아닌_값_테스트() {
        String[] input = {"1", "A"};
        assertThatThrownBy(() -> validator.validation(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자가 아닌 값이 포함되었습니다.");
    }
    @Test
    void 음수_입력_테스트() {
        String[] input = {"1", "-1"};
        assertThatThrownBy(() -> validator.validation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수가 입력되었습니다. 양수만 입력해주세요.");
    }
}
