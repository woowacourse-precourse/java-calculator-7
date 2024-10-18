package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    StringCalculator cal = new StringCalculator();
    @Test
    void 공백시_0_반환() {
        assertThat(cal.add("")).isEqualTo(0);
        assertThat(cal.add(null)).isEqualTo(0);
    }

    @Test
    void 기본_구분자_숫자_하나_사용() {
        assertThat(cal.add("1")).isEqualTo(1);
    }

    @Test
    void 기본_구분자_숫자_둘_사용() {
        assertThat(cal.add("1,2")).isEqualTo(3);
    }

    @Test
    void 기본_구분자_숫자_셋_사용() {
        assertThat(cal.add("1,2,3")).isEqualTo(6);
        assertThat(cal.add("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 기본_구분자_배열() {
        String defaultarr[] = {"1", "2", "3"};
        assertThat(cal.splitString("1,2,3")).isEqualTo(defaultarr);
    }

    @Test
    void 커스텀_구분자_배열() {
        String customarr[] = {"1", "2", "3"};
        assertThat(cal.splitString("//;\\n1;2;3")).isEqualTo(customarr);
    }

    @Test
    void 예외_테스트_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("사용자가 잘못된 값을 입력하였습니다.")
        );
    }

    @Test
    void 예외_테스트_단어() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,@,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("사용자가 잘못된 값을 입력하였습니다.")
        );
    }

    @Test
    void 예외_테스트_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("사용자가 잘못된 값을 입력하였습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}