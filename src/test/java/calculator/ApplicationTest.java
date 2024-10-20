package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @Test
    @DisplayName("구분자 테스트")
    void DelimiterTest() {
        assertAll(
                //커스텀 구분자가 존재하지 않고, ','와 ':'를 제외한 다른 문자열이 있을 경우 예외를 발생시킨다.
                () -> assertThatThrownBy(() -> run("1,2'3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 문자가 들어있습니다."),

                //구분자로 나눈 문자열이 빈 칸일 경우 0으로 저장한다.
                () -> assertSimpleTest(() -> {
                    run("1,,2");
                    assertThat(output()).contains("3");
                })
        );
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void CustomDelimiterTest() {
        assertAll(
                // `//` `\n` 사이에 있는 문자의 경우 커스텀 구분자로 사용한다.
                () -> assertSimpleTest(() -> {
                    run("//;\\n1;2;3");
                    assertThat(output()).contains("6");
                }),

                // `//`로 시작해서 `\n`로 닫히지 않고 안의 문자열에 `//`와 `\n`이 포함 되어있는 경우
                // `IllegalArgumentException`을 발생시킨다.
                () -> assertThatThrownBy(() -> run("////;\\n3\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 문자가 들어있습니다."),
                () -> assertSimpleTest(() -> {
                    run("////;3\\n");
                    assertThat(output()).contains("0");
                }),

                // 커스텀 구분자가 비어있는 경우 예외 호출
                () -> assertThatThrownBy(() -> run("//\\n1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 커스텀 구분자입니다."),

                // 커스텀 구분자로만 이루어져 있는 경우 0으로 계산한다.
                () -> assertSimpleTest(() -> {
                    run("//;\\n;");
                    assertThat(output()).contains("0");
                }),

                // 커스텀 구분자는 여러 개 작성할 수 있다.
                () -> assertSimpleTest(() -> {
                    run("// \\n//temp\\n1temp2 3");
                    assertThat(output()).contains("6");
                })
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
