package calculator;

import calculator.domain.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidatorTest {

    @Test
    void 음수_포함_문자열() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate("-1,2,3"))
                .withMessageMatching("문자열에 음수가 포함되어있습니다");
    }
}
