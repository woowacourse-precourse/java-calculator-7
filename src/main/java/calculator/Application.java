package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        if (str.isEmpty()) {
            System.out.print("결과 : 0");
            return;
        }

        ArrayList<String> delimiters = new ArrayList<>(List.of(",", ":"));

        if (str.startsWith("//")) {
            int delimiterIndex = str.indexOf("\\n");
            if (delimiterIndex != -1) {
                String customDelimiter = str.substring(2, delimiterIndex);
                for (char c : customDelimiter.toCharArray()) {
                    if (Character.isDigit(c)) {
                        throw new IllegalArgumentException();
                    }
                }
                delimiters.add(customDelimiter);
                str = str.substring(delimiterIndex + 2);
                if (str.isEmpty()) {
                    System.out.print("결과 : 0");
                    return;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }

        String splitDelimiters = String.join("|", delimiters);
        String[] separatedNumbers = str.split(splitDelimiters);

        int result = 0;

        for (String number : separatedNumbers) {
            try {
                int parsedNumber = Integer.parseInt(number);
                if (parsedNumber <= 0) {
                    throw new IllegalArgumentException();
                }
                result += parsedNumber;
            }
            catch (NumberFormatException ex) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println("결과 : " + result);
        Console.close();
    }
}