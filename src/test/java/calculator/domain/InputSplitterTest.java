package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InputSplitterTest {
    @Test
    @DisplayName("쉼표(,), 콜론(:) 구분자로 분할이 되는지 테스트")
    void splitByCommaOrColon() {
        //given
        String input = "4,5:6";
        InputSplitter inputSplitter = new InputSplitter();
        String[] actualStrings = inputSplitter.splitByDelimeter(input);

        //when
        String[] expectedStrings = {"4", "5", "6"};

        //then
        assertArrayEquals(expectedStrings, actualStrings);
    }

    @Test
    @DisplayName("커스텀 구분자로 분할이 되는지 테스트")
    void splitByCustomDelimiter() {
        //given
        String input = "//;\n1;2;3";
        InputSplitter inputSplitter = new InputSplitter();
        String[] actualStrings = inputSplitter.splitByDelimeter(input);

        //when
        String[] expectedStrings = {"1", "2", "3"};

        //then
        assertArrayEquals(expectedStrings, actualStrings);
    }

}