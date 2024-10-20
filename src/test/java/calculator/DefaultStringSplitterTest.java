package calculator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class DefaultStringSplitterTest {

    StringSplitter stringSplitter = new DefaultStringSplitter();

    @ParameterizedTest
    @CsvSource({
            "'6:3:2', '6', '3', '2'",
            "'12,34,56', '12', '34', '56'",
            "'100:200,300', '100', '200', '300'",
    })
    void 다양한_구분자_문자열_나누기(String input, String expected1, String expected2, String expected3) {
        List<String> strings = stringSplitter.splitString(input);

        Assertions.assertTrue(strings.contains(expected1));
        Assertions.assertTrue(strings.contains(expected2));
        Assertions.assertTrue(strings.contains(expected3));
        Assertions.assertTrue(strings.size() == 3);
    }
}
