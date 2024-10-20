package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    // 커스텀 구분자를 사용하지 않은 경우 테스트
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 커스텀 구분자 ";"를 사용한 경우 테스트
    @Test
    void 커스텀_구분자_사용_세미콜론() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 커스텀 구분자 "a"를 사용한 경우 테스트
    @Test
    void 커스텀_구분자_사용_a() {
        assertSimpleTest(() -> {
            run("//a\\n1a2a3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 잘못된 입력: 커스텀 구분자가 2개일 경우
    @Test
    void 잘못된_입력_구분자_여러개() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;,&\\n1;2&3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 잘못된 입력: 구분자가 숫자인 경우
    @Test
    void 잘못된_입력_구분자가_숫자인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n11213"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 잘못된 입력: 공백이 있는 경우
    @Test
    void 잘못된_입력_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1, 2, 3, 45 67 89"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 음수가 포함된 경우 예외 처리 테스트
    @Test
    void 음수_포함_예외() {
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