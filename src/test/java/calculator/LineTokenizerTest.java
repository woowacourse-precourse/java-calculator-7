package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTokenizerTest {


    @Test
    @DisplayName("문자열을 구분자로 나누어 숫자로 변환한다.")
    void tokenize() {
        LineTokenizer lineTokenizer = new LineTokenizer(List.of(',', ':'));

        List<Integer> numbers = lineTokenizer.tokenize("1,2:3");

        assertAll(
            () -> assertEquals(3, numbers.size()),
            () -> assertEquals(1, numbers.get(0)),
            () -> assertEquals(2, numbers.get(1)),
            () -> assertEquals(3, numbers.get(2))
        );

    }

    @Test
    @DisplayName("숫자가 들어와도 구분자로 나누어 숫자로 변환한다.")
    void tokenizeWithNumber() {
        LineTokenizer lineTokenizer = new LineTokenizer(List.of(',', ':', '1'));

        List<Integer> numbers = lineTokenizer.tokenize("1,123:131,41231");
        System.out.println(numbers);

        assertAll(
            () -> assertEquals(4, numbers.size()),
            () -> assertEquals(23, numbers.get(0)),
            () -> assertEquals(3, numbers.get(1)),
            () -> assertEquals(4, numbers.get(2)),
            () -> assertEquals(23, numbers.get(3))
        );
    }
}