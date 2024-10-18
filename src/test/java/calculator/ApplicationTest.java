package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 음수_입력_오류_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_테스트() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자_하나_테스트() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 기본_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 중간_빈_숫자에_오류_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1,,3"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 뒷_빈_숫자에_오류_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("//;\\n1;2;3;"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 앞_빈_숫자에_오류_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("//;\\n;1;2;3"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
