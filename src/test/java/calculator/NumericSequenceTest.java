package calculator;

import calculator.domain.InputtedString;
import calculator.domain.NumericSequence;
import calculator.domain.delimiters.Delimiters;
import calculator.domain.delimiters.DelimitersFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumericSequenceTest {
    DelimitersFactory factory = new DelimitersFactory();

    @Test
    void test() {
        List<String> lines = new ArrayList<>();
        lines.add("1,2,3");
        lines.add("//*\\n1*2,3");
        lines.add("1,2:3");
        for (String line : lines) {
            InputtedString inputtedString = new InputtedString(line);
            Delimiters delimiters = factory.getFromStringAfterValidate(inputtedString);
            NumericSequence numericSequence =
                    NumericSequence.getOfStringAndDelimiters(inputtedString, delimiters);
            assertEquals(6, numericSequence.getTotalSum());
        }

    }
}
