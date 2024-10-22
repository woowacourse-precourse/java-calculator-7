package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest extends NsTest {

    // 커스텀 구분자를 사용하지 않은 경우 테스트
    @Test
    void 기본_구분자로_입력된_숫자_계산() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 커스텀 구분자 ";"를 사용하는 경우
    @Test
    void 커스텀_구분자로_세미콜론_사용한_숫자_계산() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 커스텀 구분자 "a"를 사용하는 경우
    @Test
    void 커스텀_구분자로_a_사용한_숫자_계산() {
        assertSimpleTest(() -> {
            run("//a\\n1a2a3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 잘못된 입력: 여러 개의 커스텀 구분자를 사용한 경우
    @Test
    void 여러개의_커스텀_구분자_사용시_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;,&\\n1;2&3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 잘못된 입력: 커스텀 구분자가 숫자인 경우
    @Test
    void 커스텀_구분자로_숫자를_사용한_경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n11213"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 잘못된 입력: 공백이 포함된 경우
    @Test
    void 입력값에_공백이_포함된_경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1, 2, 3, 45 67 89"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 음수가 포함된 경우 예외 처리
    @Test
    void 음수가_포함된_경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n-1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}