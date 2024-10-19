package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberExtractorTest {

    private NumberExtractor numberExtractor;

    @BeforeEach
    void setUp() {
        numberExtractor = new NumberExtractor();
    }

    @Test
    @DisplayName("기본 구분자로 숫자를 추출할 경우 올바른 숫자 리스트를 반환한다.")
    void extractWithBasicDelimiter() {
        String input = "1,2,3,4";
        List<Integer> result = numberExtractor.extract(input, List.of(","));

        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자를 추출할 경우 올바른 숫자 리스트를 반환한다.")
    void extractWithCustomDelimiter() {
        String input = "//;\\n1;2;3";
        List<Integer> result = numberExtractor.extract(input, List.of(";"));

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자를 같이 사용할 경우 올바른 숫자 리스트를 반환한다.")
    void extractMixedDelimiters() {
        String input = "//;\\n1;2,3,4";
        List<Integer> result = numberExtractor.extract(input, List.of(";", ","));

        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("유효하지 않은 숫자 형식이 포함된 경우 예외가 발생한다.")
    void extractInvalidNumber() {
        String input = "//*\\n1*a*3";

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            numberExtractor.extract(input, List.of("*"));
        });

        assertThat(thrown.getMessage()).isEqualTo("유효한 숫자 형식이 아닙니다.");
    }

    @Test
    @DisplayName("빈 문자열을 포함한 숫자 문자열에서 유효한 숫자만 추출한다.")
    void extractNumbersWithEmptyStrings() {
        String input = "1,,2,3,,";
        List<Integer> result = numberExtractor.extract(input, List.of(","));

        assertThat(result).containsExactly(1, 2, 3);
    }

}
