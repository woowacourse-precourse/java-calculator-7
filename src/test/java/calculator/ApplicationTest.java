package calculator;

import calculator.controller.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {

    @ParameterizedTest
    @MethodSource("provideInputsForTest")
    void 커스텀_구분자_반복테스트(String input, int expectedResult) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : " + expectedResult);
        });
    }

    // 테스트에 필요한 입력값과 예상 결과를 제공하는 메서드
    static Stream<Arguments> provideInputsForTest() {
        return Stream.of(
                Arguments.of("//;\\n1", 1),         // 커스텀 구분자 ; 사용
                Arguments.of("//,\\n2,3", 5),       // 커스텀 구분자 , 사용
                Arguments.of("//:\\n4:5", 9),       // 커스텀 구분자 : 사용
                Arguments.of("1,2:3", 6)           // 기본 구분자 , 및 : 사용
        );
    }

    // 예외 테스트 케이스
    @Test
    void 양수외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }    @Test
    void 양수외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    void 양수외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Hello,java,backend"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
