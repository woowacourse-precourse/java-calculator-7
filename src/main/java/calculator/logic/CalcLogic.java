package calculator.logic;

import calculator.dto.InputDTO;

import java.util.Arrays;
import java.util.List;

public class CalcLogic {
    public static List<Long> getNumbers( InputDTO input ) {
        String exp = input.getSumExp();
        String divider = input.getDividerExp();
        String divider_regex = String.format( "[,:%s]", divider );

        // 수식 내 오류여부 확인
        for ( String expChar: exp.replaceAll("\\d", "").split("") ) {
            if ( expChar.length() == 0 ) continue;
            if ( !expChar.matches( divider_regex ) )
                throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        // 숫자탐색
        return Arrays.stream( exp.split( divider_regex ) )
                .map( Long::parseLong )
                .toList();
    }

    public static long sumAll( List<Long> numbers ) {
        return numbers.stream()
                .reduce(Long::sum)
                .orElse(0L);
    }
}
