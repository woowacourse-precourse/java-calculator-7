package calculator;

import static calculator.StringParsing.StringValidateCheck;

public class Calculator {
    private static String[] UserInputArr;

    public static void run() {
        String userInput = CalStart.InputMessage();
        String delimiter = InputValidate.checkCustom(userInput);
        int sum = calculateSum(userInput, delimiter);

        System.out.println("결과 : " + sum);
    }

    public static int calculateSum(String UserInput, String delimiter) {
        if (delimiter.length() > 3) {
            UserInput = UserInput.substring(UserInput.indexOf("\\n") + 2);
        }
        UserInputArr = StringValidateCheck(UserInput, delimiter);
        return UserInputArrIsNum(UserInputArr);
    }

    public static int UserInputArrIsNum(String[] UserInputArr) {
        long sum = 0;

        for (String s : UserInputArr) {
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
//int범위아닌거 에러처리(보류), 변수명 수정, private