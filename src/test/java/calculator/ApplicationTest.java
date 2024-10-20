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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Test
    void 빈입력2_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 빈입력3_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 빈입력4_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n,,,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 빈입력5_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//?\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 추가_예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;;;\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 추가_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 추가_예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(";\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 추가_예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
