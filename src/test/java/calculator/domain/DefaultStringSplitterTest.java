package calculator.domain;


import calculator.domain.stringsplitter.DefaultStringSplitter;
import calculator.domain.stringsplitter.StringSplitter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class DefaultStringSplitterTest {

    StringSplitter stringSplitter = new DefaultStringSplitter();

    @ParameterizedTest
    @CsvSource({
            "'1,2'",
            "'1:2:3'",
            "'45,67:89'"
    })
    void 기본_문자열_지원_TRUE(String input) {
        Assertions.assertTrue(stringSplitter.canSupport(input));
    }

    @ParameterizedTest
    @CsvSource({
            "6:3:2, '6', '3', '2'",
            "'12,34,56', '12', '34', '56'",
            "'100:200,300', '100', '200', '300'",
    })
    void 기본_문자열_나누기(String input, String expected1, String expected2, String expected3) {
        List<String> strings = stringSplitter.splitString(input);

        Assertions.assertTrue(strings.contains(expected1));
        Assertions.assertTrue(strings.contains(expected2));
        Assertions.assertTrue(strings.contains(expected3));
        Assertions.assertTrue(strings.size() == 3);
    }

    @ParameterizedTest
    @CsvSource({
            "'1', '1'",
            "'234567890', '234567890'"
    })
    void 나누어진_크기가_1인_문자열(String input, String expected1) {
        List<String> strings = stringSplitter.splitString(input);

        Assertions.assertTrue(strings.contains(expected1));
        Assertions.assertTrue(strings.size() == 1);
    }
}
