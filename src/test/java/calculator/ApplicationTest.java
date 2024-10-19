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
    void 구분자연속사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;;;;;3;;4;5;");
            assertThat(output()).contains("결과 : 13");
        });
    }
    @Test
    void 마이너스구분자사용(){
        assertSimpleTest(() -> {
            run("//-\\n-1-2-3--4-5--");
            assertThat(output()).contains("결과 : 15");
        });
    }
    @Test
    void 기본구분자_커스텀구분자_같이사용() {
        assertSimpleTest(() -> {
            run("//;\\n1,2,3;4;;5;:6");
            assertThat(output()).contains("결과 : 21");
        });
    }

    @Test
    void 예외_테스트() {
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
