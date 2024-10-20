package calculator.domain.delimiter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.util.regex.Regex;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("구분자 집합 테스트")
class DelimitersTest {

    @Nested
    @DisplayName("구분자를 새로 추가할 때, ")
    class 구분자추가테스트 {

        @Test
        @DisplayName("유효한 구분자이면 성공한다")
        void 성공_구분자추가_유효한구분자() {
            // Given
            Delimiters delimiters = new Delimiters(List.of(new Delimiter(","), new Delimiter(":")));
            Delimiter newDelimiter = new Delimiter("a!");

            // When
            Delimiters totalDelimiters = delimiters.addDelimiter(newDelimiter);

            // Then
            assertThat(totalDelimiters.getDelimiters()).contains(newDelimiter);
        }

        @Test
        @DisplayName("이미 선언된 구분자이면 실패한다")
        void 실패_구분자추가_이미선언된구분자() {
            // Given
            Delimiters delimiters = new Delimiters(List.of(new Delimiter(","), new Delimiter(":")));
            Delimiter newDelimiter = new Delimiter(",");

            // When & Then
            assertThatThrownBy(() -> delimiters.addDelimiter(newDelimiter))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("구분자를 중복 선언하거나, 내부에 다른 구분자를 포함할 수 없습니다.");
        }

        @Test
        @DisplayName("이미 선언된 구분자가 새로운 구분자 안에 포함되면 실패한다")
        void 실패_구분자추가_구분자를포함하는구분자() {
            // Given
            Delimiters delimiters = new Delimiters(List.of(new Delimiter(","), new Delimiter(":")));
            Delimiter newDelimiter = new Delimiter(",!");

            // When & Then
            assertThatThrownBy(() -> delimiters.addDelimiter(newDelimiter))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("구분자를 중복 선언하거나, 내부에 다른 구분자를 포함할 수 없습니다.");
        }

    }

    @Nested
    @DisplayName("모든 구분자를 포함하는 정규식을 만들 때, ")
    class 구분자포함정규식테스트 {

        @Test
        @DisplayName("유효한 구분자이면 성공적으로 생성된다")
        void 성공_모든구분자포함정규식생성_유효한구분자() {
            // Given
            Delimiters delimiters = new Delimiters(List.of(new Delimiter(","), new Delimiter(":"), new Delimiter("!")));

            // When
            Regex regex = delimiters.makeDelimitersRegex();

            // Then
            Regex expectedRegex = new Regex("//(.+?)\\\\n|\\Q,\\E|\\Q:\\E|\\Q!\\E");
            assertThat(regex).isEqualTo(expectedRegex);
        }

    }

}
