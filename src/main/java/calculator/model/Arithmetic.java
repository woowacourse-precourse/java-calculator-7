package calculator.model;

import java.util.Arrays;
import java.util.List;

public class Arithmetic {
    private List<Integer> arithmetic;

    public Arithmetic(String arithmetic) {
        this.arithmetic = splitArithmetic(arithmetic);
    }

    public List<Integer> splitArithmetic(String calculatorPart) {
        List<Integer> result =
                Arrays.stream(
                        calculatorPart.split(new DefaultDelimiter().delimiter))
                        .map(Integer::parseInt).toList();

        return result;
    }

    public List<Integer> getArithmetic() {
        return arithmetic;
    }
}
