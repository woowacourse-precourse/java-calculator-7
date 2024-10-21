package calculator;

import java.util.StringTokenizer;

import static calculator.ConsoleIO.*;
import static calculator.Separator.getSeparator;

public class Application {
    public static void main(String[] args) {
        String inputStr = readInput();

        String separators = getSeparator(inputStr);
        String numbers = inputStr;

        if (inputStr.startsWith("//")) {
            int newlineIndex = inputStr.indexOf("\\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식: 커스텀 구분자는 \\n을 포함해야 합니다.");
            }
            numbers = inputStr.substring(newlineIndex + 2);
        }

        StringTokenizer st = new StringTokenizer(numbers, separators);
        long answer = 0;
        while (st.hasMoreTokens()) {
            answer += Integer.parseInt(st.nextToken());
        }

        printOutput(answer);
    }


}

