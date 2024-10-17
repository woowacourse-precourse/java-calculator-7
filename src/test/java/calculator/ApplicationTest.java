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
    void 커스텀_구분자_미사용() {
        assertSimpleTest(() -> {
            run("1,3:5,7");
            assertThat(output()).contains("결과 : 16");
        });
    }

    @Test
    void 커스텀_구분자_글자수_2개이상() {
        assertSimpleTest(() -> {
            run("//abc\\n1abc7");
            assertThat(output()).contains("결과 : 8");
        });
    }

    //==========예외 테스트==========//
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("잘못된 값이 입력 되었습니다.")

        );
    }

    @Test
    void 커스텀_구분자가_공백일때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1abc7"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자를 입력 하세요.")
        );
    }

    @Test
    void 수식이_올바르지_않은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",7,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("잘못된 수식 입니다.")
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
