package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("커스텀 구분자 여러 개 지정")
    void manyCustomDelimiter(){
        run("//;\\n//!\\n1,2;3!4");
        assertThat(output()).contains("결과 : 10");
    }

    @Test
    @DisplayName("구분자 여러개 사용")
    void many_Delimiter(){
        run("//;\\n1,2;3");
        assertThat(output()).contains("결과 : 6");
    }

    @Test
    @DisplayName("숫자만 사용")
    void onlyNumber(){
        run("123");
        assertThat(output()).contains("결과 : 123");
    }

    @Test
    @DisplayName("지정되지 않은 구분자 사용")
    void notAssignDelimiter(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자 없이 구분자만 사용")
    void withoutNumber(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("음수 사용")
    void negativeNumber() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("//만 사용")
    void notEndDelimiter() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("\\n만 사용")
    void notStartDelimiter() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("구분자로 문자열 시작")
    void startDelimiter() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",1,2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자로 문자열 안 끝나는 경우")
    void notEndNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
