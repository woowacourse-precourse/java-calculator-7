package calculator.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ExtractorTest {

    Extractor extractor = new Extractor();

    @Test
    @DisplayName("커스텀 구분자 문자열로부터 숫자목록을 추출한다")
    void extractNumbersByCustomDelimiters() {
        //given
        String input = "//;\\n4;5;62";

        //when
        List<Integer> numbers = extractor.extractNumbers(input);

        //then
        assertThat(numbers).hasSize(3)
                .containsExactlyInAnyOrder(4, 5, 62);
    }

    @Test
    @DisplayName("길이가 2이상인 커스텀 구분자 문자열로부터 숫자목록을 추출한다")
    void extractNumbersByMultiChar() {
        //given
        String input = "//;asda\\n4;asda5;asda62";

        //when
        List<Integer> numbers = extractor.extractNumbers(input);

        //then
        assertThat(numbers).hasSize(3)
                .containsExactlyInAnyOrder(4, 5, 62);
    }

    @Test
    @DisplayName("기본 구분자 문자열로부터 숫자목록을 추출한다 CASE 1")
    void extractNumberByDefaultDelimiters1() {
        //given
        String input = "4:5,6";
        String[] defaultDelimiters = {":", ","};

        //when
        List<Integer> numbers = extractor.extractNumbers(input, defaultDelimiters);

        //then
        assertThat(numbers).hasSize(3)
                .containsExactlyInAnyOrder(4, 5, 6);
    }

    @Test
    @DisplayName("기본 구분자 문자열로부터 숫자목록을 추출한다 CASE 2")
    void extractNumberByDefaultDelimiters2() {
        //given
        String input = "4:5:6";
        String[] defaultDelimiters = {":", ","};

        //when
        List<Integer> numbers = extractor.extractNumbers(input, defaultDelimiters);

        //then
        assertThat(numbers).hasSize(3)
                .containsExactlyInAnyOrder(4, 5, 6);
    }

    @Test
    @DisplayName("기본 구분자 문자열로부터 숫자목록을 추출한다 CASE 3")
    void extractNumberByDefaultDelimiters3() {
        //given
        String input = "4,5,6";
        String[] defaultDelimiters = {":", ","};

        //when
        List<Integer> numbers = extractor.extractNumbers(input, defaultDelimiters);

        //then
        assertThat(numbers).hasSize(3)
                .containsExactlyInAnyOrder(4, 5, 6);
    }

    @Test
    @DisplayName("기본 구분자 문자열로부터 숫자목록을 추출한다 CASE 4")
    void extractNumberByDefaultDelimiters4() {
        //given
        String input = "4123,55:67";
        String[] defaultDelimiters = {":", ","};

        //when
        List<Integer> numbers = extractor.extractNumbers(input, defaultDelimiters);

        //then
        assertThat(numbers).hasSize(3)
                .containsExactlyInAnyOrder(4123, 55, 67);
    }
}