package calculator;
//1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우
// 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
//        예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" =>

public class DelimiterCalculator {
    public int sum;
    private String input;
    public DelimiterCalculator (String input) {
        this.input = input;

        String[] numbers = input.split(",| :");
        sum = 0;
        // 숫자가 아닌 값이 포함되어 있는지 확인 및 합계 계산
        for (String number : numbers) {
            try {
                int value = Integer.parseInt(number);  // 숫자로 변환 시도
                sum += value;  // 변환에 성공하면 합계에 더함
            } catch (NumberFormatException e) {
                // 변환에 실패하면 IllegalArgumentException 발생
                throw new IllegalArgumentException("Invalid input: " + number);
            }
        }
    }
}
