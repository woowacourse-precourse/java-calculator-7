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

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(()-> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 음수_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("음수는 허용되지 않습니다: -1")
        );
    }

    @Test
    void 예외테스트커스텀구분자누락테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자 형식이 잘못되었습니다.")
        );
    }

    @Test
    void 연속된_구분자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("연속된 구분자는 허용되지 않습니다.")
        );
    }

    @Test
    void 구분자로_끝나는_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("마지막에 구분자가 올 수 없습니다.")
        );
    }

    @Test
    void 유효하지_않은_숫자_포함_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("유효하지 않은 숫자입니다: a")
        );
    }

    @Test
    void 커스텀_구분자_형식_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2;"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("마지막에 구분자가 올 수 없습니다.")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자 형식이 잘못되었습니다.")
        );
    }

    @Test
    void 기본_구분자_결과값_일치(){
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 공백_입력_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("유효하지 않은 숫자입니다:  "));
    }

    @Test
    void 커스텀_구분자_파싱_테스트() {
        String input = "//;;\n1;;2;;3";
        String expectedDelimiter = ";;";

        String parsedDelimiter = parseCustomDelimiter(input);

        // 파싱된 구분자가 예상한 구분자와 같은지 검증
        assertThat(parsedDelimiter).isEqualTo(expectedDelimiter);
    }

    // 커스텀 구분자 파싱 메서드
    private String parseCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            if (newlineIndex != -1) {
                return input.substring(2, newlineIndex);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
