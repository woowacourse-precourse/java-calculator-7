package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest {

    // CustomSeparator() 메소드 테스트
    @Test
    void 커스텀구분자_유효한경우() {
        String input = "//.\\n1.2.3";
        char result = calculator.Application.CustomSeparator(input);
        assertThat(result).isEqualTo('.');
    }

    @Test
    void 커스텀구분자_잘못된경우() {
        String input = "//l\n1,2,3";
        assertThatThrownBy(() -> calculator.Application.CustomSeparator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자를 정확하게 입력해주세요.");
    }

    // extractSeparator() 메소드 테스트
    @Test
    void 구분자추출_유효한경우() {
        String input = "//-\\n1-2";
        char separator = calculator.Application.extractSeparator(input);
        assertThat(separator).isEqualTo('-');
    }

    @Test
    void 구분자추출_잘못된경우() {
        String input = "//a1,2";
        assertThatThrownBy(() -> calculator.Application.extractSeparator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자를 정확하게 입력해주세요.");
    }

    // validateSeparator() 메소드 테스트
    @Test
    void 구분자_유효성검사() {
        assertThatThrownBy(() -> calculator.Application.validateSeparator(','))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("기본 구분자입니다.");

        assertThatThrownBy(() -> calculator.Application.validateSeparator(';'))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("기본 구분자입니다.");

        assertThatThrownBy(() -> calculator.Application.validateSeparator('1'))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 구분자로 사용할 수 없습니다.");
    }

    // InputArr() 메소드 테스트
    @Test
    void 입력배열변환_기본구분자() {
        String input = "1,2;3";
        String[] expectedArr = {"1", "2", "3"};
        String[] result = calculator.Application.InputArr(input);
        assertThat(result).isEqualTo(expectedArr);
    }

    @Test
    void 입력배열변환_사용자정의구분자() {
        String input = "//l\\n1l2l3";
        String[] expectedArr = {"1", "2", "3"};
        String[] result = calculator.Application.InputArr(input);
        assertThat(result).isEqualTo(expectedArr);
    }

    // InputException() 메소드 테스트
    @Test
    void 입력예외_빈값포함() {
        String[] invalidInput = {"", "2", "3"};
        assertThatThrownBy(() -> calculator.Application.InputException(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 입력이 제대로 되지 않았습니다.");
    }

    @Test
    void 입력예외_0포함() {
        String[] invalidInput = {"0", "2", "3"};
        assertThatThrownBy(() -> calculator.Application.InputException(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0은 입력할 수 없습니다.");
    }

    @Test
    void 입력예외_0여러개_포함() {
        String[] invalidInput = {"000", "2", "3"};
        assertThatThrownBy(() -> calculator.Application.InputException(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0은 입력할 수 없습니다.");
    }

    @Test
    void 입력예외_음수인경우() {
        String[] invalidInput = {"-3", "2", "3"};
        assertThatThrownBy(() -> calculator.Application.InputException(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }

    @Test
    void 입력예외_숫자_구분자외문자() {
        String[] invalidInput = {"a", "2", "3"};
        assertThatThrownBy(() -> calculator.Application.InputException(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자, 구분자 이외의 문자가 들어왔습니다.");
    }

    @Test
    void 입력예외_너무큰숫자() {
        String[] invalidInput = {"9999999999999999999", "2", "3"};
        assertThatThrownBy(() -> calculator.Application.InputException(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("너무 큰 숫자는 입력할 수 없습니다.");
    }

    // IntArr() 메소드 테스트
    @Test
    void 문자열배열을_숫자배열로변환() {
        String[] inputArr = {"2", "2", "3"};
        int[] expectedArr = {2, 2, 3};
        int[] result = calculator.Application.IntArr(inputArr);
        assertThat(result).isEqualTo(expectedArr);
    }

    // Sum() 메소드 테스트
    @Test
    void 합계계산() {
        int[] inputArr = {2, 3, 4};
        int result = calculator.Application.Sum(inputArr);
        assertThat(result).isEqualTo(9);
    }
}
