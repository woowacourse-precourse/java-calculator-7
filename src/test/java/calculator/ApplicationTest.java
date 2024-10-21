package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    public static String formatStringWithDelimiter(String template, String delimiter) {
        Pattern pattern = Pattern.compile("%s");
        Matcher matcher = pattern.matcher(template);
        return matcher.replaceAll(Matcher.quoteReplacement(delimiter));
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("빈 문자열인 경우 0 반환")
    void assertBlankStringToZero() {
        assertSimpleTest(() -> {
            run("", "\n");
            assertThat(output()).contains("0");
        });
    }

    @Test
    @DisplayName("여러 숫자 입력 (쉼표와 콜론 혼용)")
    void assertMultipleNumbersWithCommaAndColon() {
        assertSimpleTest(() -> {
            run("1,2:3,4:5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    @DisplayName("`//`만 있고 `\n`이 없는 경우 예외를 던짐")
    void assertThrowExceptionWhenNoEndCommand() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("missing newline after header"));
    }

    @Test
    @DisplayName("구분자가 한글자 이상인 경우")
    void assertSingleCharacterDelimiter() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//kk\\n1kk2kk3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("invalid length"));
    }

    @Test
    @DisplayName("구분자가 공백인 경우")
    void assertNotBeBlankDelimiter() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n123"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("delimiter cannot be blank")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {",", ":"})
    @DisplayName("기존 구분자를 다시 커스텀 구분자로 등록하는 경우")
    void assertAlsoAbleToCustomizeDefaultDelimiter(String delimiter) {
        String arg = formatStringWithDelimiter("//%s\\n1%s2%s3", delimiter);
        assertSimpleTest(() -> {
            run(arg);
            assertThat(output()).contains("6");
        });
    }

    @Test
    @DisplayName("개행문자가 사용자 지정 구분자인 경우")
    void assertNotAllowNewlineCommandAsDelimiter() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\n\n123"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("구분자가 숫자인 경우는 제외한다")
    void assertNotAllowDigitDelimiter() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//0\\n10203"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("delimiter cannot be a digit"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:2:3", "1,2,3", "//\n123", "//n\\n1n2n3", "//kk\\n1kk2kk3", "//-\\n-1-2-3"})
    @DisplayName("시스템 문자열은 항상 출력됨")
    void assertMustContainSystemMessage(String argument) {
        assertSimpleTest(() -> {
            try {
                run(argument);
                assertThat(output()).contains("덧셈할 문자열을 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                //예외에 대한 테스트 X
            }
        });
    }
}
