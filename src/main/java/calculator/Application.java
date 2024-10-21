package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
        processInput(userInput);
    }

    public static void processInput(String input) {
        List<Long> numbers = new ArrayList<>();
        String delimiter = determineDelimiter(input);
        String[] inputArray = input.split(delimiter);
    }

    public static String determineDelimiter(String input) {
        if (!input.contains(";") && !input.contains(",")) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다. 쉼표 또는 세미콜론을 포함해야 합니다.");
        }
        return input.contains(";") ? ";" : ",";
    }
}
