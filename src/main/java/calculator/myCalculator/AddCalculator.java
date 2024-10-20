package calculator.myCalculator;

import calculator.extractor.NumberExtractor;

import java.util.List;
import java.util.Optional;

public class AddCalculator {

    // 숫자 리스트를 받으면 다 더한 결과를 반환
    public Integer addNumbers(List<Integer> numList) {
        return numList.stream().reduce((a, b) -> a+b).orElse(0);
    }
}