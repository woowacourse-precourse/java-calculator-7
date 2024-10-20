package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudyTest {

    @Test
    @DisplayName("String.Blank 학습 - 공백으로 이루어진 문자열은 true 이다")
    void testBlankStringTrue(){
        //given
        String blankString="    ";
        //when
        boolean isBlank = blankString.isBlank();
        //then
        Assertions.assertThat(isBlank).isTrue();
    }

    @Test
    @DisplayName("String.Blank 학습 - 아무런 문자도 없는 문자열은 true 이다")
    void testEmptyStringTrue(){
        //given
        String blankString="";
        //when
        boolean isBlank = blankString.isBlank();
        //then
        Assertions.assertThat(isBlank).isTrue();
    }

    @Test
    @DisplayName("String.Blank 학습 - 계행 문자만 있는 문자열은 true 이다")
    void testEmptyStringTrue2(){
        //given
        String blankString="\n";
        //when
        boolean isBlank = blankString.isBlank();
        //then
        Assertions.assertThat(isBlank).isTrue();
    }
}
