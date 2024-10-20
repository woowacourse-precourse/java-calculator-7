package calculator;

import calculator.domain.StringCalculator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest extends NsTest {
    @Test
    void 디폴트_구분자일_경우() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculateSum("1,2:3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자일_경우() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculateSum("//;\\n1;2;3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수_입력_시_예외_테스트() {
        StringCalculator calculator = new StringCalculator();

        assertThatThrownBy(() -> calculator.calculateSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
