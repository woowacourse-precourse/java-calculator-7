package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class CustomStringSplitterTest {

    StringSplitter stringSplitter = new CustomStringSplitter();

    @ParameterizedTest
    @CsvSource({
            "'//*\n2*23*4', '2', '23', '4'",
            "'//i\n2i23i4', '2', '23', '4'"
    })
    void 커스텀_문자열_나누기(String input, String expected1, String expected2, String expected3) {
        List<String> strings = stringSplitter.splitString(input);

        Assertions.assertTrue(strings.contains(expected1));
        Assertions.assertTrue(strings.contains(expected2));
        Assertions.assertTrue(strings.contains(expected3));
        Assertions.assertTrue(strings.size() == 3);
    }

    @ParameterizedTest
    @CsvSource({
            "'//*\n0*123,456:7890', '0', '123', '456', '7890'",
            "'//**&^%\n0*123&456^7890', '0', '123', '456', '7890'"
    })
    void 커스텀_문자열_나누기_기본_구분자_혼합(String input, String expected1, String expected2, String expected3, String expected4) {
        List<String> strings = stringSplitter.splitString(input);

        Assertions.assertTrue(strings.contains(expected1));
        Assertions.assertTrue(strings.contains(expected2));
        Assertions.assertTrue(strings.contains(expected3));
        Assertions.assertTrue(strings.contains(expected4));
        Assertions.assertTrue(strings.size() == 4);
    }

    @ParameterizedTest
    @CsvSource({
            "'//-\n12:34",
            "'//.\n12:34",
            "'//*-\n12:34"
    })
    void 허용되지_않는_커스텀_구분자(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringSplitter.splitString(input));
    }
}