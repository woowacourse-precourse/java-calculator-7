package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Application {
    private static String delimitier = ",|:";

    public static void main(String[] args) {
        String operand = inPut();

        ArrayList<Integer> result = extractIntFromString(operand);
        System.out.println("결과 : ");
        for (int output : result) {
            System.out.println(output);
        }
    }

    public static String inPut() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static int add(int operandA, int operandB) {
        return operandA + operandB;
    }

    public static int iterateCalculation(Queue<Integer> operandQueue) {
        if (operandQueue.peek() == null) {
            return 0;
        }

        int operandA = operandQueue.poll();
        while (!operandQueue.isEmpty()) {
            int operandB = operandQueue.poll();
            operandA = add(operandA, operandB);
        }
        return operandA;
    }

    public static ArrayList<Integer> extractIntFromString(String input) {
        String[] tmp = input.split(delimitier);

        // split된 값에 정수 이외의 값이 있는지 확인하는 로직 필요.

        ArrayList<Integer> operands = new ArrayList<>();
        for (String stringValue : tmp) {
            int intValue = Integer.parseInt(stringValue);
            operands.add(intValue);
        }
        return operands;
    }
}
