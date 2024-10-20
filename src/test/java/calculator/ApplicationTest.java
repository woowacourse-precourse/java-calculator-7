package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_미사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
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
    void 여려_개의_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2//.\\n3.4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 길이가_긴_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//@@\\n1@2//....\\n3....4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이미_존재하는_구분자_입력에_대한_예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("//:\\n1,2:3"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 등록되지_않은_구분자_사용에_대한_예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("//.\\n1@2:3"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
