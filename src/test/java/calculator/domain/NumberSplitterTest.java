package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberSplitterTest {

    @Test
    @DisplayName("숫자 부분 split() 테스트")
    void testSplit() {
        // given
        String numberPart = "1,2:3,4";
        Set<Character> delimiters = Set.of(',', ':');
        List<String> expected = List.of("1", "2", "3", "4");
        NumberSplitter numberSplitter = new NumberSplitter();

        // when
        List<String> actual = numberSplitter.split(numberPart, delimiters);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("' '가 구분자로 들어온 경우 숫자 부분 split() 테스트")
    void testSplitWithWhiteSpaceDelimiter() {
        // given
        String numberPart = "1 2 3 4";
        Set<Character> delimiters = Set.of(',', ':', ' ');
        List<String> expected = List.of("1", "2", "3", "4");
        NumberSplitter numberSplitter = new NumberSplitter();

        // when
        List<String> actual = numberSplitter.split(numberPart, delimiters);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("구분자가 연속으로 들어오는 경우 숫자 부분 split() 테스트")
    void testSplitWithConsecutiveDelimiter() {
        // given
        String numberPart = "1,2,3::4";
        Set<Character> delimiters = Set.of(',', ':', ' ');
        List<String> expected = List.of("1", "2", "3", "", "4");
        NumberSplitter numberSplitter = new NumberSplitter();

        // when
        List<String> actual = numberSplitter.split(numberPart, delimiters);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}