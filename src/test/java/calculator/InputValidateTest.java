package calculator;

import static calculator.global.error.ErrorCode.NOT_POSITIVE_ERROR_MESSAGE;
import static calculator.global.error.ErrorCode.NUMERIC_ERROR_MESSAGE;
import static calculator.view.InputView.removeUnUsedSentence;
import static calculator.view.InputView.splitInput;
import static calculator.view.InputView.validateNumber;
import static calculator.view.InputView.validatePositiveNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.global.Seperator;
import calculator.global.error.NumericError;
import calculator.service.CustomSeperator;
import calculator.view.InputView;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidateTest {

    private CustomSeperator customSeperator;

    @BeforeEach
    void settUpCustomSeperator() {
        customSeperator = new CustomSeperator();
    }

    @Test
    @DisplayName("커스텀 구분자 값 비교")
    void 커스텀_구분자_값_비교() {
        customSeperator.updateCustomSeperator("//!\\n1,2,3");
        assertEquals(Seperator.CUSTOM.getSeperator(), "!");
    }

    @Test
    @DisplayName("커스텀 구분자만 제거 후 값 비교")
    void 커스텀_구분자_제거_후_값_비교() {
        customSeperator.updateCustomSeperator("//!\\n1,2,3");
        List<String> notIncudedCustomSeperator = removeUnUsedSentence("//!\\n1,2,3");

        assertThat(notIncudedCustomSeperator).contains("1,2,3");
    }

    @Test
    @DisplayName("커스텀 구분자가 문자열 앞이 아닐 시 제거 후 값 비교")
    void 커스텀_구분자_앞이_아닐시_제거_후_값_비교() {
        customSeperator.updateCustomSeperator("1,2//!\\n3");
        List<String> numbers = splitInput(removeUnUsedSentence("1,2//!\\n3"));

        assertThat(numbers).contains("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자에 메타문자 포함 시 제거 후 값 비교")
    void 커스텀_구분자에_메타문자_포함시_제거_후_값_비교() {
        customSeperator.updateCustomSeperator("1,2//?\\n3?4");
        List<String> numbers = splitInput(removeUnUsedSentence("1,2//?\\n3?4"));

        assertThat(numbers).contains("1", "2", "3", "4");
    }

    @Test
    @DisplayName("구분자들 제거 후 값 비교")
    void 구분자_제거_후_값_비교() {
        customSeperator.updateCustomSeperator("//!\\n1,2,3");
        List<String> numbers = splitInput(removeUnUsedSentence("//!\\n1,2:3!4"));

        assertThat(numbers).contains("1", "2", "3", "4");
    }

    @Test
    @DisplayName("커스텀 구분자가 아닌 구분자를 사용 할 시 오류 출력")
    void 커스텀_아닌_구분자를_사용시_오류() {
        List<String> numbers = InputView.splitInput(removeUnUsedSentence("//!\\n1,1&2"));

        assertThatThrownBy(() -> validateNumber(numbers))
                .isInstanceOf(NumericError.class)
                .hasMessage(NUMERIC_ERROR_MESSAGE.getErrorMsg());
    }

    @DisplayName("입력 숫자에 구분자가 아닌 문자가 포함될 시 오류 출력")
    @Test
    void 커스텀_아닌_값_포함시_오류() {
        List<String> numbers = InputView.splitInput(removeUnUsedSentence("ㄱ,1,2"));

        assertThatThrownBy(() -> validateNumber(numbers))
                .isInstanceOf(NumericError.class)
                .hasMessage(NUMERIC_ERROR_MESSAGE.getErrorMsg());
    }

    @DisplayName("커스텀 구분자의 값을 잘못 입력 할 시 오류 출력")
    @Test
    void 커스텀_구분자를_잘못_입력시_오류() {
        List<String> numbers = InputView.splitInput(removeUnUsedSentence("///!\n1,1,2"));

        assertThatThrownBy(() -> validateNumber(numbers))
                .isInstanceOf(NumericError.class)
                .hasMessage(NUMERIC_ERROR_MESSAGE.getErrorMsg());
    }

    @DisplayName("입력 숫자에 양수가 아닌 값 포함될 시 오류 출력")
    @Test
    void 양수가_아닌_값_포함시_오류() {
        List<String> numbers = List.of("-1", "2", "0", "3");

        assertThatThrownBy(() -> validatePositiveNumber(numbers))
                .isInstanceOf(NumericError.class)
                .hasMessage(NOT_POSITIVE_ERROR_MESSAGE.getErrorMsg());
    }

}
