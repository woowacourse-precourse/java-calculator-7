package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import calculator.delimiter.BasicDelimiterHandler;
import calculator.delimiter.CustomDelimiterHandler;
import calculator.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

class DelimiterHandlerTest {

    @Test
    void 기본_구분자로_문자열을_분리한다() {
        BasicDelimiterHandler handler = new BasicDelimiterHandler();
        String result = String.join(",", handler.split("1,2:3")); // 배열을 문자열로 변환
        System.out.println("결과 : " + result);
        assertArrayEquals(new String[]{"1", "2", "3"}, handler.split("1,2:3"));
    }

    @Test
    void 커스텀_구분자로_문자열을_분리한다() {
        CustomDelimiterHandler handler = new CustomDelimiterHandler();
        String result = String.join(",", handler.split("//;\n1;2;3")); // 배열을 문자열로 변환
        System.out.println("결과 : " + result);
        assertArrayEquals(new String[]{"1", "2", "3"}, handler.split("//;\n1;2;3"));
    }

    @Test
    void 유효하지_않은_커스텀_구분자_입력시_예외가_발생한다() {
        CustomDelimiterHandler handler = new CustomDelimiterHandler();
        assertThatThrownBy(() -> handler.split("1;2;3"))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("유효하지 않은 구분자입니다.");
    }
}
