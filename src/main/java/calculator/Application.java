package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final String delimiterIdentifier = "^//(.*)\\n";  // 구분자를 식별하는 정규식 문자열
    private static String delimiter = ",|:"; // 정규식 구분자 모음

    public static void main(String[] args) {
        String operand = inPut();

        ArrayList<Integer> operandList = extractIntFromString(operand);

        int result = iterateCalculation(operandList);

        System.out.println("결과 : " + result);
    }

    public static String inPut() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        input = input.replace("\\n", "\n"); // \n을 개행문자로 인식하지 못해 이를 처리
        return addCustomDelimiter(input);
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
        String[] tmp = input.split(delimiter);

        // split된 값에 정수 이외의 값이 있는지 확인하는 로직 필요.

        ArrayList<Integer> operandList = new ArrayList<>();
        for (String stringValue : tmp) {
            int intValue = Integer.parseInt(stringValue);
            operandList.add(intValue);
        }
        return operandList;
    }

    public static String addCustomDelimiter(String input) {
        Pattern delimiterPattern = Pattern.compile(delimiterIdentifier);
        Matcher delimiterMatcher = delimiterPattern.matcher(input);
        if (delimiterMatcher.find()) {
            delimiter += "|" + delimiterMatcher.group(1);
            int startIndexOfOperand = delimiterMatcher.end(1) + 1;
            return input.substring(startIndexOfOperand);
        }
        return input;
    }
}
