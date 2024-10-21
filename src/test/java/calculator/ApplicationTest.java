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

    /* 추가 테스트 */

    // 기본 구분자 테스트
    @Test
    void 기본_구분자_쉼표_콜론_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 잘못된 형식 예외 테스트
    @Test
    void 잘못된_형식_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,n2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다.")
        );
    }

    // 여러 구분자 혼합 예외 테스트
    @Test
    void 여러_구분자_혼합_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,2:3;4"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다.")
        );
    }

    // 커스텀 구분자 및 기본 구분자 혼합 예외 테스트
    @Test
    void 커스텀_및_기본_구분자_혼합_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//#\\n1#2,3:4"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다.")
        );
    }

    // 한 자리 이상의 숫자 처리 테스트
    @Test
    void 한_자리_이상_숫자_테스트() {
        assertSimpleTest(() -> {
            run("10,20:30");
            assertThat(output()).contains("결과 : 60");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
