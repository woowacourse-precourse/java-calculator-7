package calculator.service;

import calculator.controller.CalculatorController;
import calculator.dto.request.ConverterRequest;
import calculator.dto.request.DelimiterExtractRequest;
import calculator.dto.response.ConverterResponse;
import calculator.dto.response.DelimiterExtractResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    @Test
    @DisplayName("기본 구분자 반환")
    void testDefaultDelimiterAndInput() {
        DelimiterExtractRequest extractRequest = new DelimiterExtractRequest("1,2:3");
        String expectDelimiter = ",|:";

        DelimiterExtractResponse delimiterExtractResponse =
                calculatorService.extractDelimiter(extractRequest);

        assertThat(delimiterExtractResponse.getDelimiter()).isEqualTo(expectDelimiter);
    }

    @Test
    @DisplayName("커스텀 구분자 포함 전체 반환")
    void testAllDelimiterAndInput() {
        DelimiterExtractRequest extractRequest = new DelimiterExtractRequest("//@\\n1@2@3");
        String input = "//@\\n1@2@3";
        String expectDelimiter = ",|:|@";

        DelimiterExtractResponse delimiterExtractResponse =
                calculatorService.extractDelimiter(extractRequest);

        assertThat(delimiterExtractResponse.getDelimiter()).isEqualTo(expectDelimiter);
    }

    @Test
    @DisplayName("커스텀 구분자가 기본 구분자인 경우")
    void testIsCustomSameDefault() {
        DelimiterExtractRequest extractRequest = new DelimiterExtractRequest("//:\\n2:3:1");

        assertThatThrownBy(() -> calculatorService.extractDelimiter(extractRequest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("커스텀 구분자가 없는 경우")
    void testIsNoneCustomDelimiter() {
        DelimiterExtractRequest extractRequest = new DelimiterExtractRequest("//\\n2:3:1");

        assertThatThrownBy(() -> calculatorService.extractDelimiter(extractRequest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("커스텀 구분자가 여러개인 경우")
    void testIsVariousCustomDelimiter() {
        DelimiterExtractRequest extractRequest = new DelimiterExtractRequest("//@#\\n2#3#1");

        assertThatThrownBy(() -> calculatorService.extractDelimiter(extractRequest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값이 공백인 경우")
    void testIsBlankInput() {
        DelimiterExtractRequest extractRequest = new DelimiterExtractRequest("");
        String expectDelimiter = ",|:";

        DelimiterExtractResponse delimiterExtractResponse =
                calculatorService.extractDelimiter(extractRequest);

        assertThat(delimiterExtractResponse.getDelimiter()).isEqualTo(expectDelimiter);
    }

    @Test
    @DisplayName("커스텀 구분자 뒤 입력이 공백인 경우")
    void testIsBlankBehindCustomDelimiter() {
        DelimiterExtractRequest extractRequest = new DelimiterExtractRequest("//@\\n");

        String expectDelimiter = ",|:|@";
        DelimiterExtractResponse delimiterExtractResponse =
                calculatorService.extractDelimiter(extractRequest);

        assertThat(delimiterExtractResponse.getDelimiter()).isEqualTo(expectDelimiter);
    }

    @Test
    @DisplayName("커스텀 구분자 없을 때 공백인 경우")
    void testIsBlankWithDefaultDelimiter(){
        ConverterRequest converterRequest = new ConverterRequest(",|:", "");

        ConverterResponse converterResponse = calculatorService.convertToList(converterRequest);

        assertThat(converterResponse.getNumbers()).hasSize(0);
    }

    @Test
    @DisplayName("커스텀 구분자 있을 때 공백인 경우")
    void testIsBlankWithCustomDelimiter(){
        ConverterRequest converterRequest = new ConverterRequest(",|:|@", "");

        ConverterResponse converterResponse = calculatorService.convertToList(converterRequest);

        assertThat(converterResponse.getNumbers()).hasSize(0);
    }

    @Test
    @DisplayName("문자열에 구분자 한 개만 있는 경우")
    void testConvertNumberWithDefaultDelimiter(){
        ConverterRequest converterRequest = new ConverterRequest(",|:", "");

        ConverterResponse converterResponse = calculatorService.convertToList(converterRequest);

        assertThat(converterResponse.getNumbers()).hasSize(0);
    }

    @Test
    @DisplayName("커스텀 구분자 포함 문자열 분리 후 숫자 리스트 리턴")
    void testConvertNumberWithCustomDelimiter(){
        ConverterRequest converterRequest = new ConverterRequest(",|:|@", "1,2:3,4:5@6");

        ConverterResponse converterResponse = calculatorService.convertToList(converterRequest);

        assertThat(converterResponse.getNumbers()).hasSize(6).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("분리된 문자열에 기본 또는 커스텀 구분자가 아닌 문자가 있는 경우")
    void testIsContainOtherLetter(){
        ConverterRequest converterRequest = new ConverterRequest(",|:|#", "1,2:3,4:5#6@7");

        assertThatThrownBy(() -> calculatorService.convertToList(converterRequest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("분리된 문자열에 양수가 아닌 0 또는 음수가 있는 경우")
    void testIsContainNotPositiveNumber(){
        ConverterRequest converterRequest = new ConverterRequest(",|:|#", "1,2:3,-1:5#6");

        assertThatThrownBy(() -> calculatorService.convertToList(converterRequest))
                .isInstanceOf(IllegalArgumentException.class);
    }
}