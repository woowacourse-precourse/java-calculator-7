package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 빈문자열_입력(){
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output().contains("결과 : 0"));
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 구분자_마이너스_사용() {
        assertSimpleTest(() -> {
            run("//-\\n1-2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 구분자_마이너스_사용2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//-\\n1--2"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 음수_입력_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
