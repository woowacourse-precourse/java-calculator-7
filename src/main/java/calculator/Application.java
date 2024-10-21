package calculator;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        String input = Console.readLine();
        int result = application.calculate(input);
        System.out.println("결과 : " + result);
    }

    public int calculate(String text) {
        String defaultSeparator = ":";
        String[] textArray = replaceSeparator(text, defaultSeparator).split(defaultSeparator);
        int sum = 0;
        for (String number : textArray) {
            try {
                sum += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return sum;
    }

    private String replaceSeparator(String text, String separator) {
        return text.replaceAll(",", separator);
    }

}
