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
    void 기본_구분자_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 공백과_숫자를_섞었을_경우_덧셈이_되어야_한다_기본_구분자() {
        assertSimpleTest(() -> {
            run(",2,3");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 공백과_숫자를_섞었을_경우_덧셈이_되어야_한다_커스텀_구분자() {
        assertSimpleTest(() -> {
            run("//;\\n;2;3;");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 공백과_숫자를_섞었을_경우_덧셈이_되어야_한다_기본_구분자_커스텀_구분자() {
        assertSimpleTest(() -> {
            run("//;\\n;2:3,4");
            assertThat(output()).contains("결과 : 9");
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
    void 숫자와_구분자가_아닌_문자를_넣었을_경우_예외가_발생한다_기본_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,d,f"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자와_구분자가_아닌_문자를_넣었을_경우_예외가_발생한다_커스텀_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1,f,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
