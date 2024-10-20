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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 여러_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            // 커스텀 구분자로 ;와 &를 사용하는 경우
            run("//;|&|@\\n1;2&3,6@8");
            assertThat(output()).contains("결과 : 20");  // 1 + 2 + 3 + 6 + 8 = 20
        });
    }

    @Test
    void 문자_입력시_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자가 아닌 문자가 포함되어 있습니다.")  // 숫자가 아닌 입력이 들어왔을 때
        );
    }

    @Test
    void 정상_케이스() {
        assertSimpleTest(() -> {
            // 쉼표와 콜론을 구분자로 사용하는 기본적인 정상 케이스
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");  // 1 + 2 + 3 = 6
        });
    }

}
