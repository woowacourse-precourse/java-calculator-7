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
            Console.close();
        }

        ArrayList<String> delimiters = new ArrayList<>(List.of(",", ":"));

        if (str.startsWith("//")) {
            int delimiterIndex = str.indexOf("\\n");
            if (delimiterIndex != -1) {
                String customDelimiter = str.substring(2, delimiterIndex);
                delimiters.add(customDelimiter);
                str = str.substring(delimiterIndex + 2);
            } else {
                throw new IllegalStateException();
            }
        }

        String splitDelimiters = String.join("|", delimiters);
    }
}