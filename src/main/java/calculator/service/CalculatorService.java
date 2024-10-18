package calculator.service;

import java.util.Arrays;

public class CalculatorService {

    private final SeparatorCheck separatorCheck = new SeparatorCheck();
    private final SumCalculator sumCalculator = new SumCalculator();

    // 최종 계산 결과를 return 해야 하는 부분
    public int calculate(String input) {

        // input으로 들어온 값이 먼저 공백인지 판단
        // 참고: https://velog.io/@chosj1526/JAVA-String%EC%9D%B4-null%EC%9D%B8%EC%A7%80-empty%EC%9D%B8%EC%A7%80-%ED%99%95%EC%9D%B8
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 구분자로 나눠줌
        String[] nums = separatorCheck.split(input);
        System.out.println("The number that needs to be calculated is " + Arrays.toString(nums));

        // 계산 결과 return
//        return sumCalculator.sum(nums);
        return 1;
    }
}
