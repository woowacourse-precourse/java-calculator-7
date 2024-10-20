package parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class NumberExtractorTest {

    private final NumberExtractor numberExtractor = new NumberExtractor();

    @Test
    void 기본_구분자() {
        String input = "1,2:3";
        String delimiter = ",|:";
        List<Integer> numbers = numberExtractor.extractNumbers(input, delimiter);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    void 커스텀_구분자_세미콜론() {
        String input = "//;\n1;2;3";
        String delimiter = Pattern.quote(";");
        List<Integer> numbers = numberExtractor.extractNumbers(input, delimiter);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    void 커스텀_구분자_문자열() {
        String input = "//abcd\n1abcd2abcd3";
        String delimiter = Pattern.quote("abcd");
        List<Integer> numbers = numberExtractor.extractNumbers(input, delimiter);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    void 커스텀_구분자_공백() {
        String input = "// \n1 2 3";
        String delimiter = Pattern.quote(" ");
        List<Integer> numbers = numberExtractor.extractNumbers(input, delimiter);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    void 숫자_자리에_빈_입력() {
        String input = "1::2:3";
        String delimiter = ",|:";
        assertThatThrownBy(() -> numberExtractor.extractNumbers(input, delimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 누락되었습니다.");
    }
    
    @Test
    void 유효하지_않은_숫자_있으면_예외() {
        String input = "1,2,a";
        String delimiter = ",|:";
        assertThatThrownBy(() -> numberExtractor.extractNumbers(input, delimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 숫자 형식입니다.");
    }
}