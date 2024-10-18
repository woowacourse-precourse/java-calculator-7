package calculator.parser.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TokenizerTest {

    @Test
    @DisplayName("기본 구분자로 토큰화 성공")
    void tokenizeWithDefaultDelimiters() {
        // Given
        Tokenizer tokenizer = new Tokenizer(",:", "//", "\n");

        // When
        ArrayList<String> tokens = tokenizer.tokenize("1,2,3", null);

        // Then
        ArrayList<String> expectedTokens = new ArrayList<>(List.of("1", "2", "3"));
        assertIterableEquals(expectedTokens, tokens);
    }

    @Test
    @DisplayName("콤마와 콜론을 구분자로 사용하여 토큰화 성공")
    void tokenizeWithCommaAndColonDelimiters() {
        // Given
        Tokenizer tokenizer = new Tokenizer(",:", "//", "\n");

        // When
        ArrayList<String> tokens = tokenizer.tokenize("1,2:3", null);

        // Then
        ArrayList<String> expectedTokens = new ArrayList<>(List.of("1", "2", "3"));

        // List의 값이 같은지 확인
        assertIterableEquals(expectedTokens, tokens);
    }

    @Test
    @DisplayName("커스텀 구분자 '.'으로 토큰화 성공")
    void tokenizeWithCustomDelimiterDot() {
        Tokenizer tokenizer = new Tokenizer(",:", "//", "\n");

        ArrayList<String> tokens = tokenizer.tokenize("//.\n1:2,3:4", '.');
        ArrayList<String> expectedTokens = new ArrayList<>(List.of("1", "2", "3", "4"));
        assertIterableEquals(expectedTokens, tokens);
    }

    @Test
    @DisplayName("커스텀 구분자 'a'로 토큰화 성공")
    void tokenizeWithCustomDelimiterA() {
        Tokenizer tokenizer = new Tokenizer(",:", "//", "\n");

        ArrayList<String> tokens = tokenizer.tokenize("//a\n1:2,3:4", 'a');
        ArrayList<String> expectedTokens = new ArrayList<>(List.of("1", "2", "3", "4"));
        assertIterableEquals(expectedTokens, tokens);
    }

    @Test
    @DisplayName("빈 입력값 토큰화 시 빈 리스트 반환")
    void tokenizeWithEmptyInputReturnsEmptyList() {
        Tokenizer tokenizer = new Tokenizer(",:", "//", "\n");

        ArrayList<String> tokens = tokenizer.tokenize("", null);
        assertEquals(0, tokens.size());
    }

    @Test
    @DisplayName("null 입력값 토큰화 시 빈 리스트 반환")
    void tokenizeWithNullInputReturnsEmptyList() {
        Tokenizer tokenizer = new Tokenizer(",:", "//", "\n");

        ArrayList<String> tokens = tokenizer.tokenize(null, null);
        assertEquals(0, tokens.size());
    }

    @Test
    @DisplayName("커스텀 구분자 정보 제거 테스트")
    void removeCustomDelimiterInfoSuccessfully() {
        Tokenizer tokenizer = new Tokenizer(",:", "//", "\n");

        String s = tokenizer.removeCustomDelimiterInfo("1:2,3:4//.\n");
        assertEquals("1:2,3:4", s);
    }

    @Test
    @DisplayName("커스텀 구분자 정보 제거 - prefix와 suffix 동일")
    void removeCustomDelimiterInfoWithSamePrefixSuffix() {
        Tokenizer tokenizer = new Tokenizer(",:", "//", "//");

        String s = tokenizer.removeCustomDelimiterInfo("1:2,3:4//.//");
        assertEquals("1:2,3:4", s);
    }

    @Test
    @DisplayName("커스텀 구분자 정보 제거 - 구분자가 'a'")
    void removeCustomDelimiterInfoWithDelimiterA() {
        Tokenizer tokenizer = new Tokenizer(",:", "//", "\\n");

        String s = tokenizer.removeCustomDelimiterInfo("//a\\n1");
        assertEquals("1", s);
    }

}
