package calculator.view;


import calculator.validation.*;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private InputView() {};

    public static String inputString() {
        String customSeperator = "";
        System.out.print(ViewMessage.INPUT_STRING);
        String input = Console.readLine();
        StartWithCharacter.validate(input);
        EndWithCharacter.validate(input);
        customSeperator = getCustomSeperator(input);
        CheckCustomSeperatorPos.validate(input);
        HasMultiCustomSeperators.validate(input, customSeperator);
        HasNegativeNumber.validate(input, customSeperator);
        return input;
    }
    private static String getCustomSeperator(String input) {
        String seperator = "";
        Pattern pattern = Pattern.compile("//(.+)\\\\n");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            seperator = matcher.group(1);
        }

        return seperator;
    }
}
