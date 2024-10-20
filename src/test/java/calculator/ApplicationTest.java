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
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("1,2;3//%#!\\n4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 빈값_존재() { // 구분자 사이에 아무값도 넣지 않았을 경우
        assertSimpleTest(() -> {
            run("1,,,,3,,");
            assertThat(output()).contains("결과 : 4");
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
    void 예외_테스트2() { // 구분자 사이에 공백이 들어간 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" 1 , ,3 4,3  "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3() { // 숫자 대신 문자가 들어간 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,3,!,%"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
