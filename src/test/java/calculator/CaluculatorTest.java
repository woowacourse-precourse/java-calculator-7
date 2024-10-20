package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CalculatorTest extends NsTest {

    @Test
    void 기본_입력_테스트() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_입력_테스트() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0"); // 빈 입력의 경우 0이 반환된다고 가정
        });
    }

    @Test
    void 잘못된_형식의_커맨드_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//;\n1;2;3")) // 잘못된 형식 예시
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Invalid input format. Missing newline after custom delimiter."); // 예외 메시지 확인
        });
    }

    @Test
    void 음수_입력_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Negative numbers are not allowed"); // 예외 메시지 확인
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{}); // 메인 메서드 호출
    }
}
