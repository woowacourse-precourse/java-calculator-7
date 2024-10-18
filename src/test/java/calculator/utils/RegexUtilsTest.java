package calculator.utils;

import calculator.domain.Candidate;
import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.DefaultDelimiter;
import calculator.domain.delimiter.Delimiter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RegexUtilsTest {
    @Test
    void OR_정규표현식_생성() {
        //given
        List<Delimiter> delimiters = new ArrayList<>();
        delimiters.add(new DefaultDelimiter(","));
        delimiters.add(new DefaultDelimiter(":"));
        delimiters.add(new CustomDelimiter("="));
        String expected = ",|:|=";

        //when
        String result = RegexUtils.makeAllOfDelimiters(delimiters);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 입력_매치_성공_숫자() {
        //given
        String input = "1,2:3";

        //when
        boolean result = RegexUtils.isMatchedInput(input);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void 입력_매치_성공_커스텀구분자() {
        //given
        String input = "//:\\n1,2:3";

        //when
        boolean result = RegexUtils.isMatchedInput(input);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void 입력_매치_성공_공백() {
        //given
        String input = "";

        //when
        boolean result = RegexUtils.isMatchedInput(input);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void 입력_매치_실패_문자로시작() {
        //given
        String input = "+2,3:1";

        //when
        boolean result = RegexUtils.isMatchedInput(input);

        //then
        assertThat(result).isFalse();
    }

    @Test
    void 숫자_매치_성공() {
        //given
        Candidate candidate = new Candidate("10");

        //when
        boolean result = RegexUtils.isMatchedNumber(candidate);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void 숫자_매치_실패_음수() {
        //given
        Candidate candidate = new Candidate("-1");

        //when
        boolean result = RegexUtils.isMatchedNumber(candidate);

        //then
        assertThat(result).isFalse();
    }

    @Test
    void 숫자_매치_실패_숫자가아님() {
        //given
        Candidate candidate = new Candidate("=2");

        //when
        boolean result = RegexUtils.isMatchedNumber(candidate);

        //then
        assertThat(result).isFalse();
    }
}
