package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
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

    // 5.1) 음수가 포함된 경우 테스트
    @Test
    void 음수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 5.2) 잘못된 구분자 형식으로 입력된 경우 테스트
    @Test
    void 잘못된_형식_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;[1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 5.3.1) 구분자 외 문자가 사용된 경우
    @Test
    void 문자_포함_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,n,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 5.3.2) 문자열 앞부분 이외에 커스텀 구분자를 지정한 경우
    @Test
    void 커스텀_구분자_위치_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2;3\\;\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
