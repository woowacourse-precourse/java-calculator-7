package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class DelimiterGroupTest {

    @Test
    void 기본_구분자로_문자열_분리() {
        // given
        String input = "1,2:3";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);
        DelimiterGroup delimiterGroup = new DelimiterGroup(customDelimiter);

        // when
        List<String> result = delimiterGroup.split(input);

        // then
        assertEquals(List.of("1", "2", "3"), result);
    }

    @Test
    void 커스텀_구분자_설정_및_문자열_분리() {
        // given
        String input = "//;\\n1;2,3:4";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);
        DelimiterGroup delimiterGroup = new DelimiterGroup(customDelimiter);
        input = customDelimiter.getInputWithoutCustomDelimiter();

        // when
        List<String> result = delimiterGroup.split(input);

        // then
        assertEquals(List.of("1", "2", "3", "4"), result);
    }

    @Test
    void 구분자가_연속된_경우_예외_발생() {
        // given
        String input = "1,,2";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);
        DelimiterGroup delimiterGroup = new DelimiterGroup(customDelimiter);

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> delimiterGroup.split(input));
    }

    @Test
    void 입력값_시작에_구분자가_있는_경우_예외_발생() {
        // given
        String input = ",1,2,3";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);
        DelimiterGroup delimiterGroup = new DelimiterGroup(customDelimiter);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> delimiterGroup.split(input));
    }

    @Test
    void 입력값_끝에_구분자가_있는_경우_예외_발생() {
        // given
        String input = "1,2,3,";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);
        DelimiterGroup delimiterGroup = new DelimiterGroup(customDelimiter);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> delimiterGroup.split(input));
    }

    @Test
    void 모든_구분자_조합으로_문자열_분리() {
        // given
        String input = "//;a\\n1;a2,3:4";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);
        DelimiterGroup delimiterGroup = new DelimiterGroup(customDelimiter);
        input = customDelimiter.getInputWithoutCustomDelimiter();

        // when
        List<String> result = delimiterGroup.split(input);

        // then
        assertEquals(List.of("1", "2", "3", "4"), result);
    }

    @Test
    void 기본_구분자가_포함된_커스텀_구분자로_문자열_분리() {
        // given
        String input = "//:,\\n1:,2,3:4";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);
        DelimiterGroup delimiterGroup = new DelimiterGroup(customDelimiter);
        input = customDelimiter.getInputWithoutCustomDelimiter();

        // when
        List<String> result = delimiterGroup.split(input);

        // then
        assertEquals(List.of("1", "2", "3", "4"), result);
    }

    @Test
    void 입력이_빈_문자열_일때_0을_가진_배열_반환() {
        // given
        String input = "";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);
        DelimiterGroup delimiterGroup = new DelimiterGroup(customDelimiter);

        // when
        List<String> result = delimiterGroup.split(input);

        // then
        assertEquals(List.of("0"), result);
    }
}
