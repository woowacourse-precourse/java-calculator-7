package calculator.converter;

public class EscapeNewLineConverter {

    public String convert(String input) {
        return input.replace("\\n", "\n");
    }

}