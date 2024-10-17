package calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExtractorTest {

    @DisplayName("커스텀 구분자를 사용할 때 숫자 부분만 추출 할 수 있다.")
    @Test
    void extractNumberPartByUsingCustomDelimiter() {
        //given
        Extractor extractor = new Extractor();
        //when
        String numberPart = extractor.extractNumberPart("//;\\n1;2;3", true);
        //then
        assertThat(numberPart).isEqualTo("1;2;3");
    }

    @DisplayName("커스텀 구분자를 입력하지 않을 때 숫자 부분만 추출 할 수 있다.")
    @Test
    void extractNumberPartByDefaultDelimiter() {
        //given
        Extractor extractor = new Extractor();
        //when
        String numberPart = extractor.extractNumberPart("1,2:3", false);
        //then
        assertThat(numberPart).isEqualTo("1,2:3");
    }

    @DisplayName("입력이 빈 값 일 때 0을 가지는 리스트를 반환한다.")
    @Test
    void extractNumbersWhenInputIsEmpty() {
        //given
        Extractor extractor = new Extractor();
        //when
        List<Integer> extractedNumbers = extractor.extractNumbers("", ";");
        //then
        assertThat(extractedNumbers).hasSize(1)
            .containsExactly(0);
    }

    @DisplayName("숫자 부분과 구분자를 통해 숫자목록으로 반환 한다.")
    @CsvSource(value = {"'1;2;3', ';'", "'1,2:3', ',|:'"})
    @ParameterizedTest
    void extractNumbers(String input, String delimiter) {
        //given
        Extractor extractor = new Extractor();
        //when
        List<Integer> extractedNumbers = extractor.extractNumbers(input, delimiter);
        //then
        assertThat(extractedNumbers).hasSize(3)
            .containsExactly(1, 2, 3);
    }

    @DisplayName("입력에서 구분자를 사용하지 않을 때 숫자 목록으로 반환한다.")
    @Test
    void extractNumbersWhenInputHasNotDelimiter() {
        //given
        Extractor extractor = new Extractor();
        //when
        List<Integer> extractedNumbers = extractor.extractNumbers("1", ",|:");
        //then
        assertThat(extractedNumbers).hasSize(1)
            .containsExactly(1);
    }

    @DisplayName("사용자 입력을 숫자로 변환할 때 양수가 아닌 값이 포함되어 있으면 IllegalArgumentException을 던진다.")
    @Test
    void extractNumbersWhenInputIsNotPositiveNumberThrowIllgalArgumnetException() {
        //given
        Extractor extractor = new Extractor();
        //when
        //then
        assertThatThrownBy(() -> extractor.extractNumbers("1,-2:3", ",|:"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("양수와 구분자만 입력 가능합니다.");
    }

}