package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {
    @Test
    void 문자열_분리_테스트() {
        StringSplitter splitter = new StringSplitter();
        String input = "1,2,3";
        String[] result = splitter.split(input, ",");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 기본_구분자_빈_문자열_예외_테스트_1() {
        StringSplitter splitter = new StringSplitter();
        String input = ",,,";
        assertThatThrownBy(() -> splitter.split(input, ","))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유효한 숫자가 포함되어 있지 않습니다.");
    }
    
    @Test
    void 기본_구분자_빈_문자열_예외_테스트_2() {
        StringSplitter splitter = new StringSplitter();
        String input = "1,,3";
        assertThatThrownBy(() -> splitter.split(input, ","))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("빈 문자열 또는 공백이 포함되어 있습니다.");
    }
    
    @Test
    void 기본_구분자_빈_문자열_예외_테스트_3() {
        StringSplitter splitter = new StringSplitter();
        String input = "1, ,3";
        assertThatThrownBy(() -> splitter.split(input, ","))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("빈 문자열 또는 공백이 포함되어 있습니다.");
    }
}
