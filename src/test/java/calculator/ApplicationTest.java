package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @MethodSource("generateDefaultData")
    void 기본_커스텀_구분자_사용_테스트(String element, String expected) {
        run(element);
        assertThat(output()).contains(expected);
    }

    static Stream<Arguments> generateDefaultData() {
        return Stream.of(
                Arguments.of("1:2", "결과 : 3"),
                Arguments.of("1:100", "결과 : 101"), // 한자리수 + 여러자리수
                Arguments.of("1:10,2", "결과 : 13"), // 기본 구분자 여러개 사용
                Arguments.of("\n", "결과 : 0"), // 아무것도 입력안하는 경우
                Arguments.of("//;\\n1;3", "결과 : 4"), // 커스텀 구분자 사용
                Arguments.of("//;\\n", "결과 : 0"), // 커스텀 구분자 사용 & 아무것도 입력안하는 경우
                Arguments.of("//-\\n1-3", "결과 : 4"), // 사칙연산 구분자인 경우
                Arguments.of("//;;\\n1;;3", "결과 : 4"), // 구분자의 길이가 1이아닌경우
                Arguments.of("100000000000000000:100000000000000000", "결과 : 200000000000000000") // Long보다 큰 매우 큰수
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "a,b,c", "1;2,3", ";", ",", "1,,,2", ",1,2", "1,2,"})
    void 기본_입력값_검증_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1,2,3", "//;\\na;b;c", "//;\\n1;2_3",
            "//;\\n;", "//;\\n1;;;2", "//;\\n;1;2", "//;\\n1;2;", "//\\n123",
            "//;\\n\\n1;2;3", "/////123", "/", "\\n1,2,3"})
    void 커스텀_입력값_검증_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
