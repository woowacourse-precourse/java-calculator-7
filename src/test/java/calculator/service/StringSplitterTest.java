package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.delimeter.Delimiter;
import calculator.domain.delimeter.Delimiters;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringSplitterTest {

    private StringSplitter stringSplitter = new StringSplitter();
    private static Delimiters delimiters = Delimiters.createWithCustom(
            List.of(Delimiter.from(","), Delimiter.from(":"), Delimiter.from(";"))
    );

    @Nested
    class 정상_케이스 {

        @Test
        void 단일_구분자로_문자열을_분리한다() {
            // Given
            String input = "1,2,3";

            // When
            List<String> result = stringSplitter.split(input, delimiters);

            // Then
            assertThat(result).containsExactly("1", "2", "3");
        }

        @Test
        void 여러_구분자로_문자열을_분리한다() {
            // Given
            String input = "1,2:3;4";

            // When
            List<String> result = stringSplitter.split(input, delimiters);

            // Then
            assertThat(result).containsExactly("1", "2", "3", "4");
        }

        @Test
        void 구분자가_연속으로_있는_경우_빈_문자열을_포함한다() {
            // Given
            String input = "1,,2:3;;4";

            // When
            List<String> result = stringSplitter.split(input, delimiters);

            // Then
            assertThat(result).containsExactly("1", "", "2", "3", "", "4");
        }

        @Test
        void 입력_문자열이_비어있으면_빈_리스트를_반환한다() {
            // Given
            String input = "";

            // When
            List<String> result = stringSplitter.split(input, delimiters);

            // Then
            assertThat(result).isEmpty();
        }

        @Test
        void 입력_문자열이_null이면_빈_리스트를_반환한다() {
            // Given
            String input = null;

            // When
            List<String> result = stringSplitter.split(input, delimiters);

            // Then
            assertThat(result).isEmpty();
        }

        @Test
        void 구분자가_없는_문자열은_그대로_반환한다() {
            // Given
            String input = "123";

            // When
            List<String> result = stringSplitter.split(input, delimiters);

            // Then
            assertThat(result).containsExactly("123");
        }
    }
}