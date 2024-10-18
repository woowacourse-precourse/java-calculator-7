package calculator;

import calculator.domain.Calculator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 공백입력시_반환값_테스트() {
        Calculator calculator = new Calculator();
        int result = calculator.add("");

        Assertions.assertEquals(0, result);
    }

    @Test
    void null값_처리_테스트() {
        Calculator calculator = new Calculator();
        int result = calculator.add(null);
        Assertions.assertEquals(0, result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
