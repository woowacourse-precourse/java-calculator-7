package calculator.domain.delimiter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구분자 추출 테스트")
class DelimiterExtractorTest {

    @Test
    @DisplayName("한개의 커스텀 구분자를 가진 입력이 주어질 때, 커스텀 구분자를 추출한다")
    void 성공_커스텀구분자추출_한개의커스텀구분자() {
        // Given
        String input = "//;\\n1";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Delimiters defaultDelimiters = new Delimiters(Collections.emptyList());

        // When
        Delimiters delimiters = delimiterExtractor.extractDelimitersFrom(input, defaultDelimiters);

        // Then
        assertThat(delimiters).isEqualTo(new Delimiters(List.of(new Delimiter(";"))));
    }

    @Test
    @DisplayName("여러 개의 커스텀 구분자를 가진 입력이 주어질 때, 커스텀 구분자를 추출한다")
    void 성공_커스텀구분자추출_여러개의커스텀구분자() {
        // Given
        String input = "//*\\n//%\\n1*2%3//&\\n4&5";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Delimiters defaultDelimiters = new Delimiters(Collections.emptyList());

        // When
        Delimiters delimiters = delimiterExtractor.extractDelimitersFrom(input, defaultDelimiters);

        // Then
        assertThat(delimiters).isEqualTo(
                new Delimiters(List.of(new Delimiter("*"), new Delimiter("%"), new Delimiter("&"))));
    }

    @Test
    @DisplayName("여러 글자로 이루어진 커스텀 구분자를 가진 입력이 주어질 때, 커스텀 구분자를 추출한다")
    void 성공_커스텀구분자추출_여러글자로이루어진커스텀구분자() {
        // Given
        String input = "//!!\\n1!!2";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Delimiters defaultDelimiters = new Delimiters(Collections.emptyList());

        // When
        Delimiters delimiters = delimiterExtractor.extractDelimitersFrom(input, defaultDelimiters);

        // Then
        assertThat(delimiters).isEqualTo(new Delimiters(List.of(new Delimiter("!!"))));
    }

    @Test
    @DisplayName("숫자와 글자가 혼합된 커스텀 구분자를 가진 입력이 주어질 때, 커스텀 구분자를 추출한다")
    void 성공_커스텀구분자추출_숫자와글자가혼합된커스텀구분자() {
        // Given
        String input = "//!5!\\n1!5!2";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Delimiters defaultDelimiters = new Delimiters(Collections.emptyList());

        // When
        Delimiters delimiters = delimiterExtractor.extractDelimitersFrom(input, defaultDelimiters);

        // Then
        assertThat(delimiters).isEqualTo(new Delimiters(List.of(new Delimiter("!5!"))));
    }

    @Test
    @DisplayName("메타 문자가 포함된 커스텀 구분자를 가진 입력이 주어질 때, 커스텀 구분자를 추출한다")
    void 성공_커스텀구분자추출_메타문자가포함된커스텀구분자() {
        // Given
        String input = "//(\\n1(2";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Delimiters defaultDelimiters = new Delimiters(Collections.emptyList());

        // When
        Delimiters delimiters = delimiterExtractor.extractDelimitersFrom(input, defaultDelimiters);

        // Then
        assertThat(delimiters).isEqualTo(new Delimiters(List.of(new Delimiter("("))));
    }

    @Test
    @DisplayName("숫자로만 이루어진 커스텀 구분자를 가진 입력이 주어질 때, 커스텀 구분자 추출 시 예외가 발생한다")
    void 실패_커스텀구분자추출_숫자로만이루어진커스텀구분자() {
        // Given
        String input = "//5\\n15253";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Delimiters defaultDelimiters = new Delimiters(Collections.emptyList());

        // When & Then
        assertThatThrownBy(() -> delimiterExtractor.extractDelimitersFrom(input, defaultDelimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자는 숫자로만 이루어질 수 없습니다. 문자를 포함하세요.");
    }

}
