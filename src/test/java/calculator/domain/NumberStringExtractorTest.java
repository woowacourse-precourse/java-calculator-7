package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberStringExtractorTest {

    @DisplayName("구분자로 나뉜 숫자를 구할 수 있다.")
    @Test
    void getNumbersWithoutDelimiters() {
        //given
        String stringToAdd = "1,2,3";
        NumberStringExtractor numberStringExtractor = createNumberStringExtractor();
        //when
        String[] numbers = numberStringExtractor.getStrings(stringToAdd);
        //then
        assertThat(numbers).hasSize(3);
        assertThat(numbers).containsExactly("1", "2", "3");
    }

    @DisplayName("구분자로 나뉜 숫자를 구할 수 있다.")
    @Test
    void getNumbersWithoutDelimiters2() {
        //given
        String stringToAdd = "10:20,30:40";
        NumberStringExtractor numberStringExtractor = createNumberStringExtractor();
        //when
        String[] numbers = numberStringExtractor.getStrings(stringToAdd);
        //then
        assertThat(numbers).hasSize(4);
        assertThat(numbers).containsExactly("10", "20", "30", "40");
    }

    @DisplayName("구분자로 나뉜 숫자를 구할 수 있다.")
    @Test
    void getNumbersWithoutDelimiters3() {
        //given
        String stringToAdd = "//%\\n1%5,55:40%2,3%7:9";
        NumberStringExtractor numberStringExtractor = createNumberStringExtractor();
        //when
        String[] numbers = numberStringExtractor.getStrings(stringToAdd);
        //then
        assertThat(numbers).hasSize(8);
        assertThat(numbers).containsExactly("1", "5", "55", "40", "2", "3", "7", "9");
    }

    private NumberStringExtractor createNumberStringExtractor() {
        return new NumberStringExtractor(new CustomDelimiterExtractor());
    }
}