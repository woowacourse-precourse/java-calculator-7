package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        ArrayList<String> sep = new ArrayList<>(Arrays.asList(",", ":"));

        if (input.startsWith("//")) {
            int customSepIndexEnd = input.indexOf("\n");
            String newSep = input.substring(2, customSepIndexEnd).trim();
            sep.add(newSep);
        }
    }
}
