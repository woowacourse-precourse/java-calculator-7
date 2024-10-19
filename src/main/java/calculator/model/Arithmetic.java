package calculator.model;

import java.util.Arrays;
import java.util.List;

public class Arithmetic {
    private List<Integer> arithmetic;

    public Arithmetic(Delimiter delimiter, String arithmetic) {
        this.arithmetic = splitArithmetic(delimiter,arithmetic);
    }

    public List<Integer> splitArithmetic(Delimiter delimiter, String calculatorPart) {
        List<Integer> result =
                Arrays.stream(calculatorPart.split("[" + delimiter.delimiter + "]"))
                        .map(Integer::parseInt).toList();

        return result;
    }

    public List<Integer> getArithmetic() {
        return arithmetic;
    }

}
