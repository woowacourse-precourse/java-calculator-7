package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.constants.Constants;
import org.junit.jupiter.api.Test;

public class UserInputValidatorTest {

    @Test
    void 음수_포함() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate("-1,2,3"))
                .withMessageMatching(Constants.CONTAINS_NEGATIVE);
    }

    @Test
    void 기본_구분자_아님() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate("1.2.3"))
                .withMessageMatching(Constants.WRONG_DELIMITER);
    }

    @Test
    void 정의되지_않은_커스텀_구분자() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate("//;\\n1;2.3"))
                .withMessageMatching(Constants.NOT_DEFINED_CUSTOM);
    }

    @Test
    void 커스텀_구분자_없음() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate("//\\n1;2;3"))
                .withMessageMatching(Constants.NOT_EXIST_CUSTOM);
    }

    @Test
    void 구분자_하나() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate(";"))
                .withMessageMatching(Constants.NOT_CONTAINS_NUMBER);
    }
}
