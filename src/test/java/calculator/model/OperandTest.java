package calculator.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class OperandTest {
    @Test
    void String_리스트를_입력_시() {
        List<String> inputArgument = new ArrayList<>();
        inputArgument.add("0");
        inputArgument.add("1");
        inputArgument.add("2");

        Operand operand = new Operand(inputArgument);
        List<Integer> expectedValues = new ArrayList<>();
        expectedValues.add(0);
        expectedValues.add(1);
        expectedValues.add(2);

        assertEquals(expectedValues, operand.getNumbers());
    }

    @Test
    void 정수_변환이_불가능한_입력값() {
        List<String> inputStrings = new ArrayList<>();
        inputStrings.add("1a");
        inputStrings.add("2");
        inputStrings.add("13");

        assertThrows(IllegalArgumentException.class, 
            () -> {
                Operand operand = new Operand(inputStrings);
            });
    }

    @Test
    void 정수_변환시_음수가_있는_리스트() {
        List<String> inputString = new ArrayList<>();
        inputString.add("1");
        inputString.add("2");
        inputString.add("-1");

        assertThrows(IllegalArgumentException.class, () -> {
            Operand operand = new Operand(inputString);
        });
    }
}