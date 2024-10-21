package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Application {
    private static String delimitier = ",|:";

    public static void main(String[] args) {
        String operand = inPut();

        ArrayList<Integer> operandList = extractIntFromString(operand);

        int result = iterateCalculation(operandList);

        System.out.println("결과 : " + result);
    }

    public static String inPut() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static int add(int operandA, int operandB) {
        return operandA + operandB;
    }

    public static int iterateCalculation(ArrayList<Integer> operandList) {
        if (operandList.isEmpty()) {
            return 0;
        }
        int operandA = operandList.get(0);
        int listSize = operandList.size();

        for (int i = 1; i < listSize; i++) {
            int operandB = operandList.get(i);
            operandA = add(operandA, operandB);
        }
        return operandA;
    }

    public static ArrayList<Integer> extractIntFromString(String input) {
        String[] tmp = input.split(delimitier);

        // split된 값에 정수 이외의 값이 있는지 확인하는 로직 필요.

        ArrayList<Integer> operandList = new ArrayList<>();
        for (String stringValue : tmp) {
            int intValue = Integer.parseInt(stringValue);
            operandList.add(intValue);
        }
        return operandList;
    }
}
