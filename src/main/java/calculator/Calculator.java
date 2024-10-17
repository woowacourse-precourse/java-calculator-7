package calculator;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Calculator {
    private String str;
    private ArrayList<String> delims;

    Calculator() {
        str = "";
        delims = new ArrayList<>(Arrays.asList(",", ":"));
    }

    public String inputStr() {
        str = Console.readLine();
        return str;
    }

    public Optional<String> checkCustomDelim() {
        if (!str.startsWith("//")) {
            return Optional.empty();
        }

        String customDelim = str.substring(2, str.indexOf("\\n"));
        delims.add(customDelim);
        return Optional.of(customDelim);
    }
}
