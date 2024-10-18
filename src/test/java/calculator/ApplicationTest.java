package calculator;

import calculator.model.Calculator;
import calculator.model.Number;
import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import java.util.List;

class ApplicationTest extends NsTest {

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_형식의_값을_입력하면_예외가_발생한다() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-one,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산기_테스트() {
        Calculator calculator = new Calculator();
        BigInteger sum = calculator.sum(List.of(
            new Number(BigInteger.valueOf(1L)),
            new Number(BigInteger.valueOf(3L)),
            new Number(BigInteger.valueOf(2L))
        ));
        assertThat(sum).isEqualTo(6);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
