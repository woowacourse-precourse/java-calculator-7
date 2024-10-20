package calculator.extractor;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringSplitterImplTest {

    private final StringSplitterImpl stringSplitter = new StringSplitterImpl();

    @Test
    void 기본_구분자로_문자열_분리() {
        String input = "1,2:3";
        String[] result = stringSplitter.split(input);

        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 기본_구분자_음수() {
        String input = "1,-2:3";
        String[] result = stringSplitter.split(input);

        assertThat(result).containsExactly("1", "-2", "3");
    }

    @Test
    void 빈문자열() {
        String input = "";
        String[] result = stringSplitter.split(input);

        assertThat(result).containsExactly("");
    }

    @Test
    void 공백() {
        String input = "1,,22:3";
        String[] result = stringSplitter.split(input);

        assertThat(result).containsExactly("1", "", "22", "3");
    }

    @Test
    void 커스텀_구분자로_문자열_분리() {
        String input = "//;\\n1;2;3";
        String[] result = stringSplitter.split(input);

        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀_구분자_뒤_숫자() {
        String input = "//;\\n1;";
        String[] result = stringSplitter.split(input);

        assertThat(result).containsExactly("1");
    }

    @Test
    void 커스텀_구분자_앞_숫자() {
        String input = "//;\\n;1";
        String[] result = stringSplitter.split(input);

        assertThat(result).containsExactly("", "1");
    }

    @Test
    void 잘못된_구분자_형식_구분자_누락() {
        String input = "//;";

        assertThatThrownBy(() -> stringSplitter.split(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 구분자 형식입니다.");
    }

    @Test
    void 잘못된_구분자_형식_구분자_비어있음() {
        String input = "//\\n";

        assertThatThrownBy(() -> stringSplitter.split(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자가 비어 있습니다.");
    }

    @Test
    void 잘못된_구분자_포함() {
        String input = "1!2,3";
        assertThatThrownBy(() -> stringSplitter.split(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 구분자 형식입니다.");
    }

    @Test
    void 잘못된_구분자_포함_이스케이프() {
        String input = "1|2,3";
        assertThatThrownBy(() -> stringSplitter.split(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 구분자 형식입니다.");
    }
}
