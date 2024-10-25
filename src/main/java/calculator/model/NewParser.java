package calculator.model;

public class NewParser {

    // 쉼표를 구분자로 가지는 문자열을 전달하는 경우
    // 구분자를 기준으로 분리한 각 숫자의 합 반환

    public static int sum(String inputString) {

        int sum = 0;

        String[] operands = inputString.split(",");

        for (String operand : operands) {
            sum += Integer.parseInt(operand);
        }

        return sum;
    }
}
