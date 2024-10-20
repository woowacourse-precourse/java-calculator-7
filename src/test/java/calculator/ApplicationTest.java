package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
테스트 입력
"1,2,3"
"1,2:3"
"-1,2,-3"
"1,2,3,"
"1,2:3@4"
"1,;2:3"
"1, 2;3"
"//;\n1;2;2"
"//;\n1,2;3:4"
"//;\n1;2; 3"
"//;\n1:2@3;4"
"//7\n172,3"
"//\n1,2:2"
"//;\n1;10,100:1"
"10,100:1"
*/

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용1() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;2");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//;\\n1,2;3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_사용3() {
        assertSimpleTest(() -> {
            run("//a\\n1,2a3:1");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 커스텀_구분자_사용4() {
        assertSimpleTest(() -> {
            run("//;\\n1;10,100:1");
            assertThat(output()).contains("결과 : 112");
        });
    }

    @Test
    void 기본_구분자_사용1() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용2() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용3() {
        assertSimpleTest(() -> {
            run("10,100:1");
            assertThat(output()).contains("결과 : 111");
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
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3@4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,;2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1, 2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2; 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1:2@3;4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//7\\n172,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트8() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2:2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트9() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//@\\n1,10@ 100"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트10() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("10,100@1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
