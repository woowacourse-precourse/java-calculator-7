package calculator;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputSequenceTest {

    @Test
    void sum시_double범위_초과할시() {
        List<BigDecimal> sequence = List.of(new BigDecimal("" + Double.MAX_VALUE), new BigDecimal("1"), new BigDecimal("2"));
        InputSequence inputSequence = new InputSequence(sequence);
        System.out.println("inputSequence = " + inputSequence.sum());
    }

    @Test
    void 빈문자열시() {
        String input = "";
        Delimiter delimiter = new Delimiter(input);
        InputPreprocessing inputPreprocessing = new InputPreprocessing(delimiter);
        InputSequence inputSequence = new InputSequence(inputPreprocessing.of(input));
        Assertions.assertEquals(new BigDecimal("0").abs(), inputSequence.sum());
    }

    @Test
    void 중간에_요소가_비었을때() {
        String input = "//c\\n1c2cc3";
        Delimiter delimiter = new Delimiter(input);
        InputPreprocessing inputPreprocessing = new InputPreprocessing(delimiter);
        InputSequence inputSequence = new InputSequence(inputPreprocessing.of(input));
        Assertions.assertEquals(new BigDecimal("6").abs(), inputSequence.sum());
    }
}