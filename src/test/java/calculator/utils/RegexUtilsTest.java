package calculator.utils;

import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.DefaultDelimiter;
import calculator.domain.delimiter.Delimiter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
}