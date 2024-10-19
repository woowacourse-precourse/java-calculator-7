package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.dto.DelimiterInputDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @DisplayName("커스텀 구분자가 존재하는 경우")
    @Test
    void isCustomDelimiterTrue() {

        //given
        String inputString = "//*\n1*2*3";

        //when
        boolean result = calculatorService.isCustomDelimiter(inputString);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("구분자가 존재하지 않는 경우")
    @Test
    void isCustomDelimiterFalse() {

        //given
        String inputString = "1*2*3";

        //when
        boolean result = calculatorService.isCustomDelimiter(inputString);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("커스텀 구분자를 파싱하는 테스트")
    @Test
    void parseCustomDelimiter() {

        //given
        String inputString = "//*\n1*2*3";

        //when
        String delimiter = calculatorService.parseCustomDelimiter(inputString);

        //then
        assertThat(delimiter).isEqualTo("*");
    }

    @DisplayName("커스텀 구분자 길이 검증 성공 테스트")
    @Test
    void checkDelimiterLength() {

        //given
        String delimiter = "^";

        //when - then
        assertThatCode(() -> calculatorService.checkDelimiterLength(delimiter))
                .doesNotThrowAnyException();
    }

    @DisplayName("커스텀 구분자 길이 검증 실패 테스트")
    @Test
    void checkDelimiterLengthException() {

        //given
        String delimiter = "^_^";

        //when - then
        assertThatThrownBy(() -> calculatorService.checkDelimiterLength(delimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자 숫자 유무 검증 성공 테스트")
    @Test
    void checkDelimiterIsNumber() {

        //given
        String delimiter = "&";

        //when - then
        assertThatCode(() -> calculatorService.checkDelimiterIsNumber(delimiter))
                .doesNotThrowAnyException();
    }

    @DisplayName("커스텀 구분자 숫자 유무 검증 실패 테스트")
    @Test
    void checkDelimiterIsNumberException() {

        //given
        String delimiter = "6";

        //when - then
        assertThatThrownBy(() -> calculatorService.checkDelimiterIsNumber(delimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자 +, - 부호 유무 검증 성공 테스트")
    @Test
    void checkDelimiterPlusMinus() {

        //given
        String delimiter = "%";

        //when - then
        assertThatCode(() -> calculatorService.checkDelimiterPlusMinus(delimiter))
                .doesNotThrowAnyException();
    }

    @DisplayName("커스텀 구분자 +, - 부호 유무 검증 실패 테스트")
    @Test
    void checkDelimiterPlusMinusException() {

        //given
        String delimiterPlus = "+";
        String delimiterMinus = "-";

        //when
        assertThatThrownBy(() -> calculatorService.checkDelimiterPlusMinus(delimiterPlus))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculatorService.checkDelimiterPlusMinus(delimiterMinus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구분자 셋 테스트")
    @Test
    void setDelimiter() {
        //given
        String customDelimiter = "&";
        String inputString = "//" + customDelimiter + "\n1&2&3";

        DelimiterInputDto delimiterInputDto =
                new DelimiterInputDto(inputString, new ArrayList<>(List.of(",", ":")));

        delimiterInputDto.setInputString(inputString);

        //when
        calculatorService.setDelimiter(delimiterInputDto);

        //then
        assertThat(delimiterInputDto.getDelimiters().contains(customDelimiter)).isTrue();
    }

    @DisplayName("inputString에 구분자 설정 문자 파싱 테스트")
    @Test
    void updateInputString() {

        //given
        String customDelimiter = "&";
        String inputString = "//" + customDelimiter + "\n1&2&3";
        DelimiterInputDto delimiterInputDto = new DelimiterInputDto(inputString, new ArrayList<>(List.of(",", ":")));

        //when
        calculatorService.updateInputString(delimiterInputDto);

        //then
        assertThat(delimiterInputDto.getInputString()).isEqualTo("1&2&3");
    }

    @DisplayName("구분자를 정규식으로 파싱 기능 테스트")
    @Test
    void formatDelimiters() {

        //given
        List<String> delimiters = new ArrayList<>(List.of(",", ":", "&"));

        //when
        String formatDelimiters = calculatorService.formatDelimiters(delimiters);

        //then
        assertThat(formatDelimiters).isEqualTo("[,:&]");
    }

    @DisplayName("입력된 숫자를 구분자 기준으로 분리")
    @Test
    void parseNumber() {

        //given
        String inputNumber = "1,2:3$4";
        List<String> delimiterList = new ArrayList<>(List.of(",", ":", "$"));
        DelimiterInputDto delimiterInputDto = new DelimiterInputDto(inputNumber, delimiterList);

        //when
        List<String> numbers = calculatorService.parseNumber(delimiterInputDto);

        //then
        assertThat(numbers.size()).isEqualTo(4);
        assertThat(numbers.contains("1")).isTrue();
        assertThat(numbers.contains("2")).isTrue();
        assertThat(numbers.contains("3")).isTrue();
        assertThat(numbers.contains("4")).isTrue();

    }
}