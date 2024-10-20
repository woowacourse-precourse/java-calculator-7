package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
    @MethodSource("inputProvider")
    @DisplayName("다양한 구분자를 사용한 값 합계 테스트")
    public void testCalculateSum(String input, int expectedSumResult) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : " + expectedSumResult);
        });
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("\n", 0), // 빈 문자열
                Arguments.of("1", 1), // 기본 구분자
                Arguments.of("1,2", 3),
                Arguments.of("1,2:3", 6),
                Arguments.of("//;\\n1;2", 3), // 커스텀 구분자 - ;
                Arguments.of("// \\n1 2", 3), // 커스텀 구분자 - {공백}
                Arguments.of("//?\\n1?2", 3), // 커스텀 구분자 - ?
                Arguments.of("//;;\\n1;;2;;3", 6), // 커스텀 구분자 - ;;
                Arguments.of("//;;;;;\\n1;;;;;2;;;;;3", 6), // 커스텀 구분자 - ;;;;;(5자)
                Arguments.of("//;\\n1,2:3;4", 10), // 커스텀 구분자
                Arguments.of("//-\\n1-2", 3) // 커스텀 구분자 - -
        );
    }

    @ParameterizedTest
    @MethodSource("exceptionInputProvider")
    @DisplayName("잘못된 입력 값으로 예외 발생 테스트")
    public void testInvalidInputThrowsException(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    static Stream<Arguments> exceptionInputProvider() {
        return Stream.of(
                Arguments.of(";1;2"), // 첫 시작이 구분자
                Arguments.of("1::::"), // 무분별한 구분자
                Arguments.of("test"), // 양수가 아닌 문자
                Arguments.of("1:-2:-2"), // 양수가 아닌 문자
                Arguments.of("-1,2,3"),
                Arguments.of("/1,2,3"), // 커스텀 구분자 조건 미충족
                Arguments.of("!//!\\n1!1"),
                Arguments.of("/;\\n1"),
                Arguments.of("//;;1;;2;;3"), // \n 누락
                Arguments.of("/n;\\n1"),
                Arguments.of("//;n1"),
                Arguments.of("//1\\n112"), // 구분자가 될 수 없는 정수형
                Arguments.of("//!1!\\n11!1!2!1!"),
                Arguments.of("//!!!!!!\\n1!!!!!!2"), // 1 ~ 5자를 초과한 구분자
                Arguments.of("//\\n12"), // 커스텀 구분자 미입력
                Arguments.of("2147483647:2"), // 정수형 표햔 범위를 벗어난 경우
                Arguments.of("                    ") //무분별한 공백
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
