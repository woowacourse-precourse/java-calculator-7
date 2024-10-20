package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Calculator {
    public void calculate() {
        String input = readLine();
        String[] parsedInput = InputHandler.parse(input);
        int result = sumNumbers(parsedInput);
        System.out.println("결과 : " + result);
    }

    private int sumNumbers(String[] parsedInput) {
        int sum = 0;
        for (String strNum : parsedInput) {
            if (strNum.isEmpty()) {
                strNum = "0";
            }
            int intNum = Integer.parseInt(strNum);
            sum += intNum;
        }
        return sum;
    }
}
