package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest extends NsTest {

    @Test
    @DisplayName("빈 문자열 입력 시 0을 반환해야 한다")
    void 빈_문자열_입력시_0반환() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("기본 구분자로 입력된 숫자를 계산해야 한다")
    void 기본_구분자로_입력된_숫자_계산() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자로 세미콜론을 사용할 경우 숫자를 계산해야 한다")
    void 커스텀_구분자로_세미콜론_사용한_숫자_계산() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자로 a를 사용할 경우 숫자를 계산해야 한다")
    void 커스텀_구분자로_a_사용한_숫자_계산() {
        assertSimpleTest(() -> {
            run("//a\\n1a2a3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("여러 개의 커스텀 구분자를 사용할 경우 예외가 발생해야 한다")
    void 여러개의_커스텀_구분자_사용시_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;,&\\n1;2&3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 구분자가 숫자인 경우 예외가 발생해야 한다")
    void 커스텀_구분자로_숫자를_사용한_경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n11213"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력값에 공백이 포함된 경우 예외가 발생해야 한다")
    void 입력값에_공백이_포함된_경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1, 2, 3, 45 67 89"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("음수가 포함된 경우 예외가 발생해야 한다")
    void 음수가_포함된_경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n-1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("0이 포함된 경우 예외가 발생해야 한다")
    void 양수가_아닌값_0이_포함된_경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n0;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}