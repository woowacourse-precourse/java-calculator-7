package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String calculationInput = getCalculationInput();
        List<Integer> operands = decodeCalculationInput(calculationInput);
        System.out.println("결과 : " + addAll(operands));
    }

    private static String getCalculationInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private static List<Integer> decodeCalculationInput(String calculationInput) {
        List<String> operands = List.of(calculationInput.split("[,:]"));
        return operands.stream().map(Integer::valueOf).toList();
    }

    private static Integer addAll(List<Integer> operands) {
        return operands.stream().mapToInt(operand -> operand).sum();
    }

}
