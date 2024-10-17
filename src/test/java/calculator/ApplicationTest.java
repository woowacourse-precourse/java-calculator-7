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
    void 정수_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 음수_사용() {
        assertSimpleTest(() -> {
            run("-1,2,3");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    void 실수_사용() {
        assertSimpleTest(() -> {
            run("1.1,2,3");
            assertThat(output()).contains("결과 : 6.1");
        });
    }

    @Test
    void 공백_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 예외_테스트1() {
        assertSimpleTest(() -> {
            run(",1   1");
            assertThat(output()).contains("결과 : 11");
        });
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() -> {
            run("1 , 1, 1  1");
            assertThat(output()).contains("결과 : 13");
        });
    }

    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("////가나다라"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//..\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

//
//    @Test
//    void 예외_테스트5() {
//        assertSimpleTest(() -> {
//            run("");
//            assertThat(output()).contains("");
//        });
//    }
//
//
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("-1,2,3"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}