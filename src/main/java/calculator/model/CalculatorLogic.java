package calculator.model;

import java.util.List;
import java.util.stream.Stream;

public class CalculatorLogic {

    public String extractDelimiter(String input) {
        if (input.startsWith("//")) {
            return input.substring(2, 3); //bufferedReader 통해 라인 단위 입력 받음 -> 개행문자 전까지만 input 들어올 것
        }
        return ",|:"; //정규식 문법으로 , 또는 :를 구분자로 인식함(|는 or)
    }

    public List<Integer> extractNumbers(String input, String delimiter) {
        String[] numbers = input.split(delimiter);
        //arr to stream -> Integer 변환 후 다시 list로 변환
        //toList()로 인해 List 불변이지만 단순 덧셈에 사용되기에 문제 없다고 판단
        return Stream.of(numbers)
                .map(Integer::parseInt)
                .toList();
    }

    public int calculate(List<Integer> numbers) {
        //Integer 객체에 대해서는 sum()사용 불가, int로 unboxing 필요
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
