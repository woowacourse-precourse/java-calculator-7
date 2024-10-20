package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.Test;

import calculator.model.Calculator;
import calculator.model.Number;
import camp.nextstep.edu.missionutils.test.NsTest;

class CalculatorTest extends NsTest {

    @Test
    void 계산기로_모든_숫자를_더한다() {
        assertSimpleTest(() -> {
            Calculator calculator = new Calculator();
            BigInteger result = calculator.sum(List.of(
                new Number(new BigInteger("2")),
                new Number(new BigInteger("1")),
                new Number(new BigInteger("3"))
            ));
            BigInteger expect = new BigInteger("6");
           assertThat(result).isEqualTo(expect);
        });
    }

    @Test
    void 계산기로_매우_큰_숫자를_더한다() {
        assertSimpleTest(() -> {
            Calculator calculator = new Calculator();
            BigInteger result = calculator.sum(List.of(
                new Number(new BigInteger("200000000000000000000000000000")),
                new Number(new BigInteger("200000000000000000000000000000"))
            ));
            BigInteger expect = new BigInteger("400000000000000000000000000000");
            assertThat(result).isEqualTo(expect);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
