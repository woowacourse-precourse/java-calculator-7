package calculator.io;

import java.util.regex.Pattern;

public class InputConsoleHandler {

    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("(/{2})([^0-9 ]{1,})(\\\\n)");
    private static final Pattern OPERAND_PATTERN = Pattern.compile("-?\\d+([^0-9 ]{1,}-?\\d+)*");


}
