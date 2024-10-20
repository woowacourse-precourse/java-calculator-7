package calculator;

import calculator.domain.Separator;
import calculator.service.SeparatorService;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeparatorTest {

    @Test
    void shouldReturnDefaultSeparators() {
        Separator separator = new Separator();
        List<String> separators = separator.getSeparators();

        // 기본 구분자가 2개(쉼표, 콜론)인지 확인
        assertEquals(2, separators.size(), "기본 구분자의 개수가 2개여야 합니다.");
        assertTrue(separators.contains(","), "기본 구분자에 쉼표(,)가 있어야 합니다.");
        assertTrue(separators.contains(":"), "기본 구분자에 콜론(:)이 있어야 합니다.");
    }

    @Test
    void shouldReturnSeparatorsIncludingCustomSeparator() {
        String input = "//;\\n1;2;3";
        Separator separator = new Separator();
        SeparatorService separatorService = new SeparatorService(separator);
        separatorService.processCustomSeparator(input);

        List<String> separators = separator.getSeparators();

        // 기본 구분자와 커스텀 구분자까지 총 3개가 있어야 함
        assertEquals(3, separators.size(), "기본 구분자 2개와 커스텀 구분자가 추가되어 총 3개여야 합니다.");
        assertTrue(separators.contains(","), "기본 구분자 쉼표(,)가 구분자 리스트에 있어야 합니다.");
        assertTrue(separators.contains(":"), "기본 구분자 콜론(:)이 구분자 리스트에 있어야 합니다.");
        assertTrue(separators.contains(";"), "커스텀 구분자 세미콜론(;)이 구분자 리스트에 있어야 합니다.");
    }

    @Test
    void shouldNotAddCustomSeparatorWhenNotPresentInInput() {
        String input = "1,2:3";
        Separator separator = new Separator();
        SeparatorService separatorService = new SeparatorService(separator);
        separatorService.processCustomSeparator(input);

        // 커스텀 구분자가 없는 경우 기본 구분자만 있어야 함
        List<String> separators = separator.getSeparators();
        assertEquals(2, separators.size(), "커스텀 구분자가 없으므로 기본 구분자 2개만 있어야 합니다.");
        assertTrue(separators.contains(","), "기본 구분자 쉼표(,)가 구분자 리스트에 있어야 합니다.");
        assertTrue(separators.contains(":"), "기본 구분자 콜론(:)이 구분자 리스트에 있어야 합니다.");
        assertFalse(separators.contains(";"), "커스텀 구분자 세미콜론(;)은 추가되지 않아야 합니다.");
    }

    @Test
    void shouldThrowExceptionWhenCustomSeparatorHasNoNewline() {
        Separator separator = new Separator();
        SeparatorService separatorService = new SeparatorService(separator);

        // 커스텀 구분자가 있으나 \n이 없는 경우 예외가 발생해야 함
        assertThrows(IllegalArgumentException.class, () ->
                        separatorService.processCustomSeparator("//;"),
                "커스텀 구분자 뒤에 \\n이 없을 때 IllegalArgumentException이 발생해야 합니다.");
    }
}
