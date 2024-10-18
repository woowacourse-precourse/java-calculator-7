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
    void 예외_테스트_음수() {
        assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 허용되지 않습니다.");
    }
    @Test
    void 예외_테스트_잘못된_형식() {
        assertThatThrownBy(() -> runException("1,2,abc"))  // 잘못된 형식 테스트
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 형식이 잘못되었습니다.");
    }
    public void runException(String input) {
        Application.add(input); // 예외를 발생시키는 메서드 호출
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
