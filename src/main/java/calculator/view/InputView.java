package calculator.view;


import calculator.validation.*;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private InputView() {}

    public static String[] inputString() {
        String customDelimiter = "";
        System.out.print(ViewMessage.INPUT_STRING);
        String input = Console.readLine();
        Console.close();
        customDelimiter = validate(input);

        return new String[]{input, customDelimiter};
    }

    private static String validate(String input) {
        String customDelimiter = "";
        StartWithCharacter.validate(input);
        EndWithCharacter.validate(input);
        customDelimiter = getCustomDelimiter(input);
        CheckCustomDelimiterPos.validate(input);
        HasMultiCustomDelimiters.validate(input, customDelimiter);
        HasNegativeNumber.validate(input, customDelimiter);

        return customDelimiter;
    }

    private static String getCustomDelimiter(String input) {
        String delimiter = "";
        Pattern pattern = Pattern.compile("//(.+)\\\\n");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            delimiter = matcher.group(1);
        }

        return delimiter;
    }
}
