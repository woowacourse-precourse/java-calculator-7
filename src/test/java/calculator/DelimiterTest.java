package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterTest {

    @Test
    void 기본_구분자_쉼표와_콜론_테스트() {
        String input = "1,2:3";
        String[] result = Delimiter.split(input);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀_구분자_테스트() {
        String input = "//;\\n1;2;3";
        String[] result = Delimiter.split(input);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀_구분자가_여러_글자인_경우() {
        String input = "//***\\n1***2***3";
        String[] result = Delimiter.split(input);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀_구분자에_숫자가_포함된_테스트() {
        String input = "//1\\n412";
        String[] result = Delimiter.split(input);
        assertThat(result).containsExactly("4", "2");
    }

    @Test
    void 빈_문자열_입력() {
        String input = "";
        String[] result = Delimiter.split(input);
        assertThat(result).containsExactly("");
    }
}