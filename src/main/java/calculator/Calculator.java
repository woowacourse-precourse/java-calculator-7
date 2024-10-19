package calculator;

import static calculator.StringParsing.stringValidateCheck;

public class Calculator {

    public static void run() {
        String userInput = CalStart.inputMessage();
        String delimiter = InputValidate.checkCustom(userInput);
        int sum = calculateSum(userInput, delimiter);

        System.out.println("결과 : " + sum);
    }

    private static int calculateSum(String userInput, String delimiter) {
        if (delimiter.length() > 3) {
            userInput = userInput.substring(userInput.indexOf("\\n") + 2);
        }
        String[] userInputArr = stringValidateCheck(userInput, delimiter); // 이름이 validate인데 validate를 안함
        return userInputArrIsNum(userInputArr); // 이 메서드에서 validate를 하고 있음
    }

    private static int userInputArrIsNum(String[] userInputArr) {
        long sum = 0;

        for (String s : userInputArr) {
            if (s.isEmpty()) {
                continue;
            }
            try {
                //int num = Integer.parseInt(s);
                //sum += num;
                long num = Long.parseLong(s);
                sum += num;

                if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                    throw new IllegalArgumentException("합계가 int 범위를 벗어났습니다");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다");
            }
        }
        return (int) sum;
    }
}