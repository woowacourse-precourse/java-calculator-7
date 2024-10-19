package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arithmetic {
    private List<Integer> arithmetic;

    public Arithmetic(Delimiter delimiter, InputData inputData) {
        this.arithmetic = splitArithmetic(delimiter, inputData.convertCalculatorPart());
    }

    public List<Integer> splitArithmetic(Delimiter delimiter, String calculatorPart) {
        List<String> temp = Arrays.stream(
                        calculatorPart.split("[" + new DefaultDelimiter().getDelimiter() + "]"))
                .toList();

        if (delimiter.getClass() == CustomDelimiter.class) {
            temp = temp.stream()
                    .flatMap(str -> Arrays.stream(str.split("[" + delimiter.getDelimiter() + "]")))
                    .toList();
        }

        return temp.stream().map(Integer::parseInt).toList();
    }

    public List<Integer> getArithmetic() {
        return arithmetic;
    }

}
