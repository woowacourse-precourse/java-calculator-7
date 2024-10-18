package calculator.unit.extractor;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.extractor.DefaultTokenExtractor;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DefaultTokenExtractorTest {

    private final DefaultTokenExtractor defaultTokenExtractorStrategy = new DefaultTokenExtractor();

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,", "1,2,3"})
        @DisplayName("','를 포함한 문자열 입력 시 성공적으로 토큰을 추출한다")
        void extractTokens_Success(String input) {
            List<String> extract = defaultTokenExtractorStrategy.extract(input);

            assertThat(extract)
                    .isNotEmpty()
                    .doesNotContainNull()
                    .isEqualTo(List.of("1", "2", "3"));
        }
    }

//    @Nested
//    @DisplayName("실패 케이스")
//    class FailureCases {
//
//        @ParameterizedTest
//        @ValueSource(strings = {"abc", "123", "a b c"})
//        @DisplayName("','가 없는 문자열 입력 시 원본 문자열만 포함하는 리스트를 반환한다")
//        void extractTokens_NoCommaInput(String input) {
//            List<String> extract = defaultTokenExtractorStrategy.extract(input);
//
//
//        }
//    }
}