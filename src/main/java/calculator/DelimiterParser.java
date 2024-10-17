package calculator;

public class DelimiterParser {
    public String[] parse(String input) {
        String delimiter = ",|:";

        if ((input.startsWith("//"))&&(input.contains("\n"))) {
            int newLineIndex = input.indexOf("\n");
            delimiter=input.substring(2,newLineIndex);
            input=input.substring(newLineIndex+1);
        }
        return input.split(delimiter);
    }
}
