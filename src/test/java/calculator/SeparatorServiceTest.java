package calculator;

import calculator.domain.Separator;
import calculator.service.SeparatorService;
import org.junit.jupiter.api.Test;

import static calculator.exception.Exception.INVALID_CUSTOM_SEPARATOR_FORMAT;
import static calculator.exception.Exception.INVALID_NUMBER_SEPARATOR;
import static calculator.exception.Exception.INVALID_SEPARATOR_LENGTH;
import static org.junit.jupiter.api.Assertions.*;

class SeparatorServiceTest {

    @Test
    void shouldExtractAndAddCustomSeparator() {
        // given
        String input = "//;\\n1;2;3";
        Separator separator = new Separator();
        SeparatorService separatorService = new SeparatorService(separator);

        // when
        String result = separatorService.extractAndAddSeparator(input);

        // then
        assertEquals("1;2;3", result); // 커스텀 구분자를 제외한 문자열 반환
        assertTrue(separator.getSeparators().contains(";")); // 커스텀 구분자가 추가되었는지 확인
    }

    @Test
    void shouldReturnInputWhenNoCustomSeparator() {
        // given
        String input = "1,2:3";
        Separator separator = new Separator();
        SeparatorService separatorService = new SeparatorService(separator);

        // when
        String result = separatorService.extractAndAddSeparator(input);

        // then
        assertEquals(input, result); // 구분자가 없으므로 입력값 그대로 반환
        assertEquals(2, separator.getSeparators().size()); // 기본 구분자만 있어야 함
    }

    @Test
    void shouldThrowExceptionWhenNoNewlineInCustomSeparatorFormat() {
        // given
        String input = "//;";
        Separator separator = new Separator();
        SeparatorService separatorService = new SeparatorService(separator);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> separatorService.extractAndAddSeparator(input));
        assertEquals(INVALID_CUSTOM_SEPARATOR_FORMAT.getMessage(), exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNumberAsCustomSeparator() {
        // given
        String input = "//1\\n1,2";
        Separator separator = new Separator();
        SeparatorService separatorService = new SeparatorService(separator);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> separatorService.extractAndAddSeparator(input));
        assertEquals(INVALID_NUMBER_SEPARATOR.getMessage() + "1", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForLongCustomSeparator() {
        // given
        String input = "//abc\\n1,2";
        Separator separator = new Separator();
        SeparatorService separatorService = new SeparatorService(separator);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> separatorService.extractAndAddSeparator(input));
        assertEquals(INVALID_SEPARATOR_LENGTH.getMessage() + "abc", exception.getMessage());
    }
}
