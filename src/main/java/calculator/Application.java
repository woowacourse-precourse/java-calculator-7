package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userText = Console.readLine();

        int sum = 0;

        if (!userText.isEmpty() && !userText.isBlank()) {
            String[] stringTokens = getStringTokens(userText);
            sum = generateSum(stringTokens, sum);
        }

        System.out.println("결과 : " + sum);

    }

    private static String[] getStringTokens(String userText) {
        String separator = ",|:";

        int firstIdx = userText.indexOf("//");
        int lastIdx = userText.indexOf("\\n");

        if (firstIdx > -1 && lastIdx > -1) {
            String customSeparator = "|" + userText.substring(firstIdx + 2, lastIdx);
            userText = userText.substring(lastIdx + 2);

            separator += customSeparator;
        }

        return userText.split(separator);
    }

    private static int generateSum(String[] stringTokens, int sum) {

        for (String text : stringTokens) {
            try {
                int numberText = Integer.parseInt(text);    // 구분자 사이의 값이 숫자가 아니라면 예외 발생(NumberFormatException)
                if (numberText < 0) throw new IllegalArgumentException();   // 구분자 사이의 숫자가 0보다 작으면 예외 발생
                sum += numberText;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();   // IllegalArgumentException 예외로 발생
            }
        }
        return sum;
    }

}
