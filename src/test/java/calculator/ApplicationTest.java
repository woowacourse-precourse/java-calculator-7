package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.model.Calculator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void nullInputTest() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> Calculator.calculate("//\\n1,2"));
        Assertions.assertEquals(e.getMessage(), "잘못된 입력입니다. 빈칸(\"\")은 구분자가 될 수 없습니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
