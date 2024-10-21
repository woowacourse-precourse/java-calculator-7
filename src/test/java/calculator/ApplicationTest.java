package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 특정_구분자_사용() {
        assertSimpleTest(() -> {
            run("//-\\n1-3--5-7");
            assertThat(output()).contains("결과 : 16");
        });
    }

    @Test
    void 커스텀_구분자만_사용() {
        assertSimpleTest(() -> {
            run("//-\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자_구분자_사용() {
        assertSimpleTest(() -> {
            run("//3\\n11,3:537,10");
            assertThat(output()).contains("결과 : 33");
        });
    }

    @Test
    void 공백_구분자_사용() {
        assertSimpleTest(() -> {
            run("// \\n1:3 5 7, 10");
            assertThat(output()).contains("결과 : 26");
        });
    }

    @Test
    void 문자열_구분자_사용() {
        assertSimpleTest(() -> {
            run("//a?\\n1a?3,5a?7:10");
            assertThat(output()).contains("결과 : 26");
        });
    }

    @Test
    void 문자커스텀_기본_모두_사용() {
        assertSimpleTest(() -> {
            run("//a\\n11:3,5:7a10");
            assertThat(output()).contains("결과 : 36");
        });
    }

    @Test
    void 예외_테스트_커스텀외_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n1-2?3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_구분용으로_사용한_구분자_사용() {
        assertSimpleTest(() -> {
            run("//|\\n11,3:5|7,10");
            assertThat(output()).contains("결과 : 36");
        });
    }

    @Test
    void 이스케이프_커스텀_사용() {
        assertSimpleTest(() -> {
            run("//?\\n11?3?5?7?10");
            assertThat(output()).contains("결과 : 36");
        });
    }

    @Test
    void 빈_문자열_사용() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 한자리_초과_숫자() {
        assertSimpleTest(() -> {
            run("11:3,5:7");
            assertThat(output()).contains("결과 : 26");
        });
    }

    @Test
    void 소수점_사용() {
        assertSimpleTest(() -> {
            run("1,2.2,3");
            assertThat(output()).contains("결과 : 6.2");
        });
    }

    @Test
    void 유리수_사용() {
        assertSimpleTest(() -> {
            run("1,1/4,3/4");
            assertThat(output()).contains("결과 : 2");
        });
    }

    @Test
    void 무리수_사용() {
        assertSimpleTest(() -> {
            run("e,pi");
            assertThat(output()).contains("결과 : 5.8598744820488382067935617669");
        });
    }

    @Test
    void 예외_테스트_0_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,0,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_마무리() {
        assertSimpleTest(() -> {
            run("1:5,4:");
            assertThat(output()).contains("결과 : 10");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
