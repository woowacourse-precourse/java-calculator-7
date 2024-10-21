package calculator.calculator.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberExtractorTest {

    @DisplayName("기본 구분자(, and :)로 공백 문자열에서 숫자를 추출하면 0을 반환한다.")
    @Test
    void extractNumbersWithDefaultSeparatorInputEmpty() {
        //given
        NumberExtractor numberExtractor = new NumberExtractor();
        String source = "";

        //when
        int[] numbers = numberExtractor.extractNumbersWithDefaultSeparator(source);

        //then
        Assertions.assertThat(numbers).hasSize(1);
        Assertions.assertThat(numbers[0]).isEqualTo(0);
    }

    @DisplayName("기본 구분자(, and :)로 문자열에서 숫자를 추출할 수 있다.")
    @Test
    void extractNumbersWithDefaultSeparatorInputNonEmpty() {
        //given
        NumberExtractor numberExtractor = new NumberExtractor();
        String source = "1,2";

        //when
        int[] numbers = numberExtractor.extractNumbersWithDefaultSeparator(source);

        //then
        Assertions.assertThat(numbers).hasSize(2);
        Assertions.assertThat(numbers[0]).isEqualTo(1);
        Assertions.assertThat(numbers[1]).isEqualTo(2);
    }

    @DisplayName("기본 구분자(, and :) 모두 있는 문자열에서 숫자를 추출할 수 있다.")
    @Test
    void extractNumbersWithDefaultSeparatorAllUser() {
        //given
        NumberExtractor numberExtractor = new NumberExtractor();
        String source = "1,2:3";

        //when
        int[] numbers = numberExtractor.extractNumbersWithDefaultSeparator(source);

        //then
        Assertions.assertThat(numbers).hasSize(3);
        Assertions.assertThat(numbers[0]).isEqualTo(1);
        Assertions.assertThat(numbers[1]).isEqualTo(2);
        Assertions.assertThat(numbers[2]).isEqualTo(3);
    }

    @DisplayName("커스텀 구분자로 문자열에서 숫자를 추출할 수 있다.")
    @Test
    void extractNumbersWithCustomSeparator() {
        //given
        NumberExtractor numberExtractor = new NumberExtractor();
        String source = "//;\n1;2;3";

        //when
        int[] numbers = numberExtractor.extractNumbersWithCustomSeparator(source);

        //then
        Assertions.assertThat(numbers).hasSize(3);
        Assertions.assertThat(numbers[0]).isEqualTo(1);
        Assertions.assertThat(numbers[1]).isEqualTo(2);
        Assertions.assertThat(numbers[2]).isEqualTo(3);
    }

    @DisplayName("커스텀 구분자들로 문자열에서 숫자를 추출할 수 있다.")
    @Test
    void extractNumbersWithCustomSeparators() {
        //given
        NumberExtractor numberExtractor = new NumberExtractor();
        String source = "//,;\n1,2;3";

        //when
        int[] numbers = numberExtractor.extractNumbersWithCustomSeparator(source);

        //then
        Assertions.assertThat(numbers).hasSize(3);
        Assertions.assertThat(numbers[0]).isEqualTo(1);
        Assertions.assertThat(numbers[1]).isEqualTo(2);
        Assertions.assertThat(numbers[2]).isEqualTo(3);
    }
}