package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SeparatorExtractorTest {

    @ParameterizedTest
    @ValueSource(chars = {'a', 'z' ,'!', ';', '/', '?', ','})
    void 문자로_된_커스텀_구분자를_추출할_수_있다(char separator) {
        String arg = "//" + separator + "\\n";
        SeparatorExtractor extractor = new SeparatorExtractor();
        SeparatorExtractor.ExtractResult result = extractor.extract(arg);

        assertThat(result.getExpression()).isBlank();
        assertThat(result.getSeparator().isPresent()).isTrue();
        assertThat(result.getSeparator().get()).isEqualTo(separator);
    }

    @ParameterizedTest
    @ValueSource(chars = {'\b', '\n' ,' ', '\t'})
    void 공백으로_된_커스텀_구분자를_추출할_수_있다(char separator) {
        String arg = "//" + separator + "\\n";
        SeparatorExtractor extractor = new SeparatorExtractor();
        SeparatorExtractor.ExtractResult result = extractor.extract(arg);

        assertThat(result.getExpression()).isBlank();
        assertThat(result.getSeparator().isPresent()).isTrue();
        assertThat(result.getSeparator().get()).isEqualTo(separator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//", "//123", "//\\n", "//\\n123", "//?", "//?123", "//?{\\n"})
    void 잘못된_커스텀_구분자_형식이_오면_예외를_던진다(String arg) {
        SeparatorExtractor extractor = new SeparatorExtractor();

        assertThatThrownBy(() -> extractor.extract(arg))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 커스텀_구분자가_숫자면_예외를_던진다(int n) {
        String arg = "//" + n + "\n1,2:3";
        SeparatorExtractor extractor = new SeparatorExtractor();

        assertThatThrownBy(() -> extractor.extract(arg))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
