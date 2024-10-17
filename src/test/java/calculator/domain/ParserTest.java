package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ParserTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1,2:3 . false",
            ",1:2 . false",
            "//a\\n1a2a3 . true",
            "/=\\n1=2=3 . false",
            "// \\n1 2 3 . true",
            " . false",
            "//a\\3a2a1 . false"},
            delimiter = '.'
    )
    @DisplayName("커스텀 구분자 존재 유무 판단 테스트")
    void hasCustomDelimiter(String delimiter, boolean expected){
        boolean result = Parser.hasCustomDelimiter(delimiter);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "//a\\n1a2a3a1 . a",
            "//||\\n1||2||3||1 . ||",
            "// \\n1 2 4 . ' '"},
            delimiter = '.'
    )
    @DisplayName("커스텀 구분자 추출 테스트")
    void extractCustomDelimiter(String string, String expected){
        String result = Parser.extractCustomDelimiter(string);
        assertThat(result).isEqualTo(expected);
    }
}