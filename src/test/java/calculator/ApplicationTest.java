package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
    @ParameterizedTest(name = "{index} - {0}")
    @CsvSource({
            "'기본 구분자 혼합(: ,) 사용', '1:2,3'",
            "'기본 구분자(:) 구분자 사용', '1:2:3'",
            "'기본 구분자(,) 구분자 사용', '1,2,3'"
    })
    void 기본_구분자_사용(String description, String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
