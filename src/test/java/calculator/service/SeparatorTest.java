package calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeparatorTest {
    private final Separator separator = new Separator();

    @Test
    @DisplayName("기본 구분 테스트 - 컴마로만 구성된 올바른 입력을 분리하면 올바른 결과가 나온다.")
    void givenValidInputWithCommas_whenSeparate_thenReturnsCorrectResult() {
        String input = "1,2,3,4,5";
        int[] expected = new int[]{1, 2, 3, 4, 5};
        int[] result = separator.separate(input);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("기본 구분 테스트 - 콜론과 컴마가 혼합되어 구성된 올바른 입력을 분리하면 올바른 결과가 나온다.")
    void givenMixedValidInputWithCommasAndColons_whenSeparate_thenReturnsCorrectResult() {
        String input = "1:2,3:4,5,6,7";
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] result = separator.separate(input);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("기본 구분 테스트 - 음수가 존재하는 경우 올바른 분리가 이루어진다.")
    void givenInputWithNegativeNumbers_whenSeparate_thenReturnsCorrectResult() {
        String input = "1:-1,2:3:-4";
        int[] expected = new int[]{1, -1, 2, 3, -4};
        int[] result = separator.separate(input);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("기본 구분 테스트 - 숫자가 아닌 값이 존재하는 경우 예외가 발생한다.")
    void givenInputWithNonNumber_whenSeparate_thenThrowsException() {
        String input = "1,a,b,c,d";
        Assertions.assertThrows(IllegalArgumentException.class, () -> separator.separate(input));
    }

    @Test
    @DisplayName("기본 구분 테스트 - 올바르지 않은 형태의 입력은 예외가 발생한다.")
    void givenInput_whenSeparate_thenThrowsException() {
        String input1 = ",1,2,3,4:";
        Assertions.assertThrows(IllegalArgumentException.class, () -> separator.separate(input1));

        String input2 = ",,1,,,2,3,,4::5";
        Assertions.assertThrows(IllegalArgumentException.class, () -> separator.separate(input2));
    }

    @Test
    @DisplayName("커스텀 구분 테스트 - 올바른 1글자의 커스텀 구분자 입력시 올바른 분리가 이루어진다.")
    void givenCustomDelimiterOfACharacter_whenSeparate_thenReturnsCorrectResult() {
        String input = "//a\\n1a2a3a4";
        int[] expected = new int[]{1, 2, 3, 4};
        int[] result = separator.separate(input);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("커스텀 구분 테스트 - 올바른 1글자 초과의 커스텀 구분자 입력시 올바른 분리가 이루어진다.")
    void givenCustomDelimiterOfMultipleCharacters_whenSeparate_thenReturnsCorrectResult() {
        String input = "//abc\\n1abc2abc3abc4";
        int[] expected = new int[]{1, 2, 3, 4};
        int[] result = separator.separate(input);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("커스텀 구분 테스트 - 올바르지 않은 형식의 커스텀 구분자 입력시 예외 발생")
    void givenInvalidCustomSeparatorFormat_whenSeparate_thenThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> separator.separate("///a\n1a2a3"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> separator.separate("//a\\\n1a2a3"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> separator.separate("/a\\n1a2a3"));
    }
}