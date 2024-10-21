package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource("사용자입력_예외케이스")
    void 커스텀_예외(final String userInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(userInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    static Stream<Arguments> 사용자입력_예외케이스() {
        return Stream.of(
                Arguments.of("//\\n"),
                Arguments.of("//\\\n"),
                Arguments.of("//1\\n\\n"),
                Arguments.of("//12"),
                Arguments.of("\\n12"),
                Arguments.of("////\n"),
                Arguments.of("//12\\n1,2,3"),
                Arguments.of("//\\n1,2,3:4")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
