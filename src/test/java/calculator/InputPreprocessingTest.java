package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputPreprocessingTest {

    @Test
    void 정상흐름() {
        Delimiter delimiter = new Delimiter("//abc\\n1abc2abc3abc");
        List<Long> list = new InputPreprocessing(delimiter).of("//abc\\n1abc2abc3abc");
        assertEquals(3, list.size());
        Delimiter delimiter1 = new Delimiter("1,2,3,4,5");
        List<Long> list1 = new InputPreprocessing(delimiter1).of("1,2,3,4,5");
        assertEquals(5, list1.size());
    }

    @Test
    void 잘못된_입력_split시_오류() {
        String input = "1n,2,4,5";
        Delimiter delimiter = new Delimiter(input);
        assertThatThrownBy(() -> new InputPreprocessing(delimiter).of(input))
                .hasMessage("구분자 외의 문자나 음수가 존재합니다.");
    }

    @Test
    void casting시_long범위_넘어간_경우_오류() {
        String input = "9223372036854775808,1,2,3";
        Delimiter delimiter = new Delimiter(input);
        assertThatThrownBy(() -> new InputPreprocessing(delimiter).of(input))
                .hasMessage("더하는 값 중 너무 큰 수가 존재합니다.");
    }

    @Test
    void 요소에_0이_들어간_경우_오류() {
        String input = "0,2,3";
        Delimiter delimiter = new Delimiter(input);
        assertThatThrownBy(() -> new InputPreprocessing(delimiter).of(input))
                .hasMessage("더하는 값은 양수만 가능합니다.");
    }
}