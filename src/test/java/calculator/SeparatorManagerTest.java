package calculator;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SeparatorManagerTest {

    @Test
    void shouldReturnDefaultSeparators() {
        SeparatorManager manager = new SeparatorManager();
        List<String> separators = manager.getSeparators();

        // 기본 구분자가 2개(쉼표, 콜론)인지 확인
        assertEquals(2, separators.size(), "기본 구분자의 개수가 2개여야 합니다.");
        assertTrue(separators.contains(","), "기본 구분자에 쉼표(,)가 있어야 합니다.");
        assertTrue(separators.contains(":"), "기본 구분자에 콜론(:)이 있어야 합니다.");
    }

    @Test
    void shouldAddCustomSeparatorFromInput() {
        SeparatorManager manager = new SeparatorManager();
        manager.addCustomSeparator("//;\n1;2;3");

        // 커스텀 구분자가 제대로 추가되었는지 확인
        List<String> separators = manager.getSeparators();
        assertTrue(separators.contains(";"), "커스텀 구분자 세미콜론(;)이 구분자 리스트에 있어야 합니다.");
    }

    @Test
    void shouldReturnSeparatorsIncludingCustomSeparator() {
        SeparatorManager manager = new SeparatorManager();
        manager.addCustomSeparator("//;\n1;2;3");

        List<String> separators = manager.getSeparators();

        // 기본 구분자와 커스텀 구분자까지 총 3개가 있어야 함
        assertEquals(3, separators.size(), "기본 구분자 2개와 커스텀 구분자가 추가되어 총 3개여야 합니다.");
        assertTrue(separators.contains(","), "기본 구분자 쉼표(,)가 구분자 리스트에 있어야 합니다.");
        assertTrue(separators.contains(":"), "기본 구분자 콜론(:)이 구분자 리스트에 있어야 합니다.");
        assertTrue(separators.contains(";"), "커스텀 구분자 세미콜론(;)이 구분자 리스트에 있어야 합니다.");
    }

    @Test
    void shouldNotAddCustomSeparatorWhenNotPresentInInput() {
        SeparatorManager manager = new SeparatorManager();
        manager.addCustomSeparator("1,2:3");

        // 커스텀 구분자가 없는 경우 기본 구분자만 있어야 함
        List<String> separators = manager.getSeparators();
        assertEquals(2, separators.size(), "커스텀 구분자가 없으므로 기본 구분자 2개만 있어야 합니다.");
        assertTrue(separators.contains(","), "기본 구분자 쉼표(,)가 구분자 리스트에 있어야 합니다.");
        assertTrue(separators.contains(":"), "기본 구분자 콜론(:)이 구분자 리스트에 있어야 합니다.");
        assertFalse(separators.contains(";"), "커스텀 구분자 세미콜론(;)은 추가되지 않아야 합니다.");
    }
}
