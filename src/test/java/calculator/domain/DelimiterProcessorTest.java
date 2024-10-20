package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterProcessorTest {

    @DisplayName("기본 구분자로 처리하여 성공한다.")
    @Test
    void 기본_구분자_처리() {
        DelimiterProcessor delimiterProcessor = new DelimiterProcessor("1,2:3");
        String[] result = delimiterProcessor.process();
        String[] expected = {"1", "2", "3"};

        assertArrayEquals(result, expected);
    }

    @DisplayName("커스텀 구분자로 처리하여 성공한다.")
    @Test
    void 커스텀_구분자_처리() {
        DelimiterProcessor delimiterProcessor = new DelimiterProcessor("//;\\n1;2;3");
        String[] result = delimiterProcessor.process();
        String[] expected = {"1", "2", "3"};

        assertArrayEquals(result, expected);
    }

    @DisplayName("구분자가 없을 때 예외가 발생한다.")
    @Test
    void 구분자가_없을_때_예외_발생() {
        DelimiterProcessor delimiterProcessor = new DelimiterProcessor("123");
        assertThrows(IllegalArgumentException.class, delimiterProcessor::process);
    }

    @DisplayName("커스텀 구분자를 지정하지 못했을 때 예외가 발생한다.")
    @Test
    void 커스텀_구분자_지정하지_못했을_때_예외_발생() {
        DelimiterProcessor delimiterProcessor = new DelimiterProcessor("//;1;2;3");
        assertThrows(IllegalArgumentException.class, delimiterProcessor::process);
    }

    @DisplayName("유효하지 않은 커스텀 구분자일 때 예외가 발생한다.")
    @Test
    void 유효하지_않은_커스텀_구분자_예외_발생() {
        DelimiterProcessor delimiterProcessor = new DelimiterProcessor("//:\\n1:2:3");
        assertThrows(IllegalArgumentException.class, delimiterProcessor::process);
    }

}