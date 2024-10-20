package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CustomDelimiterTest extends NsTest {

    @Test
    @DisplayName("`//` `\\n` 사이에 있는 문자의 경우 커스텀 구분자로 사용한다.")
    void customDelimiter() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("`//`로 시작해서 `\\n`로 닫히지 않고 안의 문자열에 `//`와 `\\n`이 포함 되어있는 경우 " +
            "`IllegalArgumentException`을 발생시킨다.")
    void illegalDelimiter() {
        assertAll(
                () -> assertThatThrownBy(() -> run("////;\\n3\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 문자가 들어있습니다."),
                () -> assertSimpleTest(() -> {
                    run("////;3\\n");
                    assertThat(output()).contains("결과 : 0");
                })
        );
    }

    @Test
    @DisplayName("커스텀 구분자가 비어있는 경우 예외 호출")
    void NotEmptyCustomDelimiter() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("//\\n1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 커스텀 구분자입니다.")
        );
    }

    @Test
    @DisplayName("커스텀 구분자로만 이루어져 있는 경우 0으로 계산한다.")
    void OnlyCustomDelimiterThenZero() {
        assertSimpleTest(() -> {
            run("//;\\n;");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("커스텀 구분자는 여러 개 작성할 수 있다.")
    void MultipleCustomDelimiter() {
        assertSimpleTest(() -> {
            run("// \\n//temp\\n1temp2 3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자가 중복된 경우 중복을 제거한 후 저장한다.")
    void DuplicateCustomDelimiter() {
        assertSimpleTest(() -> {
            run("//;\\n//!\\n//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("`//`와 `\\n`이 존재하나 `//`가 `/n`보다 뒤에 존재하는 경우 `IllegalArgumentException`을 발생시킨다.")
    void NotMatchCustomDelimiterFormat() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("\\n;//1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 문자가 들어있습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
