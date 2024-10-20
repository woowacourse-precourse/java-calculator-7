package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
    @BeforeEach
    void setUp() {
        // 필요한 경우 애플리케이션의 상태를 초기화
        Application.delimiters = ",|:";  // 예시로 delimiters를 기본값으로 초기화
    }

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
    void testSingleNumber() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void testMultipleNegativeNumbers() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,-2,-3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testCustomDelimiterWithSpecialChar() {
        assertSimpleTest(() -> {
            run("//|\\n1|2|3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void testMultipleCustomDelimiters() {
        assertSimpleTest(() -> {
            run("//#\\n1#2#3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void testCustomDelimiterWithEscapedSpecialChar() {
        assertSimpleTest(() -> {
            run("//\\|\\n1\\|2\\|3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void testNonNumericInput() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,2,A"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testCustomDelimiterWithoutClosing() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3//\\n4;5;6");
            assertThat(output()).contains("결과 : 48");
        });
    }

    @Test
    void testDelimiterWithWhiteSpaces() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;\\n 1 ; 2 ;3 "))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testCustomDelimiterWithMultipleSpecialChars() {
        assertSimpleTest(() -> {
            run("//***\\n1***2***3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void testLargeNumbers() {
        assertSimpleTest(() -> {
            run("1000,2000:3000");
            assertThat(output()).contains("결과 : 6000");
        });
    }

    @Test
    void testCustomDelimiterWithMultipleDifferentDelimiters() {
        assertSimpleTest(() -> {
            run("//|\\n1|2//%\\n%3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
