package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    // 커스텀 구분자 사용
    @Test
    void use_custom_divider() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;4");
            assertThat(output()).contains("결과 : 7");
        });
    }

    // 한 숫자만 입력했을 때
    @Test
    void input_one_number() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과 : 5");
        });
    }

    // 여러 숫자를 입력했을 때
    @Test
    void input_many_numbers() {
        assertSimpleTest(() -> {
            run("5,4:5,4:5,4:5,4:5,4:5,4:5,4:5,4:5,4:5,4:5,4:5,4:5,4:5,4:5,4:5,4:5,4:5,4:5,4:5,4");
            assertThat(output()).contains("결과 : 180");
        });
    }

    // [오류] 구분자가 연속되어 입력되었을 때
    @Test
    void Error_input_continuous_dividers() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,3::5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // [오류] 구분자 사이에 공백만 있을 때
    @Test
    void Error_blank_between_divider() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1, :5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // [오류] 음수가 입력되었을 때
    @Test
    void Error_negative_number() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // [오류] 커스텀 구분자를 잘못 사용 - "\n" 미사용
    @Test
    void Error_wrong_custom_divider_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // [오류] 커스텀 구분자를 잘못 사용 - "//" 미사용
    @Test
    void Error_wrong_custom_divider_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // [오류] 커스텀 구분자를 잘못 사용 - 커스텀 구분자가 없음
    @Test
    void Error_wrong_custom_divider_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
