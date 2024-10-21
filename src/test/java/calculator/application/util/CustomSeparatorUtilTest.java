package calculator.application.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomSeparatorUtilTest {

    @Nested
    @DisplayName("[ #hasCustomSeparator 기능 테스트 ]")
    class hasCustomSeparator_테스트 {

        @ParameterizedTest(name = "({index}) : {arguments}")
        @ValueSource(strings = {
                "//,\\n1,2,3", "//;\\n1"
        })
        void 커스텀_구분자_입력_형식이_있을_경우_참(String text) {
            boolean result = CustomSeparatorUtil.hasCustomSeparator(text);

            assertThat(result).isTrue();
        }

        @ParameterizedTest(name = "({index}) : {arguments}")
        @ValueSource(strings = {
                "//1,2,3", "\\n1,2,3", "/,\\n1,2,3", "//,\n1,2,3"
        })
        void 커스텀_구분자_입력_형식이_없을_경우_거짓(String text) {
            boolean result = CustomSeparatorUtil.hasCustomSeparator(text);

            assertThat(result).isFalse();
        }

    }

    @Nested
    @DisplayName("[ #extractCustomSeparator 기능 테스트 ]")
    class extractCustomSeparator_테스트 {
        @ParameterizedTest(name = "({index}) : {0} ==> {1}")
        @MethodSource("argsForExtractSeparator")
        void 커스텀_구분자_추출(String text, String expect) {
            String result = CustomSeparatorUtil.extractCustomSeparator(text);

            assertThat(result).isEqualTo(expect);
        }

        static Stream<Arguments> argsForExtractSeparator(){
            return Stream.of(
                    Arguments.of("//,\\n1,2,3", ","),
                    Arguments.of("//;\\n1;2;3", ";"),
                    Arguments.of("//&\\n1&2&3", "&"),
                    Arguments.of("//\\\\n1&2&3", "\\")
            );
        }

    }

    @Nested
    @DisplayName("[ #extractExcludeCustomSeparator 기능 테스트 ]")
    class extractExcludeCustomSeparator_테스트 {
        @ParameterizedTest(name = "({index}) : {0} ==> {1}")
        @MethodSource("argsForExtractExclude")
        void 커스텀_구분자_입력_영역_제거(String text, String expect) {
            String result = CustomSeparatorUtil.extractExcludeCustomSeparator(text);

            assertThat(result).isEqualTo(expect);
        }

        static Stream<Arguments> argsForExtractExclude(){
            return Stream.of(
                    Arguments.of("//,\\n1,2,3", "1,2,3"),
                    Arguments.of("//,\\n1", "1"),
                    Arguments.of("//&\\n1&2&3", "1&2&3")
            );
        }

    }

}
