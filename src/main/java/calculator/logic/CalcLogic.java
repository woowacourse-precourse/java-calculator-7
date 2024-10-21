package calculator.logic;

import calculator.dto.InputDTO;

import java.util.Arrays;
import java.util.List;

public class CalcLogic {
    public static List<Integer> getNumbers( InputDTO input ) {
        String exp = input.calcExp();

        return Arrays.stream(exp.split( "[,:]" ))
                .map( Integer::parseInt )
                .toList();
    }

    public static int sumAll( List<Integer> numbers ) {
        return numbers.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }
}
