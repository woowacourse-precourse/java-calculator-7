package calculator.function;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void 일반_정수_덧셈(){
        //given
        List<String> inputStrings = new ArrayList<>();
        inputStrings.add("2");
        inputStrings.add("3");

        //when
        Calculator calculator = new Calculator(inputStrings);
        String result = calculator.execute();

        //then
        assertEquals("5", result);

    }

    @Test
    void carry가_발생하는_정수_덧셈(){
        //given
        List<String> inputStrings = new ArrayList<>();
        inputStrings.add("5");
        inputStrings.add("7");

        //when
        Calculator calculator = new Calculator(inputStrings);
        String result = calculator.execute();

        //then
        assertEquals("12", result);
    }

    @Test
    void Long_범위를_벗어나는_정수_덧셈(){
        //given
        List<String> inputStrings = new ArrayList<>();
        inputStrings.add("100000000000000000000");
        inputStrings.add("100000000000000000000");

        //when
        Calculator calculator = new Calculator(inputStrings);
        String result = calculator.execute();

        //then
        assertEquals("200000000000000000000", result);

    }

    @Test
    void 빈_문자열을_포함하는_정수_덧셈(){
        //given
        List<String> inputStrings = new ArrayList<>();
        inputStrings.add("");
        inputStrings.add("20");

        //when
        Calculator calculator = new Calculator(inputStrings);
        String result = calculator.execute();

        //then
        assertEquals("20", result);
    }
    @Test
    void Carry가_중간에_발생하는_정수_덧셈(){
        //given
        List<String> inputStrings = new ArrayList<>();
        inputStrings.add("13531");
        inputStrings.add("741");

        //when
        Calculator calculator = new Calculator(inputStrings);
        String result = calculator.execute();

        //then
        assertEquals("14272", result);
    }
}