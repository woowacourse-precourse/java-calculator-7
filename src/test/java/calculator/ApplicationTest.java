package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("커스텀 구분자 사용")
    void testCustomDelimiterWithMultipleNumbers() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("long형으로 받을 수 없는 큰 숫자 사용")
    void testCustomDelimiterWithHugeNumbers() {
        assertSimpleTest(() -> {
            run("//;\\n100000000000000000000;200000000000000000000");
            assertThat(output()).contains("결과 : 300000000000000000000");
        });
    }

    @Test
    @DisplayName("빈 문자열 사용")
    void testEmpty() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 문자열만 사용")
    void testCustomDelimiterWithoutNumbers() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("특수 문자 \"를 커스텀 구분자로 사용")
    void testCustomDelimiterWithSpecialCharacters1() {
        assertSimpleTest(() -> {
            run("//\"\\n1\"2\"3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("특수 문자 \\를 커스텀 구분자로 사용")
    void testCustomDelimiterWithSpecialCharacters2() {
        assertSimpleTest(() -> {
            run("//\\\\n1\\2\\3");
            assertThat(output()).contains("결과 : 6");
        });
    }


    @Test
    @DisplayName("커스텀 구분자 문자열 형식 오류")
    void testExceptionWithInvalidCustomDelimiter() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("빈 커스텀 구분자 문자열 오류")
    void testExceptionWithEmptyCustomSeparator() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("두개 이상의 커스텀 구분자 사용")
    void testExceptionWithMultipleCustomSeparator() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//@;~\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자 사용")
    void testExceptionWithNumberCustomSeparator() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("구분자 뒤에 숫자가 오지않음")
    void testExceptionWithMissingNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}