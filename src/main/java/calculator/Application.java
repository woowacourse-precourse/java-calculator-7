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
                try {
                    int numberText = Integer.parseInt(text);    // 구분자 사이의 값이 숫자가 아니라면 예외 발생(NumberFormatException)
                    if (numberText < 0) throw new IllegalArgumentException();   // 구분자 사이의 숫자가 0보다 작으면 예외 발생
                    sum += numberText;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();   // IllegalArgumentException 예외로 발생
                }
            }
        }

        System.out.println("결과 : " + sum);

    }

}
