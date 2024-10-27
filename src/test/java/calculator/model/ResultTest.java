package calculator.model;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class ResultTest {

    @Test
    void 정수_리스트_입력시() {
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);

        Result result = new Result(inputList);

        int expectedValues = 6;
        assertEquals(expectedValues, result.getValue());
    }
    
}
