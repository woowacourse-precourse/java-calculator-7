package calculator.logic;

import calculator.dto.InputDTO;
import calculator.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class CalcLogic {
    public static List<Long> getNumbers( InputDTO input ) {
        String exp = input.getSumExp();
        String divider = input.getDividerExp();
        String dividerRegex = String.format( "[,:%s]", divider );

        // 수식 내 오류여부 확인
        Validator.checkSumExpValidity( exp, dividerRegex );

        // 숫자탐색
        return Arrays.stream( exp.split( dividerRegex ) )
                .map( Long::parseLong )
                .toList();
    }

    public static long sumAll( List<Long> numbers ) {
        return numbers.stream()
                .reduce(Long::sum)
                .orElse(0L);
    }
}
