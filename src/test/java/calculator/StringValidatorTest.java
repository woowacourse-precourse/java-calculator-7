package calculator;

import calculator.domain.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringValidatorTest {

    @Test
    void 음수_포함_문자열() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate("-1,2,3"))
                .withMessageMatching("문자열에 음수가 포함되어있습니다");
    }

    @Test
    void 기본_구분자_아닌_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate("1.2.3"))
                .withMessageMatching("잘못된 구분자입니다");
    }

    @Test
    void 정의되지_않은_커스텀_구분자() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate("//;\\n1;2.3"))
                .withMessageMatching("정의되지 않은 커스텀 구분자가 있습니다");
    }
}
