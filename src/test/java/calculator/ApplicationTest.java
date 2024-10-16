package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 일반_구분자_사용1() {
        assertSimpleTest(() -> {
            run("8,5,7");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 일반_구분자_사용2() {
        assertSimpleTest(() -> {
            run("3,15;3");
            assertThat(output()).contains("결과 : 21");
        });
    }

    @Test
    void 일반_구분자_사용3() {
        assertSimpleTest(() -> {
            run("21;1,2");
            assertThat(output()).contains("결과 : 24");
        });
    }

    @Test
    void 일반_구분자_사용4() {
        assertSimpleTest(() -> {
            run("11;12;13");
            assertThat(output()).contains("결과 : 36");
        });
    }

    @Test
    void 일반_구분자_사용5() {
        assertSimpleTest(() -> {
            run("13,2,3;6,3;17;32;12,1;1");
            assertThat(output()).contains("결과 : 90");
        });
    }

    @Test
    void 커스텀_구분자_사용1() {
        assertSimpleTest(() -> {
            run("//&\\n1&2&5");
            assertThat(output()).contains("결과 : 8");
        });
    }

    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//12345\\n1123455");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용3() {
        assertSimpleTest(() -> {
            run("//seahwanKim\\n1seahwanKim1seahwanKim1");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_사용4() {
        assertSimpleTest(() -> {
            run("//%$#$^\\n11%$#$^12%$#$^13");
            assertThat(output()).contains("결과 : 36");
        });
    }

    @Test
    void 커스텀_구분자_사용5() {
        assertSimpleTest(() -> {
            run("//안녕\\n11안녕12안녕13");
            assertThat(output()).contains("결과 : 36");
        });
    }

    @Test
    void 예외_테스트1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1?2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("3;-11;2"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("seahwanKim"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//@\\n1@2,5"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트5() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//@1@2,5"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
