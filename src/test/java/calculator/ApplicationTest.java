package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 정상_계산_1() {
        assertSimpleTest(() -> {
            run("1,1,1");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 정상_계산_2() {
        assertSimpleTest(() -> {
            run("1:1:1");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_포함_정상_계산_1() {
        assertSimpleTest(() -> {
            run("//a\\n1a1a1");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_포함_정상_계산_2() {
        assertSimpleTest(() -> {
            run("///\\n1/1/1/");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_포함_정상_계산_3() {
        assertSimpleTest(() -> {
            run("//\\\\n1\\1\\1");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_포함_정상_계산_4() {
        assertSimpleTest(() -> {
            run("//\\n1,1:1");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_포함_정상_계산_5() {
        assertSimpleTest(() -> {
            run("//-\\n1-1-1");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_포함_정상_계산_6() {
        assertSimpleTest(() -> {
            run("//-\\n1---1-1");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }


    @Test
    void 역슬레쉬_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//\\\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 슬레쉬_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("///\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void n_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//n\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 물음표_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//?\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_비어있음() {
        assertSimpleTest(() -> {
            run("//\\n1");
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
    void 예외_테스트_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1-"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//a\\n1-1a1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수_5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n-11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수_6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11,-11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_입력형식_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("askdjg;asijeag"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_입력형식_오류2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1+1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
