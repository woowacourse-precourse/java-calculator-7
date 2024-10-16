package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class ClassifierTest {

    @Test
    @DisplayName("기본 구분자(쉼표)로 구분된 문자열을 숫자 리스트로 변환")
    void parseNumbersWithDefaultCommaDelimiter() {
        // given
        String input = "1,2,3";

        // when
        Classifier classifier = new Classifier(input);
        List<Integer> numbers = classifier.getNumbers();

        // then
        assertEquals(Arrays.asList(1, 2, 3), numbers);
    }

    @Test
    @DisplayName("기본 구분자(콜론)로 구분된 문자열을 숫자 리스트로 변환")
    void parseNumbersWithDefaultColonDelimiter() {
        // given
        String input = "1:2:3";

        // when
        Classifier classifier = new Classifier(input);
        List<Integer> numbers = classifier.getNumbers();

        // then
        assertEquals(Arrays.asList(1, 2, 3), numbers);
    }

    @Test
    @DisplayName("커스텀 구분자를 포함한 문자열을 숫자 리스트로 변환")
    void parseNumbersWithCustomDelimiter() {
        // given
        String input = "//;\\n1;2;3";

        // when
        Classifier classifier = new Classifier(input);
        List<Integer> numbers = classifier.getNumbers();

        // then
        assertEquals(Arrays.asList(1, 2, 3), numbers);
    }

    @Test
    @DisplayName("혼합된 구분자(기본 + 커스텀)를 포함한 문자열을 숫자 리스트로 변환")
    void parseNumbersWithMixedDelimiters() {
        // given
        String input = "//;\\n1;2:3,4";

        // when
        Classifier classifier = new Classifier(input);
        List<Integer> numbers = classifier.getNumbers();

        // then
        assertEquals(Arrays.asList(1, 2, 3, 4), numbers);
    }

    @Test
    @DisplayName("빈 문자열 입력 처리")
    void throwExceptionForEmptyString() {
        // given
        String emptyInput = "";

        //when
        Classifier classifier = new Classifier(emptyInput);
        List<Integer> numbers = classifier.getNumbers();

        // then
        assertEquals(Arrays.asList(0), numbers);
    }

    @Test
    @DisplayName("단일 숫자 입력 처리")
    void parseSingleNumber() {
        // given
        String input = "1";

        // when
        Classifier classifier = new Classifier(input);
        List<Integer> numbers = classifier.getNumbers();

        // then
        assertEquals(Arrays.asList(1), numbers);
    }

    @Test
    @DisplayName("잘못된 형식의 입력 문자열에 대한 예외 처리")
    void throwExceptionForInvalidInput() {
        // given
        String invalidInput = "1,a,3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            new Classifier(invalidInput);
        });
    }

    @Test
    @DisplayName("잘못된 커스텀 구분자 형식에 대한 예외 처리")
    void throwExceptionForInvalidCustomDelimiter() {
        // given
        String invalidCustomDelimiterInput = "//\n1;2;3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            new Classifier(invalidCustomDelimiterInput);
        });
    }

}