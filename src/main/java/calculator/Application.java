package calculator;

import calculator.arithmetic.Add;
import calculator.input.InputString;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputString st = new InputString();
        List<Integer> numbers = st.input();

        Add add = new Add();
        Integer sum = add.addNum(numbers);

        System.out.println("결과 : "+ sum);
    }
}
