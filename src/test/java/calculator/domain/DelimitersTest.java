package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DelimitersTest {

    @DisplayName("사용자가 커스텀 구분자를 이용할 경우 커스텀 구분자를 가진다.")
    @Test
    void useCustomDelimiter() {
        //given
        String customDelimiterString = "//;\\n1;2;3";
        //when
        Delimiters delimiters = Delimiters.from(customDelimiterString);
        //then
        assertThat(delimiters)
            .extracting("delimiters").isEqualTo(Set.of(";"));
    }

    @DisplayName("사용자가 커스텀 구분자를 사용하지 않으면 기본 구분자인 :와 ,를 가진다")
    @Test
    void defaultDelimiter() {
        //given
        String defaultDelimiterString = "1,2:3";
        //when
        Delimiters delimiters = Delimiters.from(defaultDelimiterString);
        //then
        assertThat(delimiters)
            .extracting("delimiters").isEqualTo(Set.of(",", ":"));
    }


    @DisplayName("커스텀 구분자인지 확인 할 수 있다. ")
    @Test
    void isCustomDelimiter() {
        //given
        String input = "//;\\n1;2;3";
        Delimiters delimiters = Delimiters.from(input);
        //when
        //then
        assertThat(delimiters.isCustomDelimiter()).isTrue();
    }

    @DisplayName("커스텀 구분자인지 확인한다.")
    @Test
    void isDefaultDelimiter() {
        //given
        String input = "1,2:3";
        Delimiters delimiters = Delimiters.from(input);
        //when
        //then
        assertThat(delimiters.isCustomDelimiter()).isFalse();
    }

    @DisplayName("구분자를 통해 기본 REGEX를 반환한다.")
    @Test
    void getDefaultRegex() {
        //given
        String input = "1,2:3";
        Delimiters delimiters = Delimiters.from(input);
        //when
        String regex = delimiters.getRegex();
        //then
        assertThat(regex).contains(",", ":");
    }

    @DisplayName("구분자를 통해 커스텀 REGEX를 반환한다.")
    @Test
    void getCustomRegex() {
        //given
        String input = "//;\\n1;2;3";
        Delimiters delimiters = Delimiters.from(input);
        //when
        String regex = delimiters.getRegex();
        //then
        assertThat(regex).isEqualTo(";");
    }


}