package calculator.calculateTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ResultTest extends NsTest {
    @Test
    void 공백_쉼표_구분자_사용() {
        assertSimpleTest(() -> {
            run(",1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 공백_콜론_구분자_사용() {
        assertSimpleTest(() -> {
            run(":1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 공백_기본_구분자_사용() {
        assertSimpleTest(() -> {
            run(",1:2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 콜론_구분자_사용() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 쉼표_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자_미사용() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//x\\n1x2x3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 공백_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//x\\nx1x2x3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
