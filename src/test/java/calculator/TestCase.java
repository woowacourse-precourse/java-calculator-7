package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


public class TestCase extends NsTest {
    @Test
    void 구분자_테스트() {
        assertSimpleTest(() -> {
            run(";;;");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 빈문자열_테스트() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 빈구분자_테스트() {
        assertSimpleTest(() -> {
            run("//\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
