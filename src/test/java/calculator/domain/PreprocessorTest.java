package calculator.domain;

import calculator.domain.model.PreprocessedInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PreprocessorTest {

    @Test
    @DisplayName("커스텀 구분자가 있을 경우 올바르게 처리")
    void preprocess() {
        // given
        String expectUnparsedNumber = "1,2:3#4";
        String hashInput = "//#\n1,2:3#4";
        String spaceInput = "// \n1,2:3#4";

        Preprocessor hashPreprocessor = new Preprocessor(hashInput);
        Preprocessor spacePreprocessor = new Preprocessor(spaceInput);

        // when
        PreprocessedInput hashResult = hashPreprocessor.preprocess();
        PreprocessedInput spaceResult = spacePreprocessor.preprocess();

        // then
        assertEquals(expectUnparsedNumber, hashResult.unparsedNumber());
        assertTrue(hashResult.delimiters().containsAll(List.of(',', ';', '#')));
        assertEquals(expectUnparsedNumber, spaceResult.unparsedNumber());
        assertTrue(spaceResult.delimiters().containsAll(List.of(',', ';', ' ')));
    }

    @Test
    @DisplayName("커스텀 구분자에 띄워쓰기 있는 경우 올바르게 처리")
    void preprocessWithSpace() {
        // given
        String input = "// \n1#2#3";
        Preprocessor preprocessor = new Preprocessor(input);

        // when
        PreprocessedInput result = preprocessor.preprocess();

        // then
        assertEquals("1#2#3", result.unparsedNumber());  // 커스텀 구분자를 제외한 나머지 문자열 확인
        assertTrue(result.delimiters().containsAll(List.of(',', ';', ' ')));  // 커스텀 구분자가 추가됐는지 확인
    }

    @Test
    @DisplayName("빈 문자열 또는 null 입력 시 기본 구분자만 반환")
    void preprocessShouldReturnDefaultDelimitersForEmptyInput() {
        // given
        String emptyInput = "";
        Preprocessor preprocessor = new Preprocessor(emptyInput);

        // when
        PreprocessedInput result = preprocessor.preprocess();

        // then
        assertEquals(emptyInput, result.unparsedNumber());
        assertTrue(result.delimiters().containsAll(List.of(',', ';')));
    }

    @Test
    @DisplayName("구분자 정의 후 올바르게 끝나지 않는 경우 예외 발생")
    void preprocessShouldThrowExceptionForInvalidInput() {
        // given
        String invalidInput = "//#1#2#3";  // \n 누락
        Preprocessor preprocessor = new Preprocessor(invalidInput);

        // when & then
        assertThrows(IllegalArgumentException.class, preprocessor::preprocess);
    }
}
