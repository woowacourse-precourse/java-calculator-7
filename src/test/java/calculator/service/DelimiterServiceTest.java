package calculator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DelimiterServiceTest {
    DelimiterService delimiterService = new DelimiterService();

    @Test
    void 커스텀_구분자_검증() {
        //given
        String test1 = "//#\n1,2,3";
        String test2 = "$\n1,2,3";
        String test3 = "//$$\n1,2,3";
        String test4 = "//$1,2,3";

        //when
        boolean result1 = delimiterService.validateCustomDelimiterFormat(test1);
        boolean result2 = delimiterService.validateCustomDelimiterFormat(test2);
        boolean result3 = delimiterService.validateCustomDelimiterFormat(test3);
        boolean result4 = delimiterService.validateCustomDelimiterFormat(test4);

        //then
        Assertions.assertThat(result1).isEqualTo(true);
        Assertions.assertThat(result2).isEqualTo(false);
        Assertions.assertThat(result3).isEqualTo(false);
        Assertions.assertThat(result4).isEqualTo(false);
    }

    @Test
    void 기본_구분자_검증() {
        //given
        String test1 = "1,2,3";
        String test2 = "1:2:3";
        String test3 = "1,2:3";
        String test4 = "//#\n1,2,3";
        String test5 = "1,2,3#4";

        //when
        boolean result1 = delimiterService.validateDefaultDelimiterFormat(test1);
        boolean result2 = delimiterService.validateDefaultDelimiterFormat(test2);
        boolean result3 = delimiterService.validateDefaultDelimiterFormat(test3);
        boolean result4 = delimiterService.validateDefaultDelimiterFormat(test4);
        boolean result5 = delimiterService.validateDefaultDelimiterFormat(test5);

        //then
        Assertions.assertThat(result1).isEqualTo(true);
        Assertions.assertThat(result2).isEqualTo(true);
        Assertions.assertThat(result3).isEqualTo(true);
        Assertions.assertThat(result4).isEqualTo(false);
        Assertions.assertThat(result5).isEqualTo(false);
    }
}