package calculator;

import calculator.arithmetic.Add;
import calculator.input.InputString;
import calculator.input.Parser;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputString inputString = new InputString();
        String st = inputString.input();

        Parser parser = new Parser(st);
        List<Integer> numbers = parser.getNumbers();

        Add add = new Add();
        Integer sum = add.addNum(numbers);

        System.out.println("결과 : "+ sum);
    }
}
