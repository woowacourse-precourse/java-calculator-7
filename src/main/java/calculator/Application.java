package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userText = Console.readLine();

        int sum = 0;

        if (!userText.isEmpty() && !userText.isBlank()) {
            String[] splitTexts = userText.split(",|:");

            for (String text : splitTexts) {
                int numberText = Integer.parseInt(text);
                sum += numberText;
            }
        }

        System.out.println("결과 : " + sum);

    }

}
