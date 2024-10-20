package calculator;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class InputUtilsTest {


    @Test
    void 구분자로_문자열_나누기(){

        String input = "1,2,3";
        String delimiter = "[,:]";

        String[] expected = {"1","2","3"};

        assertSimpleTest(() ->
                assertThat(InputUtils.splitInputs(input, delimiter)).isEqualTo(expected));
    }

    @Test
    void 문자배열을_숫자배열로_변경하기(){
        String[] strArray = {"1","2","3"};

        int[] expected = {1,2,3};

        assertSimpleTest(() -> {
            assertThat(InputUtils.StringToNumber(strArray)).isEqualTo(expected);
        });
    }

    @Test
    void 입력값에_커스텀구분자가_있는지_검사하기(){
        String input = "//;\\n1;2;3";

        boolean expected = true;

        assertSimpleTest(() -> {
            assertThat(InputUtils.isCustomDelimiter(input)).isEqualTo(expected);
        });
    }

    @Test
    void 커스텀구분자_입력일때_뒷숫자부분_추출하기(){
        String input = "//;\\n1;2;3";

        String expected = "1;2;3";

        assertSimpleTest(() ->{
            assertThat(InputUtils.extractNumbers(input)).isEqualTo(expected);
        });
    }

    @Test
    void 커스텀구분자_입력일때_커스텀구분자_추출하기(){
        String input = "//;\\n1;2;3";

        String expected = ";";

        assertSimpleTest(() ->{
            assertThat(InputUtils.extractDelimiter(input)).isEqualTo(expected);
        });
    }

    @Test
    void 숫자대신_문자가_입력됐을때_예외발생(){
        String input = "a";

        assertThatThrownBy(() ->{
            InputUtils.validateInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("조건에 맞게 입력해주세요");

    }

    @Test
    void 음수가_입력됐을때_예외발생(){
        String input = "-1";

        assertThatThrownBy(() ->{
            InputUtils.validateInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이상의 숫자를 입력해주세요");

    }

}
