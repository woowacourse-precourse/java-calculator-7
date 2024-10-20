package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 기본_케이스() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 길이가_긴_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//&&\\n1&&2&&3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 네개이상_피연산자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 미등록_연산자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 알파벳_예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Hi! I'm Minjun"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 알파벳_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,hi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 특수_연산자_사용1() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 특수_연산자_사용2() {
        assertSimpleTest(() -> {
            run("//^\\n1^2^3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
