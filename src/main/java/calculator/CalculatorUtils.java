package calculator;

public class CalculatorUtils {

    public int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다.");
        }
    }

    public int intSum(String[] inputArr) {
        int answer = 0;
        for (String s : inputArr) {
            if (parseInt(s) < 0) {
                throw new IllegalArgumentException("입력한 값 중, 음수가 포함되어 있습니다.");
            }
            answer += parseInt(s);
        }
        return answer;
    }
}
