package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 단일_숫자_입력(){
        assertSimpleTest(() -> {
            assertThat(Calculator.add("7")).isEqualTo(7);
        });
    }

    @Test
    void 빈_문자열_사용(){
        assertSimpleTest(() -> {
            assertThat(Calculator.add("")).isEqualTo(0);
        });
    }

    @Test
    void 구분자_단독_사용(){
        assertThat(Calculator.add(":,")).isEqualTo(0);
    }

    @Test
    void 커스텀_구분자_사용() {
        assertThat(Calculator.add("//;\n1;2")).isEqualTo(3);
    }

    @Test
    void 커스텀_구분자() {
        assertSimpleTest(() -> {
            assertThat(Calculator.add("//-\n1-2-3")).isEqualTo(6);
        });
    }

    @Test
    void 연속_구분자() {
        assertSimpleTest(() -> {
            assertThat(Calculator.add("1::2,3")).isEqualTo(6);
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Calculator.add("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("음수는 허용되지 않습니다")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}