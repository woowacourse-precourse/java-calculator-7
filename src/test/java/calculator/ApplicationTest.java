package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Nested
    @DisplayName("커스텀 구분자 테스트")
    class CustomSeparatorTest{

        // ==== Assertions.assertAll 적용 ====
        @Test
        void 커스텀_구분자_사용() {
            Assertions.assertAll(
                    () -> {
                        run("//;\\n1");
                        assertThat(output()).contains("결과 : 1");
                    },
                    () -> assertThatThrownBy(() -> runException("//😀\\n1😀2😀3"))
                            .isInstanceOf(IllegalArgumentException.class),
                    () -> assertThatThrownBy(() -> runException("//ㄱㄱ\\n1ㄱㄱ2ㄱㄱ3"))
                            .isInstanceOf(IllegalArgumentException.class),
                    () -> assertThatThrownBy(() -> runException("//2\\n12325"))
                            .isInstanceOf(IllegalArgumentException.class)
            );

        }

        // ==== ValueSource 적용해보기 ====
        @ParameterizedTest
        @ValueSource(strings = { "//;\\n1;2;3", "//ㅎ\\n1ㅎ2ㅎ3", "//ㄱ\\n1ㄱ2:3", "//n\\n1n2:2,1", "//-\\n1-2-2,1"})
        void 가능한_커스텀_구분자_사용(String input) {
            assertSimpleTest(() -> {
                run(input);
                assertThat(output()).contains("결과 : 6");
            });
        }

        // ==== MethodSource 적용해보기 ====
        static Stream<Arguments> customInputs() {
            return Stream.of(
                    Arguments.of("지정되지 않은 커스텀 문자 사용", "//;\\n1;2ㄱ3"),
                    Arguments.of("이모티콘 구분자 사용", "//😀\\n1😀2😀3"),
                    Arguments.of("두글자 구분자 사용", "//ㄱㄱ\\n1ㄱㄱ2:3"),
                    Arguments.of("숫자 구분자 사용", "//2\\n12325")
            );
        }
        @ParameterizedTest(name = "{index} - {0}")
        @MethodSource("customInputs")
        void 불가능한_커스텀_구분자_사용(String description, String input) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }


        // ==== CsvSource 적용해보기 ====
        /*
        @ParameterizedTest(name = "{index} - {0}")
        @CsvSource({
                "'지정되지 않은 커스텀 문자 사용', '//;\\n1;2ㄱ3'",
                "'이모티콘 구분자 사용', '//😀\\n1😀2😀3'",
                "'중복 문자 구분자 사용', '//ㄱㄱ\\n1ㄱㄱ2:3'",
                "'숫자 구분자 사용', '//2\\n12325'"
        })
        void 불가능한_커스텀_구분자_사용_테스트3(String description, String input) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
         */

        @Test
        void 커스텀_구분자를_음수기호로_지정하고_음수를_입력한_경우(){
            // [1, 2, null, 3] 으로 분리하게 되므로, 숫자가 아니라는 오류가 발생해야 한다.
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("//-\\n1,2,-3"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }


    @ParameterizedTest(name = "{index} - {0}")
    @CsvSource({
            "'기본 구분자 혼합(: ,) 사용', '1:2,3'",
            "'기본 구분자(:) 구분자 사용', '1:2:3'",
            "'기본 구분자(,) 구분자 사용', '1,2,3'"
    })
    void 기본_구분자_사용(String description, String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 6");
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
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
