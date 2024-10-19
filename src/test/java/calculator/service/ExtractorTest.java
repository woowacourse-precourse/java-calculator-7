package calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExtractorTest {

    @DisplayName("사용자 입력을 통해 숫자를 추출한다.")
    @Test
    void splitNumberPartAndDelimiter() {
        //given
        String input = "1,2:3";
        //when
        Extractor extractor = Extractor.from(input);
        //then
        assertThat(extractor).extracting("delimiters.delimiters").isEqualTo(Set.of(",", ":"));
        assertThat(extractor).extracting("numberPart").isEqualTo("1,2:3");
    }

    @DisplayName("커스텀 구분자가 존재 할 때 사용자 입력을 통해 커스텀 구분자와 숫자를 추출한다.")
    @Test
    void splitNumberPartAndDelimiterWhenUseCustomDelimiter() {
        //given
        String input = "//;\\n1;2;3";
        //when
        Extractor extractor = Extractor.from(input);
        //then
        assertThat(extractor).extracting("delimiters.delimiters").isEqualTo(Set.of(";"));
        assertThat(extractor).extracting("numberPart").isEqualTo("1;2;3");
    }

    @DisplayName("사용자 입력이 빈 값일 때 NumberPart는 0을 갖는다")
    @Test
    void numberPartIsZeroWhenInputIsEmpty() {
        //given
        String input = "";
        //when
        Extractor extractor = Extractor.from(input);
        //then
        assertThat(extractor).extracting("numberPart").isEqualTo("0");
    }

    @DisplayName("사용자 입력이 공백일 경우 NumberPart는 0을 갖는다")
    @Test
    void numberPartIsZeroWhenInputIsBlank() {
        //given
        String input = "   ";
        //when
        Extractor extractor = Extractor.from(input);
        //then
        assertThat(extractor).extracting("numberPart").isEqualTo("0");
    }

    @DisplayName("사용자 입력의 숫자부분에 숫자와 구분자가 아닌 다른 문자가 포함되어 있을 때 예외를 발생시킨다.")
    @Test
    void throwIllegalArgumentExceptionWhenNumberPartContainsNonNumberAndDelimiter() {
        //given
        String input = "1,2:3a";
        //when
        Extractor extractor = Extractor.from(input);
        //then
        assertThatIllegalArgumentException()
            .isThrownBy(extractor::extractNumbers)
            .withMessage("숫자와 구분자로만 이루어져야 합니다.");
    }

}