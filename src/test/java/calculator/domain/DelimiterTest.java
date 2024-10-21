package calculator.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DelimiterTest
{
    @DisplayName("하나의 커스텀 구분자 확인_예외")
    @Test
    void findCustomDelimiterTest_error(){
        assertThatThrownBy(() -> new Delimiter("//;;\\n123"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("하나의 커스텀 구분자 확인")
    @Test
    void findCustomDelimiterTest(){
        Delimiter delimiter = new Delimiter("//;\\n123");
        assertThat(delimiter.CUSTOM_DELIMITER).isEqualTo(';');
    }
    @DisplayName("커스텀 구분자 존재시 확인")
    @Test
    void hasCustomDelimiterTest(){
        Delimiter delimiter = new Delimiter("//;\\n123");
        assertThat(delimiter.hasCustomDelimiter()).isEqualTo(true);
    }
    @DisplayName("커스텀 구분자 미존재시 확인")
    @Test
    void notHasCustomDelimiterTest(){
        Delimiter delimiter = new Delimiter();
        assertThat(delimiter.hasCustomDelimiter()).isEqualTo(false);
    }
    @DisplayName("기본 구분자 콜론 확인")
    @Test
    void checkColonDelimiter(){
        assertThat(Delimiter.COLON_DELIMITER).isEqualTo(':');
    }
    @DisplayName("기본 구분자 콤마 확인")
    @Test
    void checkCommaDelimiter(){
        assertThat(Delimiter.COMMA_DELIMITER).isEqualTo(',');
    }
}
