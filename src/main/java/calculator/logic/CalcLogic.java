package calculator.logic;

import calculator.dto.InputDTO;

import java.util.Arrays;
import java.util.List;

public class CalcLogic {
    public static List<Long> getNumbers( InputDTO input ) {
        String exp = input.calcExp();

        return Arrays.stream(exp.split( "[,:]" ))
                .map( Long::parseLong )
                .toList();
    }

    public static long sumAll( List<Long> numbers ) {
        return numbers.stream()
                .reduce(Long::sum)
                .orElse(0L);
    }
}
