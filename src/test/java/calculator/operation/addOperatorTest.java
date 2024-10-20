package calculator.operation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class addOperatorTest {

    private addOperator addOperator = new addOperator();

    @Test
    @DisplayName("더하기 테스트")
    void plusTest(){
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int result = addOperator.operate(numbers);
        assertEquals(55, result);

    }
}