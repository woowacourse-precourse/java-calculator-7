package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @DisplayName("[정상] 커스텀 문자열 결과")
    @Test
    void custom() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @DisplayName("[예외] 음수가 포함된 경우")
    @Test
    void negativeNum() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @DisplayName("[정상] 빈 문자열은 0 출력")
    @Test
    void emptyToZero() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @DisplayName("[정상] 복잡한 숫자문자열")
    @Test
    void complexInput() {
        assertSimpleTest(() -> {
            run("//|\\n2|5|10");
            assertThat(output()).contains("결과 : 17");
        });
    }

    @DisplayName("[정상] escape 커스텀 구분자")
    @Test
    void escape() {
        assertSimpleTest(() -> {
            run("//*\\n10*20*30");
            assertThat(output()).contains("결과 : 60");
        });
    }

    @DisplayName("[예외] 공백이 포함된 경우")
    @Test
    void emptyNum() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//|\\n2| |5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("[예외] 구분자가 연속하는 경우")
    @Test
    void duplicatedSeparator() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("[정상] int 범위 초과")
    @Test
    void intOverflow() {
        assertSimpleTest(() -> {
            run("2147483647,1");
            assertThat(output()).contains("결과 : 2147483648");
        });
    }
}
