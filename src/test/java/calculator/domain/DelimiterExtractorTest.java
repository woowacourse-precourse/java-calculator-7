package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.service.DelimiterExtractor;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DelimiterExtractorTest {

    private DelimiterExtractor delimiterExtractor;

    @BeforeEach
    void setUp() {
        delimiterExtractor = new DelimiterExtractor();
    }

    @Nested
    class 정상_케이스 {

        @Test
        void 입력이_없는_경우에도_예외가_발생하지_않는다() {
            String input = "";
            List<String> result = delimiterExtractor.extract(input);
            assertThat(result).isEmpty();
        }

        @Test
        void 커스텀_구분자가_없으면_빈_리스트를_반환한다() {
            String input = "1,2,3";
            List<String> result = delimiterExtractor.extract(input);
            assertThat(result).isEmpty();
        }

        @ParameterizedTest
        @MethodSource("커스텀_구분자_제공")
        void 다양한_커스텀_구분자를_추출한다(String input, List<String> expected) {
            List<String> result = delimiterExtractor.extract(input);
            assertThat(result).containsExactlyElementsOf(expected);
        }

        static Stream<Arguments> 커스텀_구분자_제공() {
            return Stream.of(
                    Arguments.of("//;\n1;2;3", List.of(";")),
                    Arguments.of("//;\n//@\n//?\n1;2@3?4", List.of(";", "@", "?")),
                    Arguments.of("// \n1;2@3?4", List.of(" ")),
                    Arguments.of("//      \n1;2@3?4", List.of("      ")),
                    Arguments.of("//[***]\n//[%%%]\n1***2%%%3", List.of("[***]", "[%%%]")),
                    Arguments.of("//길이가매우긴구분자\n//길이가매우아주엄청나게긴커스텀구분자\n1***2%%%3",
                            List.of("길이가매우긴구분자", "길이가매우아주엄청나게긴커스텀구분자")
                    )
            );
        }

        @Test
        void 연속된_커스텀_구분자_선언을_처리한다() {
            String input = "//;\n//,\n//@\n1;2,3@4";
            List<String> result = delimiterExtractor.extract(input);
            assertThat(result).containsExactly(";", ",", "@");
        }

        @Test
        void 특수_문자를_포함한_커스텀_구분자를_처리한다() {
            String input = "//!\n//$\n//^\n1!2$3^4";
            List<String> result = delimiterExtractor.extract(input);
            assertThat(result).containsExactly("!", "$", "^");
        }


        @Test
        void 숫자로_이루어진_커스텀_구분자를_처리한다() {
            String input = "//1\n//22\n//333\n11223334445";
            List<String> result = delimiterExtractor.extract(input);
            assertThat(result).containsExactly("1", "22", "333");
        }

        @Test
        void 숫자와_문자가_혼합된_커스텀_구분자를_처리한다() {
            String input = "//1a\n//2b2\n//c3c\n1a2b23c3c4";
            List<String> result = delimiterExtractor.extract(input);
            assertThat(result).containsExactly("1a", "2b2", "c3c");
        }
    }

    @Nested
    class 실패_케이스 {

        @Test
        void 커스텀_구분자가_문자열_시작에_없으면_예외를_발생시킨다() {
            String input = "1,2,3//;\n4;5";
            assertThatThrownBy(() -> delimiterExtractor.extract(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("커스텀 구분자는 문자열의 시작 부분에만 위치해야 합니다.");
        }

        @Test
        void 커스텀_구분자_형식이_비어있다면_예외를_발생시킨다() {
            String input = "//\n1,2,3";
            assertThatThrownBy(() -> delimiterExtractor.extract(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("커스텀 구분자 형식이 올바르지 않습니다.");
        }

        @Test
        void 여러_줄의_커스텀_구분자_후_올바르지_않은_형식이_오면_예외를_발생시킨다() {
            String input = "//;\n//@\n//\n1;2@3";
            assertThatThrownBy(() -> delimiterExtractor.extract(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("커스텀 구분자 형식이 올바르지 않습니다.");
        }
    }
}