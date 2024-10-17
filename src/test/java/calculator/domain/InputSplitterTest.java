package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputSplitterTest {
    @ParameterizedTest
    @DisplayName("쉼표(,), 콜론(:) 구분자로 분할이 되는지 테스트")
    @ValueSource(strings = {"4,5,6", "4:5:6", "4,5:6", "4:5,6"})
    void splitByCommaOrColon(String input) {
        //given
        InputSplitter inputSplitter = new InputSplitter();
        String[] actualStrings = inputSplitter.splitByDelimiter(input);

        //when
        String[] expectedStrings = {"4", "5", "6"};

        //then
        assertArrayEquals(expectedStrings, actualStrings);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자로 분할이 되는지 테스트")
    @ValueSource(strings = {
            "//;\\n1;2;3", "//*\\n1*2*3", "//+\\n1+2+3", "//$\\n1$2$3",
            "//@\\n1@2@3", "//?\\n1?2?3", "//^\\n1^2^3", "//.\\n1.2.3"
    })
    void splitByCustomDelimiter(String input) {
        //given
        InputSplitter inputSplitter = new InputSplitter();
        String[] actualStrings = inputSplitter.splitByDelimiter(input);

        //when
        String[] expectedStrings = {"1", "2", "3"};

        //then
        assertArrayEquals(expectedStrings, actualStrings);
    }

    @ParameterizedTest
    @DisplayName("쉼표(,) 또는 콜론(:) 외의 다른 구분자를 사용할 경우, 숫자 바깥에 구분자가 존재하는 경우 예외 발생")
    @ValueSource(strings = {"7.8.9", "7/8/9", "7,8,9,"})
    void validateCommaAndColonDelimiter(String input) {
        //given
        InputSplitter inputSplitter = new InputSplitter();

        //when
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> inputSplitter.splitByDelimiter(input));

        //then
        assertEquals("쉼표(,) 또는 콜론(:) 외의 다른 구분자는 사용할 수 없으며, 숫자 사이에만 올 수 있습니다.", exception.getMessage());
    }
}