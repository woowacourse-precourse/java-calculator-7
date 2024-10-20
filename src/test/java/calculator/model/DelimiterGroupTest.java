package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterGroupTest {

    private DelimiterGroup delimiterGroup;

    @BeforeEach
    void setUp() {
        delimiterGroup = new DelimiterGroup();
    }

    @Test
    void 기본_구분자로_문자열_분리() {
        // given
        String input = "1,2:3";

        // when
        List<String> result = delimiterGroup.split(input);

        // then
        assertEquals(List.of("1", "2", "3"), result);
    }

    @Test
    void 커스텀_구분자_설정_및_문자열_분리() {
        // given
        CustomDelimiter customDelimiter = new CustomDelimiter(";");
        delimiterGroup.setCustomDelimiters(customDelimiter);
        String input = "1;2,3:4";

        // when
        List<String> result = delimiterGroup.split(input);

        // then
        assertEquals(List.of("1", "2", "3", "4"), result);
    }

    @Test
    void 기본_구분자와_중복되는_커스텀_구분자_설정시_예외_발생() {
        // given
        CustomDelimiter customDelimiter = new CustomDelimiter(",");

        // when & then
        assertThrows(IllegalArgumentException.class, () -> delimiterGroup.setCustomDelimiters(customDelimiter));
    }

    @Test
    void 구분자가_연속된_경우_예외_발생() {
        // given
        String input = "1,,2";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> delimiterGroup.split(input));
    }

    @Test
    void 입력값_시작에_구분자가_있는_경우_예외_발생() {
        // given
        String input = ",1,2,3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> delimiterGroup.split(input));
    }

    @Test
    void 입력값_끝에_구분자가_있는_경우_예외_발생() {
        // given
        String input = "1,2,3,";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> delimiterGroup.split(input));
    }

    @Test
    void 모든_구분자_조합으로_문자열_분리() {
        // given
        CustomDelimiter customDelimiter = new CustomDelimiter(";a");
        delimiterGroup.setCustomDelimiters(customDelimiter);
        String input = "1;a2,3:4";

        // when
        List<String> result = delimiterGroup.split(input);

        // then
        assertEquals(List.of("1", "2", "3", "4"), result);
    }

    @Test
    void 기본_구분자가_포함된_커스텀_구분자로_문자열_분리() {
        // given
        CustomDelimiter customDelimiter = new CustomDelimiter(":,");
        delimiterGroup.setCustomDelimiters(customDelimiter);
        String input = "1:,2,3:4:,5";

        // when
        List<String> result = delimiterGroup.split(input);

        // then
        assertEquals(List.of("1", "2", "3", "4", "5"), result);
    }
}
