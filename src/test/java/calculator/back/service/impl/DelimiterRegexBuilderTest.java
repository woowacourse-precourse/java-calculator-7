package calculator.back.service.impl;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterRegexBuilderTest {

    @Test
    @DisplayName("구분자 리스트를 정규 표현식 형태로 반환")
    void 구분자_정규표현식_변환() {
        //given
        List<Character> delimiters = List.of('c', '|', '*', '.', ';');
        String delimitersRegex = "[c\\|\\*\\.;]";
        //when
        String invokedMethod = DelimiterRegexBuilder.buildDelimiterRegex(delimiters);
        //then
        assertThat(delimitersRegex).isEqualTo(invokedMethod);
    }

}