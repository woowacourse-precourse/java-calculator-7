package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 커스텀_구분자_사용_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 빈_문자열_테스트() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 단일_숫자_테스트() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 콤마_구분자_숫자_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 잘못된_커스텀_구분자_형식_테스트() {
        assertSimpleTest(() -> {
            // IllegalArgumentException 예외가 발생하면 성공
            assertThatThrownBy(() -> runException("//;1;2;3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("커스텀 구분자가 잘못된 형식입니다. 형식: //구분자\\n"); // 예외 메시지 추가
        });
    }

    @Test
    void 커스텀_구분자_내_잘못된_문자_테스트() {
        assertSimpleTest(() -> {
            // IllegalArgumentException 예외가 발생하면 성공
            assertThatThrownBy(() -> run("//a\\n1a2a3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("구분자에 숫자나 알파벳이 포함될 수 없습니다."); // 예외 메시지 추가
        });
    }

    @Test
    void 정의되지_않은_구분자_테스트() {
        assertSimpleTest(() -> {
            // IllegalArgumentException 예외가 발생하면 성공
            assertThatThrownBy(() -> runException("1;2;3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 연속된_구분자_테스트() {
        assertSimpleTest(() -> {
            // IllegalArgumentException 예외가 발생하면 성공
            assertThatThrownBy(() -> run("1,,2"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("구분자가 연속적으로 사용되었습니다."); // 예외 메시지 추가
        });
    }

    @Test
    void 구분자로_끝나는_문자열_테스트() {
        assertSimpleTest(() -> {
            // IllegalArgumentException 예외가 발생하면 성공
            assertThatThrownBy(() -> run("1,2,"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("구분자로 끝날 수 없습니다."); // 예외 메시지 추가
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
