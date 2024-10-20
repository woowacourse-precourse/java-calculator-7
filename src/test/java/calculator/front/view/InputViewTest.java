package calculator.front.view;

import static org.assertj.core.api.Assertions.*;

import calculator.front.input.CustomDelimiterParsedInput;
import calculator.front.input.TotalDelimitedInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Test
    @DisplayName("사용자가 입력한 문자열에서 커스텀구분자, 기본구분자와 구분된숫자를 가지는 TotalDelimitedInput 객체 반환")
    void 입력_뷰_테스트() {
        //given
        InputView inputView = new InputView();
        String rawInput = "//;\\n1,2,3";
        CustomDelimiterParsedInput customDelimiterParsedInput = new CustomDelimiterParsedInput(';', "1,2,3");
        TotalDelimitedInput expectedTotalDelimitedInput = TotalDelimitedInput.fromCustomDelimiterParseInput(
                customDelimiterParsedInput);
        //when
        TotalDelimitedInput totalDelimitedInput = inputView.getTotalDelimitedInput(rawInput);
        //then
        assertThat(expectedTotalDelimitedInput.getInputWithDelimiters()).isEqualTo(
                totalDelimitedInput.getInputWithDelimiters());
        assertThat(expectedTotalDelimitedInput.getDelimiters()).isEqualTo(totalDelimitedInput.getDelimiters());
    }

}