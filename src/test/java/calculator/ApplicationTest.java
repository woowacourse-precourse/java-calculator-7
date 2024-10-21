package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 구분자_사용1() {
        assertSimpleTest(() -> {
            run("1:2:3,4,5");
            assertThat(output()).contains("결과 : 15");
        });
    }
    @Test
    void 커스텀_구분자_사용1() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }
    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//1\\n3412");
            assertThat(output()).contains("결과 : 36");
        });
    }
    @Test
    void 커스텀_구분자_사용3() {
        assertSimpleTest(() -> {
            run("///\\n3/2");
            assertThat(output()).contains("결과 : 5");
        });
    }
    @Test
    void 커스텀_구분자_사용4() {
        assertSimpleTest(() -> {
            run("//~\\n//|\\n3~2|1");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\\n;//1,2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
