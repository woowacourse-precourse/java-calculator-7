package calculator.service;

public class CalculatorService {

    private final SeparatorCheck separatorCheck = new SeparatorCheck();
    private final SumCalculator sumCalculator = new SumCalculator();

    // 최종 계산 결과를 return 해야 하는 부분
    public int calculate(String input) {

        // input으로 들어온 값이 먼저 공백인지 판단
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 구분자로 나눠줌
        String[] splitWords = separatorCheck.split(input);

        if (splitWords.length == 0) {
            throw new IllegalArgumentException("숫자도 함께 입력해주세요.");
        }

        // 계산 결과 return
        return sumCalculator.sum(splitWords);
    }
}
