package calculator.unit.extractor;


import static calculator.util.Token.NEW_LINE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import calculator.extractor.CustomTokenExtractor;
import calculator.util.Token;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CustomTokenExtractorTest {

    private final CustomTokenExtractor extractor = new CustomTokenExtractor();


    @Nested
    @DisplayName("validateCustomTokenFormat 메서드")
    class ValidateCustomTokenFormatTest {

        @Nested
        @DisplayName("성공 케이스")
        class Success {

            @ParameterizedTest
            @ValueSource(strings = {"//;\\n1;2;3", "//,\\n1,2,3"})
            @DisplayName("유효한 커스텀 토큰 형식")
            void validCustomTokenFormat(String input) {
                assertThatNoException().isThrownBy(() -> extractor.isCustomTokenFormat(input));
            }

        }

//        @Nested
//        @DisplayName("실패 케이스")
//        class Fail {
//            @Test
//            @DisplayName("잘못된 prefix")
//            void invalidPrefix() {
//                assertThatThrownBy(() -> extractor.isCustomTokenFormat("/;\\n1;2;3"))
//                        .isInstanceOf(IllegalArgumentException.class)
//                        .hasMessage("커스텀 토큰 형식이 올바르지 않습니다.");
//            }
//
//            @Test
//            @DisplayName("토큰 없음")
//            void missingToken() {
//                assertThatThrownBy(() -> extractor.isCustomTokenFormat("//;1;2;3"))
//                        .isInstanceOf(IllegalArgumentException.class)
//                        .hasMessage("커스텀 토큰 형식이 올바르지 않습니다.");
//            }
//        }
    }

    @Nested
    @DisplayName("extractToken 메서드")
    class ExtractTokenTest {

        @ParameterizedTest
        @ValueSource(strings = {"//;\\n1;2;3", "//,\\n1,2,3", "//*\\n1*2*3"})
        @DisplayName("토큰 추출")
        void extractToken(String input) {
            List<String> token = extractor.extract(input);
            assertThat(token).isNotEmpty();
        }
    }

    @Nested
    @DisplayName("extractNumberString 메서드")
    class ExtractNumberStringTest {

        @ParameterizedTest
        @ValueSource(strings = {"//;\\n1;2;3", "//,\\n1,2,3", "//*\\n1*2*3"})
        @DisplayName("숫자 문자열 추출")
        void extractNumberString(String input) {
            String numberString = extractor.extractNumberString(input);
            assertThat(numberString).doesNotContain(Token.CUSTOM_TOKEN_PREFIX, NEW_LINE);
        }
    }

    @Nested
    @DisplayName("splitNumbers 메서드")
    class SplitNumbersTest {

        @Test
        @DisplayName("숫자 분리")
        void splitNumbers() {
            List<String> numbers = extractor.splitNumbers("1;2;3", ";");
            assertThat(numbers).containsExactly("1", "2", "3");
        }
    }

    @Nested
    @DisplayName("extract 메서드")
    class ExtractTest {

        @ParameterizedTest
        @ValueSource(strings = {"//;\\n1;2;3", "//,\\n1,2,3", "//*\\n1*2*3"})
        @DisplayName("전체 추출 과정")
        void extract(String input) {
            List<String> result = extractor.extract(input);
            assertThat(result).hasSize(3);
        }

//        @Test
//        @DisplayName("잘못된 입력 처리")
//        void handleInvalidInput() {
//            assertThatThrownBy(() -> extractor.extract("1,2,3"))
//                    .isInstanceOf(IllegalArgumentException.class)
//                    .hasMessage("커스텀 토큰 형식이 올바르지 않습니다.");
//        }
    }

}
