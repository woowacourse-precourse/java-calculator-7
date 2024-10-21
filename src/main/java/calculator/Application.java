package calculator;

import java.util.StringTokenizer;

import static calculator.ConsoleIO.*;
import static calculator.Extractor.extractNumbers;
import static calculator.Separator.getSeparator;

public class Application {
    public static void main(String[] args) {
        String inputStr = readInput();

        String separators = getSeparator(inputStr);
        String numbers = extractNumbers(inputStr);

        StringTokenizer st = new StringTokenizer(numbers, separators);
        long answer = 0;
        while (st.hasMoreTokens()) {
            answer += Integer.parseInt(st.nextToken());
        }

        printOutput(answer);
    }

}

